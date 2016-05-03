package com.example.sgupta.nutrinfo;

import io.realm.RealmObject;

/**
 * Created by Supriti on 30/4/2016.
 */
public class NutrientUnit extends RealmObject {

    private Float value;

    public NutrientUnit() {
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

}
