package com.example.sgupta.nutrinfo;

/**
 * Created by engsg on 4/28/2016.
 */
public class FoodItem {
    private String mName;

    private String mId;

    private String mSource;

    public FoodItem(String name){
        mName = name;
    }

    public FoodItem(String mName, String mId) {
        this.mName = mName;
        this.mId = mId;
    }

    public FoodItem(String mName, String mId, String mSource) {
        this.mName = mName;
        this.mId = mId;
        this.mSource = mSource;
    }

    public String getName()
    {
        return mName;
    }

    public void setName(String name)
    {
        mName = name;
    }

    public String getId() {
        return mId;
    }

    public void setId(String mId) {
        this.mId = mId;
    }

    public String getSource() {
        return mSource;
    }

    public void setSource(String mSource) {
        this.mSource = mSource;
    }
}
