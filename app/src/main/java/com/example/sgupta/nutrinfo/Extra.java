package com.example.sgupta.nutrinfo;

import io.realm.RealmObject;

/**
 * Created by Supriti on 30/4/2016.
 */
public class Extra extends RealmObject {

    private NutrientUnit vitamin_a;
    private NutrientUnit phosphorous;
    private NutrientUnit retinol;
    private NutrientUnit iron;
    private NutrientUnit thiamin;
    private NutrientUnit selenium;
    private NutrientUnit starch;
    private NutrientUnit zinc;
    private NutrientUnit water;
    private NutrientUnit riboflavin;
    private NutrientUnit calcium;
    private NutrientUnit vitamin_c;
    private NutrientUnit b_carotene;

    public Extra(){

    }

    public NutrientUnit getVitamin_a() {
        return vitamin_a;
    }

    public void setVitamin_a(NutrientUnit vitamin_a) {
        this.vitamin_a = vitamin_a;
    }

    public NutrientUnit getPhosphorous() {
        return phosphorous;
    }

    public void setPhosphorous(NutrientUnit phosphorous) {
        this.phosphorous = phosphorous;
    }

    public NutrientUnit getRetinol() {
        return retinol;
    }

    public void setRetinol(NutrientUnit retinol) {
        this.retinol = retinol;
    }

    public NutrientUnit getIron() {
        return iron;
    }

    public void setIron(NutrientUnit iron) {
        this.iron = iron;
    }

    public NutrientUnit getThiamin() {
        return thiamin;
    }

    public void setThiamin(NutrientUnit thiamin) {
        this.thiamin = thiamin;
    }

    public NutrientUnit getSelenium() {
        return selenium;
    }

    public void setSelenium(NutrientUnit selenium) {
        this.selenium = selenium;
    }

    public NutrientUnit getStarch() {
        return starch;
    }

    public void setStarch(NutrientUnit starch) {
        this.starch = starch;
    }

    public NutrientUnit getZinc() {
        return zinc;
    }

    public void setZinc(NutrientUnit zinc) {
        this.zinc = zinc;
    }

    public NutrientUnit getWater() {
        return water;
    }

    public void setWater(NutrientUnit water) {
        this.water = water;
    }

    public NutrientUnit getRiboflavin() {
        return riboflavin;
    }

    public void setRiboflavin(NutrientUnit riboflavin) {
        this.riboflavin = riboflavin;
    }

    public NutrientUnit getCalcium() {
        return calcium;
    }

    public void setCalcium(NutrientUnit calcium) {
        this.calcium = calcium;
    }

    public NutrientUnit getVitamin_c() {
        return vitamin_c;
    }

    public void setVitamin_c(NutrientUnit vitamin_c) {
        this.vitamin_c = vitamin_c;
    }

    public NutrientUnit getB_carotene() {
        return b_carotene;
    }

    public void setB_carotene(NutrientUnit b_carotene) {
        this.b_carotene = b_carotene;
    }
}
