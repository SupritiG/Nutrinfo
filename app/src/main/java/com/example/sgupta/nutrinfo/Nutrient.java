package com.example.sgupta.nutrinfo;

import io.realm.RealmObject;

/**
 * Created by Supriti on 30/4/2016.
 */
public class Nutrient extends RealmObject{

    private Important important;
    private Extra extra;

    public Nutrient() {
    }

    public Important getImportant() {
        return important;
    }

    public void setImportant(Important important) {
        this.important = important;
    }

    public Extra getExtra() {
        return extra;
    }

    public void setExtra(Extra extra) {
        this.extra = extra;
    }
}
