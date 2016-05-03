package io.realm;


public interface FoodRealmProxyInterface {
    public String realmGet$_id();
    public void realmSet$_id(String value);
    public String realmGet$name();
    public void realmSet$name(String value);
    public String realmGet$source();
    public void realmSet$source(String value);
    public RealmList<com.example.sgupta.nutrinfo.Portion> realmGet$portions();
    public void realmSet$portions(RealmList<com.example.sgupta.nutrinfo.Portion> value);
}
