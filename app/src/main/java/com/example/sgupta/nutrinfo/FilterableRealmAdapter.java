package com.example.sgupta.nutrinfo;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by Supriti on 1/5/2016.
 */
public class FilterableRealmAdapter extends ArrayAdapter<String> implements Filterable {

    final RealmResults<Food> mRealmObjectList;
    List<String> mResults;


    public FilterableRealmAdapter(Context context, RealmResults<Food> realmObjectList, AutoCompleteTextView refAutocomplete) {
        super(context, android.R.layout.simple_list_item_1);
        mRealmObjectList = realmObjectList;
        refAutocomplete.setAdapter(this);
    }

    @Override
    public int getCount() {
        return mResults == null ? 0 : mResults.size();
    }

    @Override
    public String getItem(int position) {
        return mResults == null ? null : mResults.get(position);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                return new FilterResults();
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (constraint != null) {
                    List<Food> list;
                    mResults = new ArrayList<String>();
                    list = mRealmObjectList.where().contains("name", java.lang.String.valueOf(constraint)).findAll();
                    for(int i = 0; i<list.size(); i++)
                    {
                        mResults.add(list.get(i).getName());
                    }
                    //mResults = mRealmObjectList.where().contains("name", String.valueOf(constraint)).findAll();
                    notifyDataSetChanged();
                }
            }
        };
    }
}