package io.realm;


import android.util.JsonReader;
import io.realm.internal.ColumnInfo;
import io.realm.internal.ImplicitTransaction;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Table;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import com.example.sgupta.nutrinfo.Extra;
import com.example.sgupta.nutrinfo.Food;
import com.example.sgupta.nutrinfo.Important;
import com.example.sgupta.nutrinfo.Nutrient;
import com.example.sgupta.nutrinfo.NutrientUnit;
import com.example.sgupta.nutrinfo.Portion;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>();
        modelClasses.add(Extra.class);
        modelClasses.add(Food.class);
        modelClasses.add(Important.class);
        modelClasses.add(NutrientUnit.class);
        modelClasses.add(Portion.class);
        modelClasses.add(Nutrient.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public Table createTable(Class<? extends RealmModel> clazz, ImplicitTransaction transaction) {
        checkClass(clazz);

        if (clazz.equals(Extra.class)) {
            return ExtraRealmProxy.initTable(transaction);
        } else if (clazz.equals(Food.class)) {
            return FoodRealmProxy.initTable(transaction);
        } else if (clazz.equals(Important.class)) {
            return ImportantRealmProxy.initTable(transaction);
        } else if (clazz.equals(NutrientUnit.class)) {
            return NutrientUnitRealmProxy.initTable(transaction);
        } else if (clazz.equals(Portion.class)) {
            return PortionRealmProxy.initTable(transaction);
        } else if (clazz.equals(Nutrient.class)) {
            return NutrientRealmProxy.initTable(transaction);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public ColumnInfo validateTable(Class<? extends RealmModel> clazz, ImplicitTransaction transaction) {
        checkClass(clazz);

        if (clazz.equals(Extra.class)) {
            return ExtraRealmProxy.validateTable(transaction);
        } else if (clazz.equals(Food.class)) {
            return FoodRealmProxy.validateTable(transaction);
        } else if (clazz.equals(Important.class)) {
            return ImportantRealmProxy.validateTable(transaction);
        } else if (clazz.equals(NutrientUnit.class)) {
            return NutrientUnitRealmProxy.validateTable(transaction);
        } else if (clazz.equals(Portion.class)) {
            return PortionRealmProxy.validateTable(transaction);
        } else if (clazz.equals(Nutrient.class)) {
            return NutrientRealmProxy.validateTable(transaction);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public List<String> getFieldNames(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(Extra.class)) {
            return ExtraRealmProxy.getFieldNames();
        } else if (clazz.equals(Food.class)) {
            return FoodRealmProxy.getFieldNames();
        } else if (clazz.equals(Important.class)) {
            return ImportantRealmProxy.getFieldNames();
        } else if (clazz.equals(NutrientUnit.class)) {
            return NutrientUnitRealmProxy.getFieldNames();
        } else if (clazz.equals(Portion.class)) {
            return PortionRealmProxy.getFieldNames();
        } else if (clazz.equals(Nutrient.class)) {
            return NutrientRealmProxy.getFieldNames();
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public String getTableName(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(Extra.class)) {
            return ExtraRealmProxy.getTableName();
        } else if (clazz.equals(Food.class)) {
            return FoodRealmProxy.getTableName();
        } else if (clazz.equals(Important.class)) {
            return ImportantRealmProxy.getTableName();
        } else if (clazz.equals(NutrientUnit.class)) {
            return NutrientUnitRealmProxy.getTableName();
        } else if (clazz.equals(Portion.class)) {
            return PortionRealmProxy.getTableName();
        } else if (clazz.equals(Nutrient.class)) {
            return NutrientRealmProxy.getTableName();
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, ColumnInfo columnInfo) {
        checkClass(clazz);

        if (clazz.equals(Extra.class)) {
            return clazz.cast(new ExtraRealmProxy(columnInfo));
        } else if (clazz.equals(Food.class)) {
            return clazz.cast(new FoodRealmProxy(columnInfo));
        } else if (clazz.equals(Important.class)) {
            return clazz.cast(new ImportantRealmProxy(columnInfo));
        } else if (clazz.equals(NutrientUnit.class)) {
            return clazz.cast(new NutrientUnitRealmProxy(columnInfo));
        } else if (clazz.equals(Portion.class)) {
            return clazz.cast(new PortionRealmProxy(columnInfo));
        } else if (clazz.equals(Nutrient.class)) {
            return clazz.cast(new NutrientRealmProxy(columnInfo));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(Extra.class)) {
            return clazz.cast(ExtraRealmProxy.copyOrUpdate(realm, (Extra) obj, update, cache));
        } else if (clazz.equals(Food.class)) {
            return clazz.cast(FoodRealmProxy.copyOrUpdate(realm, (Food) obj, update, cache));
        } else if (clazz.equals(Important.class)) {
            return clazz.cast(ImportantRealmProxy.copyOrUpdate(realm, (Important) obj, update, cache));
        } else if (clazz.equals(NutrientUnit.class)) {
            return clazz.cast(NutrientUnitRealmProxy.copyOrUpdate(realm, (NutrientUnit) obj, update, cache));
        } else if (clazz.equals(Portion.class)) {
            return clazz.cast(PortionRealmProxy.copyOrUpdate(realm, (Portion) obj, update, cache));
        } else if (clazz.equals(Nutrient.class)) {
            return clazz.cast(NutrientRealmProxy.copyOrUpdate(realm, (Nutrient) obj, update, cache));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(Extra.class)) {
            return clazz.cast(ExtraRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(Food.class)) {
            return clazz.cast(FoodRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(Important.class)) {
            return clazz.cast(ImportantRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(NutrientUnit.class)) {
            return clazz.cast(NutrientUnitRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(Portion.class)) {
            return clazz.cast(PortionRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(Nutrient.class)) {
            return clazz.cast(NutrientRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(Extra.class)) {
            return clazz.cast(ExtraRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(Food.class)) {
            return clazz.cast(FoodRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(Important.class)) {
            return clazz.cast(ImportantRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(NutrientUnit.class)) {
            return clazz.cast(NutrientUnitRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(Portion.class)) {
            return clazz.cast(PortionRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(Nutrient.class)) {
            return clazz.cast(NutrientRealmProxy.createUsingJsonStream(realm, reader));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(Extra.class)) {
            return clazz.cast(ExtraRealmProxy.createDetachedCopy((Extra) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(Food.class)) {
            return clazz.cast(FoodRealmProxy.createDetachedCopy((Food) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(Important.class)) {
            return clazz.cast(ImportantRealmProxy.createDetachedCopy((Important) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(NutrientUnit.class)) {
            return clazz.cast(NutrientUnitRealmProxy.createDetachedCopy((NutrientUnit) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(Portion.class)) {
            return clazz.cast(PortionRealmProxy.createDetachedCopy((Portion) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(Nutrient.class)) {
            return clazz.cast(NutrientRealmProxy.createDetachedCopy((Nutrient) realmObject, 0, maxDepth, cache));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

}
