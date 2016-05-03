package com.example.sgupta.nutrinfo;

import io.realm.RealmObject;

/**
 * Created by Supriti on 30/4/2016.
 */
public class Important extends RealmObject {

    private NutrientUnit dietary_fibre;
    private NutrientUnit saturated;
    private NutrientUnit total_carbs;
    private NutrientUnit potassium;
    private NutrientUnit sodium;
    private NutrientUnit calories;
    private NutrientUnit sugar;
    private NutrientUnit total_fats;
    private NutrientUnit cholestrol;
    private NutrientUnit polyunsaturated;
    private NutrientUnit protein;
    private NutrientUnit trans;
    private NutrientUnit monounsaturated;



    public Important() {
    }

    public NutrientUnit getDietary_fibre() {
        return dietary_fibre;
    }

    public void setDietary_fibre(NutrientUnit dietary_fibre) {
        this.dietary_fibre = dietary_fibre;
    }

    public NutrientUnit getSaturated() {
        return saturated;
    }

    public void setSaturated(NutrientUnit saturated) {
        this.saturated = saturated;
    }

    public NutrientUnit getTotal_carbs() {
        return total_carbs;
    }

    public void setTotal_carbs(NutrientUnit total_carbs) {
        this.total_carbs = total_carbs;
    }

    public NutrientUnit getPotassium() {
        return potassium;
    }

    public void setPotassium(NutrientUnit potassium) {
        this.potassium = potassium;
    }

    public NutrientUnit getSodium() {
        return sodium;
    }

    public void setSodium(NutrientUnit sodium) {
        this.sodium = sodium;
    }

    public NutrientUnit getCalories() {
        return calories;
    }

    public void setCalories(NutrientUnit calories) {
        this.calories = calories;
    }

    public NutrientUnit getSugar() {
        return sugar;
    }

    public void setSugar(NutrientUnit sugar) {
        this.sugar = sugar;
    }

    public NutrientUnit getTotal_fats() {
        return total_fats;
    }

    public void setTotal_fats(NutrientUnit total_fats) {
        this.total_fats = total_fats;
    }

    public NutrientUnit getCholestrol() {
        return cholestrol;
    }

    public void setCholestrol(NutrientUnit cholestrol) {
        this.cholestrol = cholestrol;
    }

    public NutrientUnit getPolyunsaturated() {
        return polyunsaturated;
    }

    public void setPolyunsaturated(NutrientUnit polyunsaturated) {
        this.polyunsaturated = polyunsaturated;
    }

    public NutrientUnit getProtein() {
        return protein;
    }

    public void setProtein(NutrientUnit protein) {
        this.protein = protein;
    }

    public NutrientUnit getTrans() {
        return trans;
    }

    public void setTrans(NutrientUnit trans) {
        this.trans = trans;
    }

    public NutrientUnit getMonounsaturated() {
        return monounsaturated;
    }

    public void setMonounsaturated(NutrientUnit monounsaturated) {
        this.monounsaturated = monounsaturated;
    }


}
