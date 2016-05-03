package com.example.sgupta.nutrinfo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;



public class FoodSearchListFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_FOOD_NAME = "food_name";
    private String BASE_URL = "http://test.holmusk.com/food/search?q=";

    private String mFoodName;
    private String mSearchResult;

    private boolean netConnected;                 //flag for net connectivity
    private boolean noSearchResultsFound;         //flag for empty search list from the server

    private List<FoodItem> foodList = new ArrayList<>();
    private RecyclerView recyclerView;
    private FoodSearchListAdapter mAdapter;
    private TextView noSearchResults;

    private Realm realm;
    private OnFragmentInteractionListener mListener;


    public static FoodSearchListFragment newInstance(String param1) {
        FoodSearchListFragment fragment = new FoodSearchListFragment();
        Bundle args = new Bundle();

        //Taking search query as the argument for fragment instantiation
        args.putString(ARG_FOOD_NAME, param1);
        fragment.setArguments(args);
        return fragment;
    }

    public FoodSearchListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mFoodName = getArguments().getString(ARG_FOOD_NAME);
        }
     }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.food_search_list, container, false);

        //Initialize the views
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        noSearchResults = (TextView) view.findViewById(R.id.no_results_view);
        noSearchResults.setVisibility(View.INVISIBLE);

        //Set the adaptor for recycler list view
        mAdapter = new FoodSearchListAdapter(foodList, getActivity(), this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        //prepareData();

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        //Get the search text entered by the user
        mFoodName = getArguments().getString(ARG_FOOD_NAME);
        new Connection(getActivity().getApplicationContext()).execute();


    }

    @Override
    public void onResume()
    {
        super.onResume();

        //Check for net connectivity
        netConnected = checkNetConnectivity();

        if (!netConnected)
        {
            Log.e("Network conn", "No network");
            Toast.makeText(getActivity(), "No network, check your connection and try again", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

     public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }


    //AsyncTask to manage the sending and receiving of HTTP request
    private class Connection extends AsyncTask<Object, Object, Boolean> {


        private Context contextAsyncTask;

        public Connection(Context context) {
            this.contextAsyncTask = context;
        }

        private ProgressDialog dialog = new ProgressDialog(getActivity());
        /** progress dialog to show user that the backup is processing. */

        @Override
        protected void onPreExecute() {
            //Show searching dialog while retrieving results from the server
            this.dialog.setMessage("Searching");
            this.dialog.show();
        }


        protected Boolean doInBackground(Object... arg0) {
            Boolean result = connect();
            return result;
        }


        protected void onPostExecute(Boolean check)
        {
            //Dismiss the progress dialog
            dialog.dismiss();

            //Store the retrived results in the local database
            storeDataLocalStorage(mSearchResult);

            //Notify the data set change in case of successful response from the server
            if (check) {
                if(noSearchResultsFound)
                {
                    //If the search result is empty show the emptyView
                    noSearchResults.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.INVISIBLE);
                }else {
                    //If the search result is not empty show the list view and notify the dataset change through the adapter
                    recyclerView.setVisibility(View.VISIBLE);
                    noSearchResults.setVisibility(View.INVISIBLE);
                    mAdapter.notifyDataSetChanged();
                }
            }else{
                //In case of failure to get sarch results from serve, show the error message
                Toast.makeText(getActivity(), "Unable to receive results", Toast.LENGTH_LONG).show();
            }
        }

    }

    /* Sends the HTTP GET request to the server.
    @output: boolean - response from the server is received or not
    */
    private boolean connect()
    {
        StringBuilder builder = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet;
        //Send HTTP GET request to the server
        try{
         httpGet = new HttpGet(BASE_URL+ URLEncoder.encode(mFoodName, "UTF-8"));
        }catch(Exception e)
        {
            e.printStackTrace();
            Log.e("Food search fragment","Failed to construct url");
            return false;
        }

        try{
            HttpResponse response = client.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();

            //If HTTP status code OK then do..
            if(statusCode == 200){
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                String line;
                while((line = reader.readLine()) != null){
                    builder.append(line);
                }
                mSearchResult = builder.toString();

                //Convert the string to JSON objects for passing to list adapter
                getJSONObject(mSearchResult);
                return true;
            } else {
                Log.e(MainActivity2.class.toString(),"Failed to get JSON object");
                return false;
            }
        }catch(ClientProtocolException e){
            e.printStackTrace();
            return false;
        } catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }


    /*Convert the server response to a JSON Object
    @input: String response received from the server
    Search results are added to the foodList array
     */
    private void getJSONObject(String str)
    {
        JSONArray array;
        noSearchResultsFound = false;
        foodList.clear();

        try {
            array = new JSONArray(str);
            //Log.v("json array length", String.valueOf(array.length()));

            if (array.length() == 0)
            {
                noSearchResultsFound = true;
                //Log.v("nosearch results", String.valueOf(noSearchResultsFound));
            }

            for (int i=0; i<array.length(); i++) {
                JSONObject actor = array.getJSONObject(i);

                String name = actor.getString("name");
                String id = actor.getString("_id");
                String source = actor.getString("source");

                foodList.add(new FoodItem(name, id, source));
                //Log.v("retrieved names", name);
            }

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    /*Check the availability of network connection
    @output: boolean indicating the availability of network connection
     */
    public boolean checkNetConnectivity()
    {
        boolean status;
        ConnectivityManager connMgr = (ConnectivityManager)
                getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            status = true;
        } else {
            status = false;
            //Log.e("List Fragment", "net not connected");
        }
       return status;
    }

    /*Start the next activity to show the nutritional information of selected food item
    @input - position of the selected food item in the list
    */
    public void sendToNextActivity(String id)
    {
        Intent myIntent = new Intent(getActivity(), DisplayNutritionActivity.class);
        myIntent.putExtra("id", id); //Optional parameters
        getActivity().startActivity(myIntent);
    }

    //Method to test the adapter and recycler view
    private void prepareData(){
        FoodItem f1 = new FoodItem("apple");
        FoodItem f2 = new FoodItem("banana");

        foodList.add(f1);
        foodList.add(f2);

        mAdapter.notifyDataSetChanged();
    }

    /*
    Method to store the retrieved search results in local database
    @input - string consisting of JSON objects
     */
    private void storeDataLocalStorage(String str)
    {
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        try {
            //Create Food objects from the input string
            realm.createOrUpdateAllFromJson(Food.class, str);

            //Commit data to the database
            realm.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
            realm.cancelTransaction();
        }

        //Test the data persisted in database
       /* RealmResults<Food> k = realm.where(Food.class).findAll();
        Log.v("first food", String.valueOf(k.size()));
        Food j = k.where().equalTo("name", "Banana").findFirst();
        String food_nam = j.getName();
        Log.v("no of portions", String.valueOf(j.getPortions().size()));
        if (j.getPortions().first().getNutrients().getImportant().getTrans() == null)
        {
            Log.v("calories", "null");
        }
        String nam = j.getPortions().first().getName();

        Log.v("food name", food_nam);
        Log.v("name", nam);
        Log.v("size of database", String.valueOf(realm.where(Food.class).findAll().size()));*/



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
