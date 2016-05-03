package com.example.sgupta.nutrinfo;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by engsg on 4/29/2016.
 */
public class Food extends RealmObject {

    @PrimaryKey
    private String _id;

    private String name;

    private String source;

    private RealmList<Portion> portions;

    public Food() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RealmList<Portion> getPortions() {
        return portions;
    }

    public void setPortions(RealmList<Portion> portion) {
        this.portions = portion;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

}
