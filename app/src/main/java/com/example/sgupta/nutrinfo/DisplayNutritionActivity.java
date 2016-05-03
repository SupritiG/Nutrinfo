package com.example.sgupta.nutrinfo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Message;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationSet;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;


public class DisplayNutritionActivity extends ActionBarActivity {

    private static final String KCAL = "kcal";
    private static final String MILLIG = "mg";
    private static final String GRAM = "g";
    private static final String MCG = "mcg";

    private float CAL_DV = 2000;
    private float PROTEIN_DV = 50;
    private float FATS_DV = 65;
    private float CARBS_DV = 300;

    private String mSearchItemId;
    private Realm realm;
    private NutrientItemListAdapter mAdapter;
    private int mSelectedPortionPosition;

    private List<String> mPortion_Names;

    private ActionBar mActionBar;
    private Spinner mServingSpinner;
    private RecyclerView recyclerView;
    private List<NutrientItem> nutrientList = new ArrayList<>();

    private ProgressBar mCaloriesBar;
    private ProgressBar mProteinsBar;
    private ProgressBar mFatsBar;
    private ProgressBar mCarbsBar;

    private TextView mCaloriesText;
    private TextView mProteinsText;
    private TextView mFatsText;
    private TextView mCarbsText;

    private TextView mCaloriesPercent;
    private TextView mProteinsPercent;
    private TextView mFatsPercent;
    private TextView mCarbsPercent;

    private Food mFoodItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_nutrition);

        mActionBar = getSupportActionBar();
        mActionBar.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP|ActionBar.DISPLAY_SHOW_TITLE);

        //Get the position of selected item in the list
        Bundle b = getIntent().getExtras();
        mSearchItemId = b.getString("id");

        //Get the instance of database
        realm = Realm.getDefaultInstance();

        initializeViews();

        spinnerSetup();


        //Set the adaptor for recycler list view
        mAdapter = new NutrientItemListAdapter(nutrientList, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareData();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_nutrition, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                //NavUtils.navigateUpFromSameTask(this);
                break;
        }
        //noinspection SimplifiableIfStatement
       /* if (id == R.id.action_settings) {
            return true;
        }*/

        if(id == R.id.action_info){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Percentage values show the fraction of daily recommended nutrient " +
                    "contained in the food item based on a 2000 kcal diet. Source: Dietary Supplement " +
                    "Label Database, National Institue of Health 2015")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //do things
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        if(realm != null)
        {
            realm.close();
        }
    }

    /*
    Method to setup the spinner, set the on click listener and data adapter
     */
    public void spinnerSetup()
    {
        mServingSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                //Toast.makeText(getApplicationContext(),"item selected" + String.valueOf(pos), Toast.LENGTH_SHORT).show();
                mSelectedPortionPosition = pos;
                getPortionData();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }


        });

        // Get the portion names
        setSpinnerData();

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, mPortion_Names);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        mServingSpinner.setAdapter(dataAdapter);
    }

    public void setSpinnerData()
    {
        mPortion_Names = new ArrayList<String>();

        mFoodItem = realm.where(Food.class).equalTo("_id", mSearchItemId).findFirst();
        mActionBar.setTitle(mFoodItem.getName());
        //String food_nam = mFoodItem.getName();
        int num_portions = mFoodItem.getPortions().size();

        //Add the name of portions to spinner list
        for(int i = 0; i < num_portions; i++)
        {
            mPortion_Names.add(mFoodItem.getPortions().get(i).getName());
        }
    }

    //Method to test the adapter and recycler view
    private void prepareData(){
        NutrientItem f1 = new NutrientItem("apple","12 g");
        NutrientItem f2 = new NutrientItem("apple","12 kcal");

        nutrientList.add(f1);
        nutrientList.add(f2);

        mAdapter.notifyDataSetChanged();
    }

    /*
    Method to retrieve the nutrient values of selected portion from the database. Method also sets the values in the views
     */
    private void getPortionData()
    {
        //Clear the existing data in nutrientList
        nutrientList.clear();
        Log.v("GetPOrtionData method", "here");
        if (mFoodItem == null)
        {
            Log.v("GetPortionData method", "no food selected");
            return;
        }

        Important imp_nutrient = mFoodItem.getPortions().get(mSelectedPortionPosition).getNutrients().getImportant();
        Extra extra_nutrient = mFoodItem.getPortions().get(mSelectedPortionPosition).getNutrients().getExtra();

        NutrientUnit nutrient;

        nutrient = imp_nutrient.getCalories();
        ProgressBarAnimation calAnimation = updateProgressBar(nutrient, mCaloriesBar, KCAL, mCaloriesText, CAL_DV, mCaloriesPercent);

        nutrient = imp_nutrient.getProtein();
        ProgressBarAnimation proteinsAnimation = updateProgressBar(nutrient, mProteinsBar, GRAM, mProteinsText, PROTEIN_DV, mProteinsPercent);

        //addNutrientsToList(nutrient, "Dietary Fibre", GRAM);

        nutrient = imp_nutrient.getDietary_fibre();
        addNutrientsToList(nutrient, "Dietary Fiber", GRAM);

        nutrient = imp_nutrient.getTotal_fats();
        addNutrientsToList(nutrient, "Total(T.) Fats", GRAM);
        ProgressBarAnimation fatsAnimation = updateProgressBar(nutrient, mFatsBar, GRAM, mFatsText, FATS_DV, mFatsPercent);

        nutrient = imp_nutrient.getSaturated();
        addNutrientsToList(nutrient, "     Saturated", GRAM);

        nutrient = imp_nutrient.getPolyunsaturated();
        addNutrientsToList(nutrient, "     Polyunsaturated", GRAM);

        nutrient = imp_nutrient.getMonounsaturated();
        addNutrientsToList(nutrient, "     Monounsaturated", GRAM);

        nutrient = imp_nutrient.getTrans();
        addNutrientsToList(nutrient, "     Trans", MILLIG);

        nutrient = imp_nutrient.getTotal_carbs();
        addNutrientsToList(nutrient, "Total(T.) Carbohydrates", GRAM);
        ProgressBarAnimation carbsAnimation = updateProgressBar(nutrient, mCarbsBar, GRAM, mCarbsText, CARBS_DV, mCarbsPercent);

        nutrient = imp_nutrient.getSugar();
        addNutrientsToList(nutrient, "     Sugar", GRAM);

        nutrient = imp_nutrient.getCholestrol();
        addNutrientsToList(nutrient, "Cholestrol", MILLIG);

        nutrient = imp_nutrient.getSodium();
        addNutrientsToList(nutrient, "Sodium", MILLIG);

        nutrient = imp_nutrient.getPotassium();
        addNutrientsToList(nutrient, "Potassium", MILLIG);

        nutrient = extra_nutrient.getVitamin_a();
        addNutrientsToList(nutrient, "Vitamin A", MCG);

        nutrient = extra_nutrient.getPhosphorous();
        addNutrientsToList(nutrient, "Phosphorous", MILLIG);

        nutrient = extra_nutrient.getRetinol();
        addNutrientsToList(nutrient, "Retinol", MILLIG);

        nutrient = extra_nutrient.getIron();
        addNutrientsToList(nutrient, "Iron", MILLIG);

        nutrient = extra_nutrient.getThiamin();
        addNutrientsToList(nutrient, "Thiamin", MILLIG);

        nutrient = extra_nutrient.getSelenium();
        addNutrientsToList(nutrient, "Selenium", MCG);

        nutrient = extra_nutrient.getStarch();
        addNutrientsToList(nutrient, "Starch", GRAM);

        nutrient = extra_nutrient.getZinc();
        addNutrientsToList(nutrient, "Zinc", MILLIG);

        nutrient = extra_nutrient.getWater();
        addNutrientsToList(nutrient, "Water", GRAM);

        nutrient = extra_nutrient.getRiboflavin();
        addNutrientsToList(nutrient, "Riboflavin", MILLIG);

        nutrient = extra_nutrient.getCalcium();
        addNutrientsToList(nutrient, "Calcium", MILLIG);

        nutrient = extra_nutrient.getVitamin_c();
        addNutrientsToList(nutrient, "Vitamin C", MILLIG);

        nutrient = extra_nutrient.getB_carotene();
        addNutrientsToList(nutrient, "B-Carotene", MILLIG);

        AnimationSet bars_animation = new AnimationSet(true);
        //spriteAnimation.addAnimation(rotate);
        if(calAnimation != null)
        {
            bars_animation.addAnimation(calAnimation);
        }
        if(proteinsAnimation != null)
        {
            bars_animation.addAnimation(proteinsAnimation);
        }
        if(fatsAnimation != null)
        {
            bars_animation.addAnimation(fatsAnimation);
        }
        if(carbsAnimation != null)
        {
            bars_animation.addAnimation(carbsAnimation);
        }


        bars_animation.setDuration(5000);

        bars_animation.start();

        mAdapter.notifyDataSetChanged();
    }

    /*
    Method to add nutrients to listadapter for display
     */
    public void addNutrientsToList(NutrientUnit nutrient, String name, String unit)
    {
        if (nutrient != null)
        {
            nutrientList.add(new NutrientItem(name, String.valueOf(nutrient.getValue())+ " " + unit));
        }
    }


    /*
    Method to update the progress bar for calories, proteins, total fats and total carbs nutrients
     */
    public ProgressBarAnimation updateProgressBar(NutrientUnit nutrient, ProgressBar bar, String unit, TextView text, Float daily_val, TextView text_percent)
    {
        if (nutrient != null)
        {
            if(daily_val == CAL_DV)
            {
                Float c = Float.valueOf(nutrient.getValue());
                Integer i = Math.round(c);
                text.setText(String.valueOf(i) + " " + unit);
            }else{
                text.setText(nutrient.getValue() + " " + unit);
            }
            Float percent_val = Float.valueOf(nutrient.getValue())*100/daily_val;
            double d = percent_val.doubleValue();
            String result = String.format("%.2f", d);
            //java.lang.Math.round(d*100.0)/100.0;
            text_percent.setText(result+"%");
            ProgressBarAnimation anim = new ProgressBarAnimation(bar, 0, percent_val);
            bar.startAnimation(anim);
            return anim;
        }
        else{
            return null;
        }
    }

    /*
    Initialize the views in the layout
     */
    public void initializeViews()
    {
        mServingSpinner = (Spinner) findViewById(R.id.spinner_serving);
        mCaloriesBar = (ProgressBar) findViewById(R.id.progress_calories);
        mProteinsBar = (ProgressBar) findViewById(R.id.progress_proteins);
        mFatsBar = (ProgressBar) findViewById(R.id.progress_sugar);
        mCarbsBar = (ProgressBar) findViewById(R.id.progress_carbs);

        mCaloriesText = (TextView) findViewById(R.id.value_calories);
        mProteinsText = (TextView) findViewById(R.id.value_proteins);
        mFatsText = (TextView) findViewById(R.id.value_sugar);
        mCarbsText = (TextView) findViewById(R.id.value_carbs);

        mCaloriesPercent = (TextView) findViewById(R.id.percent_calories);
        mProteinsPercent = (TextView) findViewById(R.id.percent_proteins);
        mFatsPercent = (TextView) findViewById(R.id.percent_sugar);
        mCarbsPercent = (TextView) findViewById(R.id.percent_carbs);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_nutrients);
    }
}

