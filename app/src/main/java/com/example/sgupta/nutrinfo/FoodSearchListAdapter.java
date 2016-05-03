package com.example.sgupta.nutrinfo;

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

public class FoodSearchListAdapter extends RecyclerView.Adapter<FoodSearchListAdapter.MyViewHolder>{

    private List<FoodItem> foodItemsList;
    Context mContext;
    private AdapterView.OnItemClickListener mItemClickListener;
    private FoodSearchListFragment mFragment;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView title;
        public TextView source;
        Context context;

        public MyViewHolder(View view, int ViewType, Context c) {
            super(view);
            view.setClickable(true);
            view.setOnClickListener(this);

            title = (TextView) view.findViewById(R.id.title);
            source = (TextView) view.findViewById(R.id.source);

        }

        @Override
        public void onClick(View v) {

            int position = getPosition();
            //Log.v("Item clicked", String.valueOf(getPosition()));
            if(mFragment != null && mFragment instanceof FoodSearchListFragment) {
                ((FoodSearchListFragment)mFragment).sendToNextActivity(foodItemsList.get(position).getId()); //-> you can pass any data you wsh to
            }
            }
    }


    public FoodSearchListAdapter(List<FoodItem> list, Context pContext, FoodSearchListFragment fragment) {
        this.foodItemsList = list;
        mContext = pContext;
        mFragment = fragment;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.food_item_row, parent, false);

        return new MyViewHolder(itemView, viewType, mContext);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        FoodItem food_item = foodItemsList.get(position);
        holder.title.setText(food_item.getName());
        holder.source.setText(food_item.getSource());
    }

    @Override
    public int getItemCount() {
        return foodItemsList.size();
    }
}