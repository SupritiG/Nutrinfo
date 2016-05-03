package com.example.sgupta.nutrinfo;

import android.app.Activity;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;


public class MainActivity2 extends ActionBarActivity {

    private CharSequence mTitle;
    private ActionBar mActionBar;
    private AutoCompleteTextView mSearchText;
    private ImageButton mClearSearchBar;

    private Realm realm;

    private static final String[] FRUITS = new String[] {
            "Apple", "Banana", "Cherry", "Watermelon", "Muskmelon", "Kiwi", "Grapes", "Mangosteen", "Mango", "Strawberry"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTitle = getTitle();

        //Action bar settings
        mActionBar = getSupportActionBar();
        mActionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM|ActionBar.DISPLAY_SHOW_TITLE);

        //Instantiate the home fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, HomeFragment.newInstance())
                .commit();

        //Configure the Realm database and set the configuration as default
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
                .name("foodtestnew1")
                .deleteRealmIfMigrationNeeded()
                .build();

        //deleteRealm(realmConfiguration);

        //Set the instantiated realm configuration as default
        Realm.setDefaultConfiguration(realmConfiguration);
        //realm = Realm.getInstance(realmConfiguration);

    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        restoreActionBar();
        return super.onCreateOptionsMenu(menu);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        final FragmentManager fragmentManager = getSupportFragmentManager();

        if (id==android.R.id.home){
            onBackPressed();
            return true;
        }

       /* if(id == R.id.action_add_new_item){
            fragmentManager.beginTransaction()
                    .replace(R.id.container, AddNewItemFragment.newInstance())
                    .addToBackStack("tag")
                    .commit();
            return true;
        }*/

        if(id == R.id.action_search){

            View v = item.getActionView();

            //Set up the search bar
            mSearchText =  (AutoCompleteTextView) v.findViewById(R.id.search_text);
            mClearSearchBar = (ImageButton) v.findViewById(R.id.search_bar_clear);

            mClearSearchBar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mSearchText.setText("");
                    //Log.v("clear button", "button listener");
                }
            });

            //Set the adapter for suggestion based search
            realm = Realm.getDefaultInstance();
            RealmResults<Food> realm_list = realm.where(Food.class).findAll();
            //ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, FRUITS);
            FilterableRealmAdapter realmadapter = new FilterableRealmAdapter(this, realm_list, mSearchText);
            //mSearchText.setAdapter(adapter);
            mSearchText.setAdapter(realmadapter);
            mSearchText.setThreshold(2);


            mSearchText.requestFocus();
            mSearchText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                        String search_food_name = mSearchText.getText().toString();

                        //Start the FoodSearchListFragment when the user presses enter on search bar
                        fragmentManager.beginTransaction()
                                .replace(R.id.container, FoodSearchListFragment.newInstance(search_food_name))
                                .addToBackStack("tag")
                                .commit();

                        return true;
                    }
                    return false;
                }
            });
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    /*
    Method to delete the existing Realm configuration. Use while changing the schema.
    IMPORTANT: Erases all the data.
     */
    public void deleteRealm(RealmConfiguration config)
    {
        Realm.setDefaultConfiguration(config);
        realm = Realm.getInstance(config);
        realm.close();
        Realm.deleteRealm(config);
    }

}
