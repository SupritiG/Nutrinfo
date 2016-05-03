package com.example.sgupta.nutrinfo;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by engsg on 4/29/2016.
 */
public class Portion extends RealmObject {

    private String name;
    private Nutrient  nutrients;


    public Portion() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Nutrient getNutrients() {
        return nutrients;
    }

    public void setNutrients(Nutrient nutrients) {
        this.nutrients = nutrients;
    }
}
