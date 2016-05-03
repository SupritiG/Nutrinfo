package com.example.sgupta.nutrinfo;

/**
 * Created by Supriti on 2/5/2016.
 */

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.security.Timestamp;
import java.util.Date;

import io.realm.Realm;
import io.realm.RealmList;

public class AddNewItemFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    private EditText mfood_name;
    private EditText mfood_source;
    private EditText mportion_name;
    private EditText mcalories;
    private EditText mproteins;
    private EditText mtotalcarbs;
    private EditText mtotalfats;

    private Realm realm;

    public static AddNewItemFragment newInstance() {
        AddNewItemFragment fragment = new AddNewItemFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public AddNewItemFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_new_item, container, false);
        initializeViews(view);
        //Image button listener
        ImageButton button= (ImageButton) view.findViewById(R.id.save_new_item_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
                FragmentManager fragmentManager = getFragmentManager();

                fragmentManager.beginTransaction()
                        .replace(R.id.container, HomeFragment.newInstance())
                        .addToBackStack("tag")
                        .commit();
            }
        });
        return view;

    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {

        public void onFragmentInteraction(Uri uri);
    }


    public void initializeViews(View view)
    {
        mfood_name = (EditText) view.findViewById(R.id.add_name);
        mfood_source = (EditText) view.findViewById(R.id.add_source);
        mportion_name = (EditText) view.findViewById(R.id.add_portion_name);
        mcalories = (EditText) view.findViewById(R.id.add_calories_value);
        mproteins = (EditText) view.findViewById(R.id.add_proteins_value);
        mtotalcarbs = (EditText) view.findViewById(R.id.add_total_carbs_value);
        mtotalfats = (EditText) view.findViewById(R.id.add_total_fats_value);
    }



    public void saveData()
    {
        String name = mfood_name.getText().toString();
        String source = mfood_source.getText().toString();
        String portion_name = mportion_name.getText().toString();

        Important imp = new Important();

        if (!mcalories.getText().toString().equals("")){
            Float calories = Float.valueOf(mcalories.getText().toString());
            NutrientUnit cal_ni = new NutrientUnit();
            cal_ni.setValue(calories);
            imp.setCalories(cal_ni);
        }

        if(!mproteins.getText().toString().equals("")){
            Float calories = Float.valueOf(mproteins.getText().toString());
            NutrientUnit cal_ni = new NutrientUnit();
            cal_ni.setValue(calories);
            imp.setProtein(cal_ni);
        }

        if(!mtotalcarbs.getText().toString().equals("")){
            Float calories = Float.valueOf(mtotalcarbs.getText().toString());
            NutrientUnit cal_ni = new NutrientUnit();
            cal_ni.setValue(calories);
            imp.setTotal_carbs(cal_ni);
        }

        if(!mtotalfats.getText().toString().equals("")){
            Float calories = Float.valueOf(mtotalfats.getText().toString());
            NutrientUnit cal_ni = new NutrientUnit();
            cal_ni.setValue(calories);
            imp.setTotal_fats(cal_ni);
        }

        Nutrient nutrient = new Nutrient();
        nutrient.setImportant(imp);

        Portion portion = new Portion();
        portion.setName(portion_name);
        portion.setNutrients(nutrient);


        realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        Food food = realm.createObject(Food.class);
        food.setName(name);
        food.setSource(source);
        RealmList<Portion> list = new RealmList<>();
        list.add(portion);
        food.setPortions(list);
        Date date = new Date();
        food.set_id(name+String.valueOf(date.getTime()));
        realm.commitTransaction();

        Toast.makeText(getActivity(), "Saved", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause()
    {
        super.onPause();
        if(realm != null) {
            realm.close();
        }

    }





}
