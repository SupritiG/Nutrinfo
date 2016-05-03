package io.realm;


import android.util.JsonReader;
import android.util.JsonToken;
import com.example.sgupta.nutrinfo.Important;
import com.example.sgupta.nutrinfo.NutrientUnit;
import io.realm.RealmFieldType;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.ImplicitTransaction;
import io.realm.internal.LinkView;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.TableOrView;
import io.realm.internal.android.JsonUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ImportantRealmProxy extends Important
    implements RealmObjectProxy, ImportantRealmProxyInterface {

    static final class ImportantColumnInfo extends ColumnInfo {

        public final long dietary_fibreIndex;
        public final long saturatedIndex;
        public final long total_carbsIndex;
        public final long potassiumIndex;
        public final long sodiumIndex;
        public final long caloriesIndex;
        public final long sugarIndex;
        public final long total_fatsIndex;
        public final long cholestrolIndex;
        public final long polyunsaturatedIndex;
        public final long proteinIndex;
        public final long transIndex;
        public final long monounsaturatedIndex;

        ImportantColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(13);
            this.dietary_fibreIndex = getValidColumnIndex(path, table, "Important", "dietary_fibre");
            indicesMap.put("dietary_fibre", this.dietary_fibreIndex);

            this.saturatedIndex = getValidColumnIndex(path, table, "Important", "saturated");
            indicesMap.put("saturated", this.saturatedIndex);

            this.total_carbsIndex = getValidColumnIndex(path, table, "Important", "total_carbs");
            indicesMap.put("total_carbs", this.total_carbsIndex);

            this.potassiumIndex = getValidColumnIndex(path, table, "Important", "potassium");
            indicesMap.put("potassium", this.potassiumIndex);

            this.sodiumIndex = getValidColumnIndex(path, table, "Important", "sodium");
            indicesMap.put("sodium", this.sodiumIndex);

            this.caloriesIndex = getValidColumnIndex(path, table, "Important", "calories");
            indicesMap.put("calories", this.caloriesIndex);

            this.sugarIndex = getValidColumnIndex(path, table, "Important", "sugar");
            indicesMap.put("sugar", this.sugarIndex);

            this.total_fatsIndex = getValidColumnIndex(path, table, "Important", "total_fats");
            indicesMap.put("total_fats", this.total_fatsIndex);

            this.cholestrolIndex = getValidColumnIndex(path, table, "Important", "cholestrol");
            indicesMap.put("cholestrol", this.cholestrolIndex);

            this.polyunsaturatedIndex = getValidColumnIndex(path, table, "Important", "polyunsaturated");
            indicesMap.put("polyunsaturated", this.polyunsaturatedIndex);

            this.proteinIndex = getValidColumnIndex(path, table, "Important", "protein");
            indicesMap.put("protein", this.proteinIndex);

            this.transIndex = getValidColumnIndex(path, table, "Important", "trans");
            indicesMap.put("trans", this.transIndex);

            this.monounsaturatedIndex = getValidColumnIndex(path, table, "Important", "monounsaturated");
            indicesMap.put("monounsaturated", this.monounsaturatedIndex);

            setIndicesMap(indicesMap);
        }
    }

    private final ImportantColumnInfo columnInfo;
    private final ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("dietary_fibre");
        fieldNames.add("saturated");
        fieldNames.add("total_carbs");
        fieldNames.add("potassium");
        fieldNames.add("sodium");
        fieldNames.add("calories");
        fieldNames.add("sugar");
        fieldNames.add("total_fats");
        fieldNames.add("cholestrol");
        fieldNames.add("polyunsaturated");
        fieldNames.add("protein");
        fieldNames.add("trans");
        fieldNames.add("monounsaturated");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    ImportantRealmProxy(ColumnInfo columnInfo) {
        this.columnInfo = (ImportantColumnInfo) columnInfo;
        this.proxyState = new ProxyState(Important.class);
    }

    public NutrientUnit realmGet$dietary_fibre() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.dietary_fibreIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.example.sgupta.nutrinfo.NutrientUnit.class, proxyState.getRow$realm().getLink(columnInfo.dietary_fibreIndex));
    }

    public void realmSet$dietary_fibre(NutrientUnit value) {
        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.dietary_fibreIndex);
            return;
        }
        if (!RealmObject.isValid(value)) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy)value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.dietary_fibreIndex, ((RealmObjectProxy)value).realmGet$proxyState().getRow$realm().getIndex());
    }

    public NutrientUnit realmGet$saturated() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.saturatedIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.example.sgupta.nutrinfo.NutrientUnit.class, proxyState.getRow$realm().getLink(columnInfo.saturatedIndex));
    }

    public void realmSet$saturated(NutrientUnit value) {
        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.saturatedIndex);
            return;
        }
        if (!RealmObject.isValid(value)) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy)value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.saturatedIndex, ((RealmObjectProxy)value).realmGet$proxyState().getRow$realm().getIndex());
    }

    public NutrientUnit realmGet$total_carbs() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.total_carbsIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.example.sgupta.nutrinfo.NutrientUnit.class, proxyState.getRow$realm().getLink(columnInfo.total_carbsIndex));
    }

    public void realmSet$total_carbs(NutrientUnit value) {
        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.total_carbsIndex);
            return;
        }
        if (!RealmObject.isValid(value)) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy)value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.total_carbsIndex, ((RealmObjectProxy)value).realmGet$proxyState().getRow$realm().getIndex());
    }

    public NutrientUnit realmGet$potassium() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.potassiumIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.example.sgupta.nutrinfo.NutrientUnit.class, proxyState.getRow$realm().getLink(columnInfo.potassiumIndex));
    }

    public void realmSet$potassium(NutrientUnit value) {
        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.potassiumIndex);
            return;
        }
        if (!RealmObject.isValid(value)) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy)value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.potassiumIndex, ((RealmObjectProxy)value).realmGet$proxyState().getRow$realm().getIndex());
    }

    public NutrientUnit realmGet$sodium() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.sodiumIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.example.sgupta.nutrinfo.NutrientUnit.class, proxyState.getRow$realm().getLink(columnInfo.sodiumIndex));
    }

    public void realmSet$sodium(NutrientUnit value) {
        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.sodiumIndex);
            return;
        }
        if (!RealmObject.isValid(value)) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy)value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.sodiumIndex, ((RealmObjectProxy)value).realmGet$proxyState().getRow$realm().getIndex());
    }

    public NutrientUnit realmGet$calories() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.caloriesIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.example.sgupta.nutrinfo.NutrientUnit.class, proxyState.getRow$realm().getLink(columnInfo.caloriesIndex));
    }

    public void realmSet$calories(NutrientUnit value) {
        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.caloriesIndex);
            return;
        }
        if (!RealmObject.isValid(value)) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy)value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.caloriesIndex, ((RealmObjectProxy)value).realmGet$proxyState().getRow$realm().getIndex());
    }

    public NutrientUnit realmGet$sugar() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.sugarIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.example.sgupta.nutrinfo.NutrientUnit.class, proxyState.getRow$realm().getLink(columnInfo.sugarIndex));
    }

    public void realmSet$sugar(NutrientUnit value) {
        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.sugarIndex);
            return;
        }
        if (!RealmObject.isValid(value)) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy)value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.sugarIndex, ((RealmObjectProxy)value).realmGet$proxyState().getRow$realm().getIndex());
    }

    public NutrientUnit realmGet$total_fats() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.total_fatsIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.example.sgupta.nutrinfo.NutrientUnit.class, proxyState.getRow$realm().getLink(columnInfo.total_fatsIndex));
    }

    public void realmSet$total_fats(NutrientUnit value) {
        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.total_fatsIndex);
            return;
        }
        if (!RealmObject.isValid(value)) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy)value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.total_fatsIndex, ((RealmObjectProxy)value).realmGet$proxyState().getRow$realm().getIndex());
    }

    public NutrientUnit realmGet$cholestrol() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.cholestrolIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.example.sgupta.nutrinfo.NutrientUnit.class, proxyState.getRow$realm().getLink(columnInfo.cholestrolIndex));
    }

    public void realmSet$cholestrol(NutrientUnit value) {
        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.cholestrolIndex);
            return;
        }
        if (!RealmObject.isValid(value)) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy)value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.cholestrolIndex, ((RealmObjectProxy)value).realmGet$proxyState().getRow$realm().getIndex());
    }

    public NutrientUnit realmGet$polyunsaturated() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.polyunsaturatedIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.example.sgupta.nutrinfo.NutrientUnit.class, proxyState.getRow$realm().getLink(columnInfo.polyunsaturatedIndex));
    }

    public void realmSet$polyunsaturated(NutrientUnit value) {
        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.polyunsaturatedIndex);
            return;
        }
        if (!RealmObject.isValid(value)) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy)value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.polyunsaturatedIndex, ((RealmObjectProxy)value).realmGet$proxyState().getRow$realm().getIndex());
    }

    public NutrientUnit realmGet$protein() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.proteinIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.example.sgupta.nutrinfo.NutrientUnit.class, proxyState.getRow$realm().getLink(columnInfo.proteinIndex));
    }

    public void realmSet$protein(NutrientUnit value) {
        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.proteinIndex);
            return;
        }
        if (!RealmObject.isValid(value)) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy)value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.proteinIndex, ((RealmObjectProxy)value).realmGet$proxyState().getRow$realm().getIndex());
    }

    public NutrientUnit realmGet$trans() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.transIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.example.sgupta.nutrinfo.NutrientUnit.class, proxyState.getRow$realm().getLink(columnInfo.transIndex));
    }

    public void realmSet$trans(NutrientUnit value) {
        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.transIndex);
            return;
        }
        if (!RealmObject.isValid(value)) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy)value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.transIndex, ((RealmObjectProxy)value).realmGet$proxyState().getRow$realm().getIndex());
    }

    public NutrientUnit realmGet$monounsaturated() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.monounsaturatedIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.example.sgupta.nutrinfo.NutrientUnit.class, proxyState.getRow$realm().getLink(columnInfo.monounsaturatedIndex));
    }

    public void realmSet$monounsaturated(NutrientUnit value) {
        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.monounsaturatedIndex);
            return;
        }
        if (!RealmObject.isValid(value)) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy)value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.monounsaturatedIndex, ((RealmObjectProxy)value).realmGet$proxyState().getRow$realm().getIndex());
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if (!transaction.hasTable("class_Important")) {
            Table table = transaction.getTable("class_Important");
            if (!transaction.hasTable("class_NutrientUnit")) {
                NutrientUnitRealmProxy.initTable(transaction);
            }
            table.addColumnLink(RealmFieldType.OBJECT, "dietary_fibre", transaction.getTable("class_NutrientUnit"));
            if (!transaction.hasTable("class_NutrientUnit")) {
                NutrientUnitRealmProxy.initTable(transaction);
            }
            table.addColumnLink(RealmFieldType.OBJECT, "saturated", transaction.getTable("class_NutrientUnit"));
            if (!transaction.hasTable("class_NutrientUnit")) {
                NutrientUnitRealmProxy.initTable(transaction);
            }
            table.addColumnLink(RealmFieldType.OBJECT, "total_carbs", transaction.getTable("class_NutrientUnit"));
            if (!transaction.hasTable("class_NutrientUnit")) {
                NutrientUnitRealmProxy.initTable(transaction);
            }
            table.addColumnLink(RealmFieldType.OBJECT, "potassium", transaction.getTable("class_NutrientUnit"));
            if (!transaction.hasTable("class_NutrientUnit")) {
                NutrientUnitRealmProxy.initTable(transaction);
            }
            table.addColumnLink(RealmFieldType.OBJECT, "sodium", transaction.getTable("class_NutrientUnit"));
            if (!transaction.hasTable("class_NutrientUnit")) {
                NutrientUnitRealmProxy.initTable(transaction);
            }
            table.addColumnLink(RealmFieldType.OBJECT, "calories", transaction.getTable("class_NutrientUnit"));
            if (!transaction.hasTable("class_NutrientUnit")) {
                NutrientUnitRealmProxy.initTable(transaction);
            }
            table.addColumnLink(RealmFieldType.OBJECT, "sugar", transaction.getTable("class_NutrientUnit"));
            if (!transaction.hasTable("class_NutrientUnit")) {
                NutrientUnitRealmProxy.initTable(transaction);
            }
            table.addColumnLink(RealmFieldType.OBJECT, "total_fats", transaction.getTable("class_NutrientUnit"));
            if (!transaction.hasTable("class_NutrientUnit")) {
                NutrientUnitRealmProxy.initTable(transaction);
            }
            table.addColumnLink(RealmFieldType.OBJECT, "cholestrol", transaction.getTable("class_NutrientUnit"));
            if (!transaction.hasTable("class_NutrientUnit")) {
                NutrientUnitRealmProxy.initTable(transaction);
            }
            table.addColumnLink(RealmFieldType.OBJECT, "polyunsaturated", transaction.getTable("class_NutrientUnit"));
            if (!transaction.hasTable("class_NutrientUnit")) {
                NutrientUnitRealmProxy.initTable(transaction);
            }
            table.addColumnLink(RealmFieldType.OBJECT, "protein", transaction.getTable("class_NutrientUnit"));
            if (!transaction.hasTable("class_NutrientUnit")) {
                NutrientUnitRealmProxy.initTable(transaction);
            }
            table.addColumnLink(RealmFieldType.OBJECT, "trans", transaction.getTable("class_NutrientUnit"));
            if (!transaction.hasTable("class_NutrientUnit")) {
                NutrientUnitRealmProxy.initTable(transaction);
            }
            table.addColumnLink(RealmFieldType.OBJECT, "monounsaturated", transaction.getTable("class_NutrientUnit"));
            table.setPrimaryKey("");
            return table;
        }
        return transaction.getTable("class_Important");
    }

    public static ImportantColumnInfo validateTable(ImplicitTransaction transaction) {
        if (transaction.hasTable("class_Important")) {
            Table table = transaction.getTable("class_Important");
            if (table.getColumnCount() != 13) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field count does not match - expected 13 but was " + table.getColumnCount());
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < 13; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final ImportantColumnInfo columnInfo = new ImportantColumnInfo(transaction.getPath(), table);

            if (!columnTypes.containsKey("dietary_fibre")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'dietary_fibre' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("dietary_fibre") != RealmFieldType.OBJECT) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'NutrientUnit' for field 'dietary_fibre'");
            }
            if (!transaction.hasTable("class_NutrientUnit")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_NutrientUnit' for field 'dietary_fibre'");
            }
            Table table_0 = transaction.getTable("class_NutrientUnit");
            if (!table.getLinkTarget(columnInfo.dietary_fibreIndex).hasSameSchema(table_0)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'dietary_fibre': '" + table.getLinkTarget(columnInfo.dietary_fibreIndex).getName() + "' expected - was '" + table_0.getName() + "'");
            }
            if (!columnTypes.containsKey("saturated")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'saturated' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("saturated") != RealmFieldType.OBJECT) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'NutrientUnit' for field 'saturated'");
            }
            if (!transaction.hasTable("class_NutrientUnit")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_NutrientUnit' for field 'saturated'");
            }
            Table table_1 = transaction.getTable("class_NutrientUnit");
            if (!table.getLinkTarget(columnInfo.saturatedIndex).hasSameSchema(table_1)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'saturated': '" + table.getLinkTarget(columnInfo.saturatedIndex).getName() + "' expected - was '" + table_1.getName() + "'");
            }
            if (!columnTypes.containsKey("total_carbs")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'total_carbs' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("total_carbs") != RealmFieldType.OBJECT) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'NutrientUnit' for field 'total_carbs'");
            }
            if (!transaction.hasTable("class_NutrientUnit")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_NutrientUnit' for field 'total_carbs'");
            }
            Table table_2 = transaction.getTable("class_NutrientUnit");
            if (!table.getLinkTarget(columnInfo.total_carbsIndex).hasSameSchema(table_2)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'total_carbs': '" + table.getLinkTarget(columnInfo.total_carbsIndex).getName() + "' expected - was '" + table_2.getName() + "'");
            }
            if (!columnTypes.containsKey("potassium")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'potassium' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("potassium") != RealmFieldType.OBJECT) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'NutrientUnit' for field 'potassium'");
            }
            if (!transaction.hasTable("class_NutrientUnit")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_NutrientUnit' for field 'potassium'");
            }
            Table table_3 = transaction.getTable("class_NutrientUnit");
            if (!table.getLinkTarget(columnInfo.potassiumIndex).hasSameSchema(table_3)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'potassium': '" + table.getLinkTarget(columnInfo.potassiumIndex).getName() + "' expected - was '" + table_3.getName() + "'");
            }
            if (!columnTypes.containsKey("sodium")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'sodium' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("sodium") != RealmFieldType.OBJECT) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'NutrientUnit' for field 'sodium'");
            }
            if (!transaction.hasTable("class_NutrientUnit")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_NutrientUnit' for field 'sodium'");
            }
            Table table_4 = transaction.getTable("class_NutrientUnit");
            if (!table.getLinkTarget(columnInfo.sodiumIndex).hasSameSchema(table_4)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'sodium': '" + table.getLinkTarget(columnInfo.sodiumIndex).getName() + "' expected - was '" + table_4.getName() + "'");
            }
            if (!columnTypes.containsKey("calories")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'calories' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("calories") != RealmFieldType.OBJECT) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'NutrientUnit' for field 'calories'");
            }
            if (!transaction.hasTable("class_NutrientUnit")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_NutrientUnit' for field 'calories'");
            }
            Table table_5 = transaction.getTable("class_NutrientUnit");
            if (!table.getLinkTarget(columnInfo.caloriesIndex).hasSameSchema(table_5)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'calories': '" + table.getLinkTarget(columnInfo.caloriesIndex).getName() + "' expected - was '" + table_5.getName() + "'");
            }
            if (!columnTypes.containsKey("sugar")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'sugar' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("sugar") != RealmFieldType.OBJECT) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'NutrientUnit' for field 'sugar'");
            }
            if (!transaction.hasTable("class_NutrientUnit")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_NutrientUnit' for field 'sugar'");
            }
            Table table_6 = transaction.getTable("class_NutrientUnit");
            if (!table.getLinkTarget(columnInfo.sugarIndex).hasSameSchema(table_6)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'sugar': '" + table.getLinkTarget(columnInfo.sugarIndex).getName() + "' expected - was '" + table_6.getName() + "'");
            }
            if (!columnTypes.containsKey("total_fats")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'total_fats' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("total_fats") != RealmFieldType.OBJECT) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'NutrientUnit' for field 'total_fats'");
            }
            if (!transaction.hasTable("class_NutrientUnit")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_NutrientUnit' for field 'total_fats'");
            }
            Table table_7 = transaction.getTable("class_NutrientUnit");
            if (!table.getLinkTarget(columnInfo.total_fatsIndex).hasSameSchema(table_7)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'total_fats': '" + table.getLinkTarget(columnInfo.total_fatsIndex).getName() + "' expected - was '" + table_7.getName() + "'");
            }
            if (!columnTypes.containsKey("cholestrol")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'cholestrol' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cholestrol") != RealmFieldType.OBJECT) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'NutrientUnit' for field 'cholestrol'");
            }
            if (!transaction.hasTable("class_NutrientUnit")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_NutrientUnit' for field 'cholestrol'");
            }
            Table table_8 = transaction.getTable("class_NutrientUnit");
            if (!table.getLinkTarget(columnInfo.cholestrolIndex).hasSameSchema(table_8)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'cholestrol': '" + table.getLinkTarget(columnInfo.cholestrolIndex).getName() + "' expected - was '" + table_8.getName() + "'");
            }
            if (!columnTypes.containsKey("polyunsaturated")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'polyunsaturated' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("polyunsaturated") != RealmFieldType.OBJECT) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'NutrientUnit' for field 'polyunsaturated'");
            }
            if (!transaction.hasTable("class_NutrientUnit")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_NutrientUnit' for field 'polyunsaturated'");
            }
            Table table_9 = transaction.getTable("class_NutrientUnit");
            if (!table.getLinkTarget(columnInfo.polyunsaturatedIndex).hasSameSchema(table_9)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'polyunsaturated': '" + table.getLinkTarget(columnInfo.polyunsaturatedIndex).getName() + "' expected - was '" + table_9.getName() + "'");
            }
            if (!columnTypes.containsKey("protein")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'protein' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("protein") != RealmFieldType.OBJECT) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'NutrientUnit' for field 'protein'");
            }
            if (!transaction.hasTable("class_NutrientUnit")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_NutrientUnit' for field 'protein'");
            }
            Table table_10 = transaction.getTable("class_NutrientUnit");
            if (!table.getLinkTarget(columnInfo.proteinIndex).hasSameSchema(table_10)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'protein': '" + table.getLinkTarget(columnInfo.proteinIndex).getName() + "' expected - was '" + table_10.getName() + "'");
            }
            if (!columnTypes.containsKey("trans")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'trans' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("trans") != RealmFieldType.OBJECT) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'NutrientUnit' for field 'trans'");
            }
            if (!transaction.hasTable("class_NutrientUnit")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_NutrientUnit' for field 'trans'");
            }
            Table table_11 = transaction.getTable("class_NutrientUnit");
            if (!table.getLinkTarget(columnInfo.transIndex).hasSameSchema(table_11)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'trans': '" + table.getLinkTarget(columnInfo.transIndex).getName() + "' expected - was '" + table_11.getName() + "'");
            }
            if (!columnTypes.containsKey("monounsaturated")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'monounsaturated' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("monounsaturated") != RealmFieldType.OBJECT) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'NutrientUnit' for field 'monounsaturated'");
            }
            if (!transaction.hasTable("class_NutrientUnit")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_NutrientUnit' for field 'monounsaturated'");
            }
            Table table_12 = transaction.getTable("class_NutrientUnit");
            if (!table.getLinkTarget(columnInfo.monounsaturatedIndex).hasSameSchema(table_12)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'monounsaturated': '" + table.getLinkTarget(columnInfo.monounsaturatedIndex).getName() + "' expected - was '" + table_12.getName() + "'");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(transaction.getPath(), "The Important class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_Important";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static Important createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        Important obj = realm.createObject(Important.class);
        if (json.has("dietary_fibre")) {
            if (json.isNull("dietary_fibre")) {
                ((ImportantRealmProxyInterface) obj).realmSet$dietary_fibre(null);
            } else {
                com.example.sgupta.nutrinfo.NutrientUnit dietary_fibreObj = NutrientUnitRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("dietary_fibre"), update);
                ((ImportantRealmProxyInterface) obj).realmSet$dietary_fibre(dietary_fibreObj);
            }
        }
        if (json.has("saturated")) {
            if (json.isNull("saturated")) {
                ((ImportantRealmProxyInterface) obj).realmSet$saturated(null);
            } else {
                com.example.sgupta.nutrinfo.NutrientUnit saturatedObj = NutrientUnitRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("saturated"), update);
                ((ImportantRealmProxyInterface) obj).realmSet$saturated(saturatedObj);
            }
        }
        if (json.has("total_carbs")) {
            if (json.isNull("total_carbs")) {
                ((ImportantRealmProxyInterface) obj).realmSet$total_carbs(null);
            } else {
                com.example.sgupta.nutrinfo.NutrientUnit total_carbsObj = NutrientUnitRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("total_carbs"), update);
                ((ImportantRealmProxyInterface) obj).realmSet$total_carbs(total_carbsObj);
            }
        }
        if (json.has("potassium")) {
            if (json.isNull("potassium")) {
                ((ImportantRealmProxyInterface) obj).realmSet$potassium(null);
            } else {
                com.example.sgupta.nutrinfo.NutrientUnit potassiumObj = NutrientUnitRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("potassium"), update);
                ((ImportantRealmProxyInterface) obj).realmSet$potassium(potassiumObj);
            }
        }
        if (json.has("sodium")) {
            if (json.isNull("sodium")) {
                ((ImportantRealmProxyInterface) obj).realmSet$sodium(null);
            } else {
                com.example.sgupta.nutrinfo.NutrientUnit sodiumObj = NutrientUnitRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("sodium"), update);
                ((ImportantRealmProxyInterface) obj).realmSet$sodium(sodiumObj);
            }
        }
        if (json.has("calories")) {
            if (json.isNull("calories")) {
                ((ImportantRealmProxyInterface) obj).realmSet$calories(null);
            } else {
                com.example.sgupta.nutrinfo.NutrientUnit caloriesObj = NutrientUnitRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("calories"), update);
                ((ImportantRealmProxyInterface) obj).realmSet$calories(caloriesObj);
            }
        }
        if (json.has("sugar")) {
            if (json.isNull("sugar")) {
                ((ImportantRealmProxyInterface) obj).realmSet$sugar(null);
            } else {
                com.example.sgupta.nutrinfo.NutrientUnit sugarObj = NutrientUnitRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("sugar"), update);
                ((ImportantRealmProxyInterface) obj).realmSet$sugar(sugarObj);
            }
        }
        if (json.has("total_fats")) {
            if (json.isNull("total_fats")) {
                ((ImportantRealmProxyInterface) obj).realmSet$total_fats(null);
            } else {
                com.example.sgupta.nutrinfo.NutrientUnit total_fatsObj = NutrientUnitRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("total_fats"), update);
                ((ImportantRealmProxyInterface) obj).realmSet$total_fats(total_fatsObj);
            }
        }
        if (json.has("cholestrol")) {
            if (json.isNull("cholestrol")) {
                ((ImportantRealmProxyInterface) obj).realmSet$cholestrol(null);
            } else {
                com.example.sgupta.nutrinfo.NutrientUnit cholestrolObj = NutrientUnitRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("cholestrol"), update);
                ((ImportantRealmProxyInterface) obj).realmSet$cholestrol(cholestrolObj);
            }
        }
        if (json.has("polyunsaturated")) {
            if (json.isNull("polyunsaturated")) {
                ((ImportantRealmProxyInterface) obj).realmSet$polyunsaturated(null);
            } else {
                com.example.sgupta.nutrinfo.NutrientUnit polyunsaturatedObj = NutrientUnitRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("polyunsaturated"), update);
                ((ImportantRealmProxyInterface) obj).realmSet$polyunsaturated(polyunsaturatedObj);
            }
        }
        if (json.has("protein")) {
            if (json.isNull("protein")) {
                ((ImportantRealmProxyInterface) obj).realmSet$protein(null);
            } else {
                com.example.sgupta.nutrinfo.NutrientUnit proteinObj = NutrientUnitRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("protein"), update);
                ((ImportantRealmProxyInterface) obj).realmSet$protein(proteinObj);
            }
        }
        if (json.has("trans")) {
            if (json.isNull("trans")) {
                ((ImportantRealmProxyInterface) obj).realmSet$trans(null);
            } else {
                com.example.sgupta.nutrinfo.NutrientUnit transObj = NutrientUnitRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("trans"), update);
                ((ImportantRealmProxyInterface) obj).realmSet$trans(transObj);
            }
        }
        if (json.has("monounsaturated")) {
            if (json.isNull("monounsaturated")) {
                ((ImportantRealmProxyInterface) obj).realmSet$monounsaturated(null);
            } else {
                com.example.sgupta.nutrinfo.NutrientUnit monounsaturatedObj = NutrientUnitRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("monounsaturated"), update);
                ((ImportantRealmProxyInterface) obj).realmSet$monounsaturated(monounsaturatedObj);
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    public static Important createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        Important obj = realm.createObject(Important.class);
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("dietary_fibre")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ImportantRealmProxyInterface) obj).realmSet$dietary_fibre(null);
                } else {
                    com.example.sgupta.nutrinfo.NutrientUnit dietary_fibreObj = NutrientUnitRealmProxy.createUsingJsonStream(realm, reader);
                    ((ImportantRealmProxyInterface) obj).realmSet$dietary_fibre(dietary_fibreObj);
                }
            } else if (name.equals("saturated")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ImportantRealmProxyInterface) obj).realmSet$saturated(null);
                } else {
                    com.example.sgupta.nutrinfo.NutrientUnit saturatedObj = NutrientUnitRealmProxy.createUsingJsonStream(realm, reader);
                    ((ImportantRealmProxyInterface) obj).realmSet$saturated(saturatedObj);
                }
            } else if (name.equals("total_carbs")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ImportantRealmProxyInterface) obj).realmSet$total_carbs(null);
                } else {
                    com.example.sgupta.nutrinfo.NutrientUnit total_carbsObj = NutrientUnitRealmProxy.createUsingJsonStream(realm, reader);
                    ((ImportantRealmProxyInterface) obj).realmSet$total_carbs(total_carbsObj);
                }
            } else if (name.equals("potassium")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ImportantRealmProxyInterface) obj).realmSet$potassium(null);
                } else {
                    com.example.sgupta.nutrinfo.NutrientUnit potassiumObj = NutrientUnitRealmProxy.createUsingJsonStream(realm, reader);
                    ((ImportantRealmProxyInterface) obj).realmSet$potassium(potassiumObj);
                }
            } else if (name.equals("sodium")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ImportantRealmProxyInterface) obj).realmSet$sodium(null);
                } else {
                    com.example.sgupta.nutrinfo.NutrientUnit sodiumObj = NutrientUnitRealmProxy.createUsingJsonStream(realm, reader);
                    ((ImportantRealmProxyInterface) obj).realmSet$sodium(sodiumObj);
                }
            } else if (name.equals("calories")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ImportantRealmProxyInterface) obj).realmSet$calories(null);
                } else {
                    com.example.sgupta.nutrinfo.NutrientUnit caloriesObj = NutrientUnitRealmProxy.createUsingJsonStream(realm, reader);
                    ((ImportantRealmProxyInterface) obj).realmSet$calories(caloriesObj);
                }
            } else if (name.equals("sugar")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ImportantRealmProxyInterface) obj).realmSet$sugar(null);
                } else {
                    com.example.sgupta.nutrinfo.NutrientUnit sugarObj = NutrientUnitRealmProxy.createUsingJsonStream(realm, reader);
                    ((ImportantRealmProxyInterface) obj).realmSet$sugar(sugarObj);
                }
            } else if (name.equals("total_fats")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ImportantRealmProxyInterface) obj).realmSet$total_fats(null);
                } else {
                    com.example.sgupta.nutrinfo.NutrientUnit total_fatsObj = NutrientUnitRealmProxy.createUsingJsonStream(realm, reader);
                    ((ImportantRealmProxyInterface) obj).realmSet$total_fats(total_fatsObj);
                }
            } else if (name.equals("cholestrol")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ImportantRealmProxyInterface) obj).realmSet$cholestrol(null);
                } else {
                    com.example.sgupta.nutrinfo.NutrientUnit cholestrolObj = NutrientUnitRealmProxy.createUsingJsonStream(realm, reader);
                    ((ImportantRealmProxyInterface) obj).realmSet$cholestrol(cholestrolObj);
                }
            } else if (name.equals("polyunsaturated")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ImportantRealmProxyInterface) obj).realmSet$polyunsaturated(null);
                } else {
                    com.example.sgupta.nutrinfo.NutrientUnit polyunsaturatedObj = NutrientUnitRealmProxy.createUsingJsonStream(realm, reader);
                    ((ImportantRealmProxyInterface) obj).realmSet$polyunsaturated(polyunsaturatedObj);
                }
            } else if (name.equals("protein")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ImportantRealmProxyInterface) obj).realmSet$protein(null);
                } else {
                    com.example.sgupta.nutrinfo.NutrientUnit proteinObj = NutrientUnitRealmProxy.createUsingJsonStream(realm, reader);
                    ((ImportantRealmProxyInterface) obj).realmSet$protein(proteinObj);
                }
            } else if (name.equals("trans")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ImportantRealmProxyInterface) obj).realmSet$trans(null);
                } else {
                    com.example.sgupta.nutrinfo.NutrientUnit transObj = NutrientUnitRealmProxy.createUsingJsonStream(realm, reader);
                    ((ImportantRealmProxyInterface) obj).realmSet$trans(transObj);
                }
            } else if (name.equals("monounsaturated")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ImportantRealmProxyInterface) obj).realmSet$monounsaturated(null);
                } else {
                    com.example.sgupta.nutrinfo.NutrientUnit monounsaturatedObj = NutrientUnitRealmProxy.createUsingJsonStream(realm, reader);
                    ((ImportantRealmProxyInterface) obj).realmSet$monounsaturated(monounsaturatedObj);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return obj;
    }

    public static Important copyOrUpdate(Realm realm, Important object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        return copy(realm, object, update, cache);
    }

    public static Important copy(Realm realm, Important newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        Important realmObject = realm.createObject(Important.class);
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com.example.sgupta.nutrinfo.NutrientUnit dietary_fibreObj = ((ImportantRealmProxyInterface) newObject).realmGet$dietary_fibre();
        if (dietary_fibreObj != null) {
            com.example.sgupta.nutrinfo.NutrientUnit cachedietary_fibre = (com.example.sgupta.nutrinfo.NutrientUnit) cache.get(dietary_fibreObj);
            if (cachedietary_fibre != null) {
                ((ImportantRealmProxyInterface) realmObject).realmSet$dietary_fibre(cachedietary_fibre);
            } else {
                ((ImportantRealmProxyInterface) realmObject).realmSet$dietary_fibre(NutrientUnitRealmProxy.copyOrUpdate(realm, dietary_fibreObj, update, cache));
            }
        } else {
            ((ImportantRealmProxyInterface) realmObject).realmSet$dietary_fibre(null);
        }

        com.example.sgupta.nutrinfo.NutrientUnit saturatedObj = ((ImportantRealmProxyInterface) newObject).realmGet$saturated();
        if (saturatedObj != null) {
            com.example.sgupta.nutrinfo.NutrientUnit cachesaturated = (com.example.sgupta.nutrinfo.NutrientUnit) cache.get(saturatedObj);
            if (cachesaturated != null) {
                ((ImportantRealmProxyInterface) realmObject).realmSet$saturated(cachesaturated);
            } else {
                ((ImportantRealmProxyInterface) realmObject).realmSet$saturated(NutrientUnitRealmProxy.copyOrUpdate(realm, saturatedObj, update, cache));
            }
        } else {
            ((ImportantRealmProxyInterface) realmObject).realmSet$saturated(null);
        }

        com.example.sgupta.nutrinfo.NutrientUnit total_carbsObj = ((ImportantRealmProxyInterface) newObject).realmGet$total_carbs();
        if (total_carbsObj != null) {
            com.example.sgupta.nutrinfo.NutrientUnit cachetotal_carbs = (com.example.sgupta.nutrinfo.NutrientUnit) cache.get(total_carbsObj);
            if (cachetotal_carbs != null) {
                ((ImportantRealmProxyInterface) realmObject).realmSet$total_carbs(cachetotal_carbs);
            } else {
                ((ImportantRealmProxyInterface) realmObject).realmSet$total_carbs(NutrientUnitRealmProxy.copyOrUpdate(realm, total_carbsObj, update, cache));
            }
        } else {
            ((ImportantRealmProxyInterface) realmObject).realmSet$total_carbs(null);
        }

        com.example.sgupta.nutrinfo.NutrientUnit potassiumObj = ((ImportantRealmProxyInterface) newObject).realmGet$potassium();
        if (potassiumObj != null) {
            com.example.sgupta.nutrinfo.NutrientUnit cachepotassium = (com.example.sgupta.nutrinfo.NutrientUnit) cache.get(potassiumObj);
            if (cachepotassium != null) {
                ((ImportantRealmProxyInterface) realmObject).realmSet$potassium(cachepotassium);
            } else {
                ((ImportantRealmProxyInterface) realmObject).realmSet$potassium(NutrientUnitRealmProxy.copyOrUpdate(realm, potassiumObj, update, cache));
            }
        } else {
            ((ImportantRealmProxyInterface) realmObject).realmSet$potassium(null);
        }

        com.example.sgupta.nutrinfo.NutrientUnit sodiumObj = ((ImportantRealmProxyInterface) newObject).realmGet$sodium();
        if (sodiumObj != null) {
            com.example.sgupta.nutrinfo.NutrientUnit cachesodium = (com.example.sgupta.nutrinfo.NutrientUnit) cache.get(sodiumObj);
            if (cachesodium != null) {
                ((ImportantRealmProxyInterface) realmObject).realmSet$sodium(cachesodium);
            } else {
                ((ImportantRealmProxyInterface) realmObject).realmSet$sodium(NutrientUnitRealmProxy.copyOrUpdate(realm, sodiumObj, update, cache));
            }
        } else {
            ((ImportantRealmProxyInterface) realmObject).realmSet$sodium(null);
        }

        com.example.sgupta.nutrinfo.NutrientUnit caloriesObj = ((ImportantRealmProxyInterface) newObject).realmGet$calories();
        if (caloriesObj != null) {
            com.example.sgupta.nutrinfo.NutrientUnit cachecalories = (com.example.sgupta.nutrinfo.NutrientUnit) cache.get(caloriesObj);
            if (cachecalories != null) {
                ((ImportantRealmProxyInterface) realmObject).realmSet$calories(cachecalories);
            } else {
                ((ImportantRealmProxyInterface) realmObject).realmSet$calories(NutrientUnitRealmProxy.copyOrUpdate(realm, caloriesObj, update, cache));
            }
        } else {
            ((ImportantRealmProxyInterface) realmObject).realmSet$calories(null);
        }

        com.example.sgupta.nutrinfo.NutrientUnit sugarObj = ((ImportantRealmProxyInterface) newObject).realmGet$sugar();
        if (sugarObj != null) {
            com.example.sgupta.nutrinfo.NutrientUnit cachesugar = (com.example.sgupta.nutrinfo.NutrientUnit) cache.get(sugarObj);
            if (cachesugar != null) {
                ((ImportantRealmProxyInterface) realmObject).realmSet$sugar(cachesugar);
            } else {
                ((ImportantRealmProxyInterface) realmObject).realmSet$sugar(NutrientUnitRealmProxy.copyOrUpdate(realm, sugarObj, update, cache));
            }
        } else {
            ((ImportantRealmProxyInterface) realmObject).realmSet$sugar(null);
        }

        com.example.sgupta.nutrinfo.NutrientUnit total_fatsObj = ((ImportantRealmProxyInterface) newObject).realmGet$total_fats();
        if (total_fatsObj != null) {
            com.example.sgupta.nutrinfo.NutrientUnit cachetotal_fats = (com.example.sgupta.nutrinfo.NutrientUnit) cache.get(total_fatsObj);
            if (cachetotal_fats != null) {
                ((ImportantRealmProxyInterface) realmObject).realmSet$total_fats(cachetotal_fats);
            } else {
                ((ImportantRealmProxyInterface) realmObject).realmSet$total_fats(NutrientUnitRealmProxy.copyOrUpdate(realm, total_fatsObj, update, cache));
            }
        } else {
            ((ImportantRealmProxyInterface) realmObject).realmSet$total_fats(null);
        }

        com.example.sgupta.nutrinfo.NutrientUnit cholestrolObj = ((ImportantRealmProxyInterface) newObject).realmGet$cholestrol();
        if (cholestrolObj != null) {
            com.example.sgupta.nutrinfo.NutrientUnit cachecholestrol = (com.example.sgupta.nutrinfo.NutrientUnit) cache.get(cholestrolObj);
            if (cachecholestrol != null) {
                ((ImportantRealmProxyInterface) realmObject).realmSet$cholestrol(cachecholestrol);
            } else {
                ((ImportantRealmProxyInterface) realmObject).realmSet$cholestrol(NutrientUnitRealmProxy.copyOrUpdate(realm, cholestrolObj, update, cache));
            }
        } else {
            ((ImportantRealmProxyInterface) realmObject).realmSet$cholestrol(null);
        }

        com.example.sgupta.nutrinfo.NutrientUnit polyunsaturatedObj = ((ImportantRealmProxyInterface) newObject).realmGet$polyunsaturated();
        if (polyunsaturatedObj != null) {
            com.example.sgupta.nutrinfo.NutrientUnit cachepolyunsaturated = (com.example.sgupta.nutrinfo.NutrientUnit) cache.get(polyunsaturatedObj);
            if (cachepolyunsaturated != null) {
                ((ImportantRealmProxyInterface) realmObject).realmSet$polyunsaturated(cachepolyunsaturated);
            } else {
                ((ImportantRealmProxyInterface) realmObject).realmSet$polyunsaturated(NutrientUnitRealmProxy.copyOrUpdate(realm, polyunsaturatedObj, update, cache));
            }
        } else {
            ((ImportantRealmProxyInterface) realmObject).realmSet$polyunsaturated(null);
        }

        com.example.sgupta.nutrinfo.NutrientUnit proteinObj = ((ImportantRealmProxyInterface) newObject).realmGet$protein();
        if (proteinObj != null) {
            com.example.sgupta.nutrinfo.NutrientUnit cacheprotein = (com.example.sgupta.nutrinfo.NutrientUnit) cache.get(proteinObj);
            if (cacheprotein != null) {
                ((ImportantRealmProxyInterface) realmObject).realmSet$protein(cacheprotein);
            } else {
                ((ImportantRealmProxyInterface) realmObject).realmSet$protein(NutrientUnitRealmProxy.copyOrUpdate(realm, proteinObj, update, cache));
            }
        } else {
            ((ImportantRealmProxyInterface) realmObject).realmSet$protein(null);
        }

        com.example.sgupta.nutrinfo.NutrientUnit transObj = ((ImportantRealmProxyInterface) newObject).realmGet$trans();
        if (transObj != null) {
            com.example.sgupta.nutrinfo.NutrientUnit cachetrans = (com.example.sgupta.nutrinfo.NutrientUnit) cache.get(transObj);
            if (cachetrans != null) {
                ((ImportantRealmProxyInterface) realmObject).realmSet$trans(cachetrans);
            } else {
                ((ImportantRealmProxyInterface) realmObject).realmSet$trans(NutrientUnitRealmProxy.copyOrUpdate(realm, transObj, update, cache));
            }
        } else {
            ((ImportantRealmProxyInterface) realmObject).realmSet$trans(null);
        }

        com.example.sgupta.nutrinfo.NutrientUnit monounsaturatedObj = ((ImportantRealmProxyInterface) newObject).realmGet$monounsaturated();
        if (monounsaturatedObj != null) {
            com.example.sgupta.nutrinfo.NutrientUnit cachemonounsaturated = (com.example.sgupta.nutrinfo.NutrientUnit) cache.get(monounsaturatedObj);
            if (cachemonounsaturated != null) {
                ((ImportantRealmProxyInterface) realmObject).realmSet$monounsaturated(cachemonounsaturated);
            } else {
                ((ImportantRealmProxyInterface) realmObject).realmSet$monounsaturated(NutrientUnitRealmProxy.copyOrUpdate(realm, monounsaturatedObj, update, cache));
            }
        } else {
            ((ImportantRealmProxyInterface) realmObject).realmSet$monounsaturated(null);
        }
        return realmObject;
    }

    public static Important createDetachedCopy(Important realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        Important standaloneObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (Important)cachedObject.object;
            } else {
                standaloneObject = (Important)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            standaloneObject = new Important();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, standaloneObject));
        }

        // Deep copy of dietary_fibre
        ((ImportantRealmProxyInterface) standaloneObject).realmSet$dietary_fibre(NutrientUnitRealmProxy.createDetachedCopy(((ImportantRealmProxyInterface) realmObject).realmGet$dietary_fibre(), currentDepth + 1, maxDepth, cache));

        // Deep copy of saturated
        ((ImportantRealmProxyInterface) standaloneObject).realmSet$saturated(NutrientUnitRealmProxy.createDetachedCopy(((ImportantRealmProxyInterface) realmObject).realmGet$saturated(), currentDepth + 1, maxDepth, cache));

        // Deep copy of total_carbs
        ((ImportantRealmProxyInterface) standaloneObject).realmSet$total_carbs(NutrientUnitRealmProxy.createDetachedCopy(((ImportantRealmProxyInterface) realmObject).realmGet$total_carbs(), currentDepth + 1, maxDepth, cache));

        // Deep copy of potassium
        ((ImportantRealmProxyInterface) standaloneObject).realmSet$potassium(NutrientUnitRealmProxy.createDetachedCopy(((ImportantRealmProxyInterface) realmObject).realmGet$potassium(), currentDepth + 1, maxDepth, cache));

        // Deep copy of sodium
        ((ImportantRealmProxyInterface) standaloneObject).realmSet$sodium(NutrientUnitRealmProxy.createDetachedCopy(((ImportantRealmProxyInterface) realmObject).realmGet$sodium(), currentDepth + 1, maxDepth, cache));

        // Deep copy of calories
        ((ImportantRealmProxyInterface) standaloneObject).realmSet$calories(NutrientUnitRealmProxy.createDetachedCopy(((ImportantRealmProxyInterface) realmObject).realmGet$calories(), currentDepth + 1, maxDepth, cache));

        // Deep copy of sugar
        ((ImportantRealmProxyInterface) standaloneObject).realmSet$sugar(NutrientUnitRealmProxy.createDetachedCopy(((ImportantRealmProxyInterface) realmObject).realmGet$sugar(), currentDepth + 1, maxDepth, cache));

        // Deep copy of total_fats
        ((ImportantRealmProxyInterface) standaloneObject).realmSet$total_fats(NutrientUnitRealmProxy.createDetachedCopy(((ImportantRealmProxyInterface) realmObject).realmGet$total_fats(), currentDepth + 1, maxDepth, cache));

        // Deep copy of cholestrol
        ((ImportantRealmProxyInterface) standaloneObject).realmSet$cholestrol(NutrientUnitRealmProxy.createDetachedCopy(((ImportantRealmProxyInterface) realmObject).realmGet$cholestrol(), currentDepth + 1, maxDepth, cache));

        // Deep copy of polyunsaturated
        ((ImportantRealmProxyInterface) standaloneObject).realmSet$polyunsaturated(NutrientUnitRealmProxy.createDetachedCopy(((ImportantRealmProxyInterface) realmObject).realmGet$polyunsaturated(), currentDepth + 1, maxDepth, cache));

        // Deep copy of protein
        ((ImportantRealmProxyInterface) standaloneObject).realmSet$protein(NutrientUnitRealmProxy.createDetachedCopy(((ImportantRealmProxyInterface) realmObject).realmGet$protein(), currentDepth + 1, maxDepth, cache));

        // Deep copy of trans
        ((ImportantRealmProxyInterface) standaloneObject).realmSet$trans(NutrientUnitRealmProxy.createDetachedCopy(((ImportantRealmProxyInterface) realmObject).realmGet$trans(), currentDepth + 1, maxDepth, cache));

        // Deep copy of monounsaturated
        ((ImportantRealmProxyInterface) standaloneObject).realmSet$monounsaturated(NutrientUnitRealmProxy.createDetachedCopy(((ImportantRealmProxyInterface) realmObject).realmGet$monounsaturated(), currentDepth + 1, maxDepth, cache));
        return standaloneObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Important = [");
        stringBuilder.append("{dietary_fibre:");
        stringBuilder.append(realmGet$dietary_fibre() != null ? "NutrientUnit" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{saturated:");
        stringBuilder.append(realmGet$saturated() != null ? "NutrientUnit" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{total_carbs:");
        stringBuilder.append(realmGet$total_carbs() != null ? "NutrientUnit" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{potassium:");
        stringBuilder.append(realmGet$potassium() != null ? "NutrientUnit" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sodium:");
        stringBuilder.append(realmGet$sodium() != null ? "NutrientUnit" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{calories:");
        stringBuilder.append(realmGet$calories() != null ? "NutrientUnit" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sugar:");
        stringBuilder.append(realmGet$sugar() != null ? "NutrientUnit" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{total_fats:");
        stringBuilder.append(realmGet$total_fats() != null ? "NutrientUnit" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{cholestrol:");
        stringBuilder.append(realmGet$cholestrol() != null ? "NutrientUnit" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{polyunsaturated:");
        stringBuilder.append(realmGet$polyunsaturated() != null ? "NutrientUnit" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{protein:");
        stringBuilder.append(realmGet$protein() != null ? "NutrientUnit" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{trans:");
        stringBuilder.append(realmGet$trans() != null ? "NutrientUnit" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{monounsaturated:");
        stringBuilder.append(realmGet$monounsaturated() != null ? "NutrientUnit" : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImportantRealmProxy aImportant = (ImportantRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aImportant.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aImportant.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aImportant.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
