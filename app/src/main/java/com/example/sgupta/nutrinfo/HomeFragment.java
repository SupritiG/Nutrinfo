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
import android.widget.GridView;
import android.widget.ImageButton;

public class HomeFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public HomeFragment() {
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
        View view = inflater.inflate(R.layout.home_fragment, container, false);

        //Set the Grid View
        GridView gridview = (GridView) view.findViewById(R.id.gridview_toppicks);
        gridview.setAdapter(new GridViewAdapter(getActivity()));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                String selected_top_pick;
                switch (position){
                    case 0:
                        selected_top_pick = "Fruits";
                        break;
                    case 1:
                        selected_top_pick = "Meat";
                        break;
                    case 2:
                        selected_top_pick = "Noodles";
                        break;
                    case 3:
                        selected_top_pick = "Juice";
                        break;
                    default:
                        selected_top_pick = "Vegetable";
                        break;
                }

                FragmentManager fragmentManager = getFragmentManager();

                fragmentManager.beginTransaction()
                        .replace(R.id.container, FoodSearchListFragment.newInstance(selected_top_pick))
                        .addToBackStack("tag")
                        .commit();
            }
        });

        //Image button listener
        ImageButton button= (ImageButton) view.findViewById(R.id.recommended_next_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();

                fragmentManager.beginTransaction()
                        .replace(R.id.container, FoodSearchListFragment.newInstance("banana walnut bread"))
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














}
