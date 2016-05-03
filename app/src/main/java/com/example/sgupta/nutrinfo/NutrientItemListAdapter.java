package com.example.sgupta.nutrinfo;

/**
 * Created by Supriti on 1/5/2016.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.List;


/**
 * Created by engsg on 4/28/2016.
 */
import android.app.Fragment;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class NutrientItemListAdapter extends RecyclerView.Adapter<NutrientItemListAdapter.MyViewHolder>{

    private List<NutrientItem> foodItemsList;
    Context mContext;
    private AdapterView.OnItemClickListener mItemClickListener;


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView title;
        public TextView value;
        Context context;

        public MyViewHolder(View view, int ViewType, Context c) {
            super(view);
            view.setClickable(true);
            view.setOnClickListener(this);

            title = (TextView) view.findViewById(R.id.nutrient_title);
            value = (TextView) view.findViewById(R.id.nutrient_value);
            //genre = (TextView) view.findViewById(R.id.genre);
            //year = (TextView) view.findViewById(R.id.year);
        }

        @Override
        public void onClick(View v) {

            int position = getPosition();
            //Log.v("Item clicked", String.valueOf(getPosition()));
            //if(mFragment != null && mFragment instanceof FoodSearchListFragment) {
              //  ((FoodSearchListFragment)mFragment).sendToNextActivity(foodItemsList.get(position).getId()); //-> you can pass any data you wsh to
            //}
        }
    }


    public NutrientItemListAdapter(List<NutrientItem> list, Context pContext) {
        this.foodItemsList = list;
        mContext = pContext;
        //mFragment = fragment;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.nutrient_item_row, parent, false);

        return new MyViewHolder(itemView, viewType, mContext);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
       NutrientItem food_item = foodItemsList.get(position);
        holder.title.setText(food_item.getmNutrientName());
        holder.value.setText(food_item.getmNutrientValue());
    }

    @Override
    public int getItemCount() {
        return foodItemsList.size();
    }
}