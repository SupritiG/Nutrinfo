package com.example.sgupta.nutrinfo;

/**
 * Created by Supriti on 1/5/2016.
 */
public class NutrientItem {

    private String mNutrientName;
    private String mNutrientValue;

    public NutrientItem(String mNutrientName, String mNutrientValue) {
        this.mNutrientName = mNutrientName;
        this.mNutrientValue = mNutrientValue;
    }

    public String getmNutrientName() {
        return mNutrientName;
    }

    public void setmNutrientName(String mNutrientName) {
        this.mNutrientName = mNutrientName;
    }

    public String getmNutrientValue() {
        return mNutrientValue;
    }

    public void setmNutrientValue(String mNutrientValue) {
        this.mNutrientValue = mNutrientValue;
    }
}
