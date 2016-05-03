package io.realm;


import android.util.JsonReader;
import android.util.JsonToken;
import com.example.sgupta.nutrinfo.Extra;
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

public class ExtraRealmProxy extends Extra
    implements RealmObjectProxy, ExtraRealmProxyInterface {

    static final class ExtraColumnInfo extends ColumnInfo {

        public final long vitamin_aIndex;
        public final long phosphorousIndex;
        public final long retinolIndex;
        public final long ironIndex;
        public final long thiaminIndex;
        public final long seleniumIndex;
        public final long starchIndex;
        public final long zincIndex;
        public final long waterIndex;
        public final long riboflavinIndex;
        public final long calciumIndex;
        public final long vitamin_cIndex;
        public final long b_caroteneIndex;

        ExtraColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(13);
            this.vitamin_aIndex = getValidColumnIndex(path, table, "Extra", "vitamin_a");
            indicesMap.put("vitamin_a", this.vitamin_aIndex);

            this.phosphorousIndex = getValidColumnIndex(path, table, "Extra", "phosphorous");
            indicesMap.put("phosphorous", this.phosphorousIndex);

            this.retinolIndex = getValidColumnIndex(path, table, "Extra", "retinol");
            indicesMap.put("retinol", this.retinolIndex);

            this.ironIndex = getValidColumnIndex(path, table, "Extra", "iron");
            indicesMap.put("iron", this.ironIndex);

            this.thiaminIndex = getValidColumnIndex(path, table, "Extra", "thiamin");
            indicesMap.put("thiamin", this.thiaminIndex);

            this.seleniumIndex = getValidColumnIndex(path, table, "Extra", "selenium");
            indicesMap.put("selenium", this.seleniumIndex);

            this.starchIndex = getValidColumnIndex(path, table, "Extra", "starch");
            indicesMap.put("starch", this.starchIndex);

            this.zincIndex = getValidColumnIndex(path, table, "Extra", "zinc");
            indicesMap.put("zinc", this.zincIndex);

            this.waterIndex = getValidColumnIndex(path, table, "Extra", "water");
            indicesMap.put("water", this.waterIndex);

            this.riboflavinIndex = getValidColumnIndex(path, table, "Extra", "riboflavin");
            indicesMap.put("riboflavin", this.riboflavinIndex);

            this.calciumIndex = getValidColumnIndex(path, table, "Extra", "calcium");
            indicesMap.put("calcium", this.calciumIndex);

            this.vitamin_cIndex = getValidColumnIndex(path, table, "Extra", "vitamin_c");
            indicesMap.put("vitamin_c", this.vitamin_cIndex);

            this.b_caroteneIndex = getValidColumnIndex(path, table, "Extra", "b_carotene");
            indicesMap.put("b_carotene", this.b_caroteneIndex);

            setIndicesMap(indicesMap);
        }
    }

    private final ExtraColumnInfo columnInfo;
    private final ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("vitamin_a");
        fieldNames.add("phosphorous");
        fieldNames.add("retinol");
        fieldNames.add("iron");
        fieldNames.add("thiamin");
        fieldNames.add("selenium");
        fieldNames.add("starch");
        fieldNames.add("zinc");
        fieldNames.add("water");
        fieldNames.add("riboflavin");
        fieldNames.add("calcium");
        fieldNames.add("vitamin_c");
        fieldNames.add("b_carotene");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    ExtraRealmProxy(ColumnInfo columnInfo) {
        this.columnInfo = (ExtraColumnInfo) columnInfo;
        this.proxyState = new ProxyState(Extra.class);
    }

    public NutrientUnit realmGet$vitamin_a() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.vitamin_aIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.example.sgupta.nutrinfo.NutrientUnit.class, proxyState.getRow$realm().getLink(columnInfo.vitamin_aIndex));
    }

    public void realmSet$vitamin_a(NutrientUnit value) {
        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.vitamin_aIndex);
            return;
        }
        if (!RealmObject.isValid(value)) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy)value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.vitamin_aIndex, ((RealmObjectProxy)value).realmGet$proxyState().getRow$realm().getIndex());
    }

    public NutrientUnit realmGet$phosphorous() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.phosphorousIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.example.sgupta.nutrinfo.NutrientUnit.class, proxyState.getRow$realm().getLink(columnInfo.phosphorousIndex));
    }

    public void realmSet$phosphorous(NutrientUnit value) {
        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.phosphorousIndex);
            return;
        }
        if (!RealmObject.isValid(value)) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy)value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.phosphorousIndex, ((RealmObjectProxy)value).realmGet$proxyState().getRow$realm().getIndex());
    }

    public NutrientUnit realmGet$retinol() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.retinolIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.example.sgupta.nutrinfo.NutrientUnit.class, proxyState.getRow$realm().getLink(columnInfo.retinolIndex));
    }

    public void realmSet$retinol(NutrientUnit value) {
        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.retinolIndex);
            return;
        }
        if (!RealmObject.isValid(value)) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy)value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.retinolIndex, ((RealmObjectProxy)value).realmGet$proxyState().getRow$realm().getIndex());
    }

    public NutrientUnit realmGet$iron() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.ironIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.example.sgupta.nutrinfo.NutrientUnit.class, proxyState.getRow$realm().getLink(columnInfo.ironIndex));
    }

    public void realmSet$iron(NutrientUnit value) {
        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.ironIndex);
            return;
        }
        if (!RealmObject.isValid(value)) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy)value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.ironIndex, ((RealmObjectProxy)value).realmGet$proxyState().getRow$realm().getIndex());
    }

    public NutrientUnit realmGet$thiamin() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.thiaminIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.example.sgupta.nutrinfo.NutrientUnit.class, proxyState.getRow$realm().getLink(columnInfo.thiaminIndex));
    }

    public void realmSet$thiamin(NutrientUnit value) {
        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.thiaminIndex);
            return;
        }
        if (!RealmObject.isValid(value)) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy)value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.thiaminIndex, ((RealmObjectProxy)value).realmGet$proxyState().getRow$realm().getIndex());
    }

    public NutrientUnit realmGet$selenium() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.seleniumIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.example.sgupta.nutrinfo.NutrientUnit.class, proxyState.getRow$realm().getLink(columnInfo.seleniumIndex));
    }

    public void realmSet$selenium(NutrientUnit value) {
        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.seleniumIndex);
            return;
        }
        if (!RealmObject.isValid(value)) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy)value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.seleniumIndex, ((RealmObjectProxy)value).realmGet$proxyState().getRow$realm().getIndex());
    }

    public NutrientUnit realmGet$starch() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.starchIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.example.sgupta.nutrinfo.NutrientUnit.class, proxyState.getRow$realm().getLink(columnInfo.starchIndex));
    }

    public void realmSet$starch(NutrientUnit value) {
        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.starchIndex);
            return;
        }
        if (!RealmObject.isValid(value)) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy)value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.starchIndex, ((RealmObjectProxy)value).realmGet$proxyState().getRow$realm().getIndex());
    }

    public NutrientUnit realmGet$zinc() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.zincIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.example.sgupta.nutrinfo.NutrientUnit.class, proxyState.getRow$realm().getLink(columnInfo.zincIndex));
    }

    public void realmSet$zinc(NutrientUnit value) {
        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.zincIndex);
            return;
        }
        if (!RealmObject.isValid(value)) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy)value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.zincIndex, ((RealmObjectProxy)value).realmGet$proxyState().getRow$realm().getIndex());
    }

    public NutrientUnit realmGet$water() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.waterIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.example.sgupta.nutrinfo.NutrientUnit.class, proxyState.getRow$realm().getLink(columnInfo.waterIndex));
    }

    public void realmSet$water(NutrientUnit value) {
        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.waterIndex);
            return;
        }
        if (!RealmObject.isValid(value)) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy)value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.waterIndex, ((RealmObjectProxy)value).realmGet$proxyState().getRow$realm().getIndex());
    }

    public NutrientUnit realmGet$riboflavin() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.riboflavinIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.example.sgupta.nutrinfo.NutrientUnit.class, proxyState.getRow$realm().getLink(columnInfo.riboflavinIndex));
    }

    public void realmSet$riboflavin(NutrientUnit value) {
        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.riboflavinIndex);
            return;
        }
        if (!RealmObject.isValid(value)) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy)value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.riboflavinIndex, ((RealmObjectProxy)value).realmGet$proxyState().getRow$realm().getIndex());
    }

    public NutrientUnit realmGet$calcium() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.calciumIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.example.sgupta.nutrinfo.NutrientUnit.class, proxyState.getRow$realm().getLink(columnInfo.calciumIndex));
    }

    public void realmSet$calcium(NutrientUnit value) {
        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.calciumIndex);
            return;
        }
        if (!RealmObject.isValid(value)) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy)value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.calciumIndex, ((RealmObjectProxy)value).realmGet$proxyState().getRow$realm().getIndex());
    }

    public NutrientUnit realmGet$vitamin_c() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.vitamin_cIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.example.sgupta.nutrinfo.NutrientUnit.class, proxyState.getRow$realm().getLink(columnInfo.vitamin_cIndex));
    }

    public void realmSet$vitamin_c(NutrientUnit value) {
        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.vitamin_cIndex);
            return;
        }
        if (!RealmObject.isValid(value)) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy)value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.vitamin_cIndex, ((RealmObjectProxy)value).realmGet$proxyState().getRow$realm().getIndex());
    }

    public NutrientUnit realmGet$b_carotene() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.b_caroteneIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.example.sgupta.nutrinfo.NutrientUnit.class, proxyState.getRow$realm().getLink(columnInfo.b_caroteneIndex));
    }

    public void realmSet$b_carotene(NutrientUnit value) {
        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.b_caroteneIndex);
            return;
        }
        if (!RealmObject.isValid(value)) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy)value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.b_caroteneIndex, ((RealmObjectProxy)value).realmGet$proxyState().getRow$realm().getIndex());
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if (!transaction.hasTable("class_Extra")) {
            Table table = transaction.getTable("class_Extra");
            if (!transaction.hasTable("class_NutrientUnit")) {
                NutrientUnitRealmProxy.initTable(transaction);
            }
            table.addColumnLink(RealmFieldType.OBJECT, "vitamin_a", transaction.getTable("class_NutrientUnit"));
            if (!transaction.hasTable("class_NutrientUnit")) {
                NutrientUnitRealmProxy.initTable(transaction);
            }
            table.addColumnLink(RealmFieldType.OBJECT, "phosphorous", transaction.getTable("class_NutrientUnit"));
            if (!transaction.hasTable("class_NutrientUnit")) {
                NutrientUnitRealmProxy.initTable(transaction);
            }
            table.addColumnLink(RealmFieldType.OBJECT, "retinol", transaction.getTable("class_NutrientUnit"));
            if (!transaction.hasTable("class_NutrientUnit")) {
                NutrientUnitRealmProxy.initTable(transaction);
            }
            table.addColumnLink(RealmFieldType.OBJECT, "iron", transaction.getTable("class_NutrientUnit"));
            if (!transaction.hasTable("class_NutrientUnit")) {
                NutrientUnitRealmProxy.initTable(transaction);
            }
            table.addColumnLink(RealmFieldType.OBJECT, "thiamin", transaction.getTable("class_NutrientUnit"));
            if (!transaction.hasTable("class_NutrientUnit")) {
                NutrientUnitRealmProxy.initTable(transaction);
            }
            table.addColumnLink(RealmFieldType.OBJECT, "selenium", transaction.getTable("class_NutrientUnit"));
            if (!transaction.hasTable("class_NutrientUnit")) {
                NutrientUnitRealmProxy.initTable(transaction);
            }
            table.addColumnLink(RealmFieldType.OBJECT, "starch", transaction.getTable("class_NutrientUnit"));
            if (!transaction.hasTable("class_NutrientUnit")) {
                NutrientUnitRealmProxy.initTable(transaction);
            }
            table.addColumnLink(RealmFieldType.OBJECT, "zinc", transaction.getTable("class_NutrientUnit"));
            if (!transaction.hasTable("class_NutrientUnit")) {
                NutrientUnitRealmProxy.initTable(transaction);
            }
            table.addColumnLink(RealmFieldType.OBJECT, "water", transaction.getTable("class_NutrientUnit"));
            if (!transaction.hasTable("class_NutrientUnit")) {
                NutrientUnitRealmProxy.initTable(transaction);
            }
            table.addColumnLink(RealmFieldType.OBJECT, "riboflavin", transaction.getTable("class_NutrientUnit"));
            if (!transaction.hasTable("class_NutrientUnit")) {
                NutrientUnitRealmProxy.initTable(transaction);
            }
            table.addColumnLink(RealmFieldType.OBJECT, "calcium", transaction.getTable("class_NutrientUnit"));
            if (!transaction.hasTable("class_NutrientUnit")) {
                NutrientUnitRealmProxy.initTable(transaction);
            }
            table.addColumnLink(RealmFieldType.OBJECT, "vitamin_c", transaction.getTable("class_NutrientUnit"));
            if (!transaction.hasTable("class_NutrientUnit")) {
                NutrientUnitRealmProxy.initTable(transaction);
            }
            table.addColumnLink(RealmFieldType.OBJECT, "b_carotene", transaction.getTable("class_NutrientUnit"));
            table.setPrimaryKey("");
            return table;
        }
        return transaction.getTable("class_Extra");
    }

    public static ExtraColumnInfo validateTable(ImplicitTransaction transaction) {
        if (transaction.hasTable("class_Extra")) {
            Table table = transaction.getTable("class_Extra");
            if (table.getColumnCount() != 13) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field count does not match - expected 13 but was " + table.getColumnCount());
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < 13; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final ExtraColumnInfo columnInfo = new ExtraColumnInfo(transaction.getPath(), table);

            if (!columnTypes.containsKey("vitamin_a")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'vitamin_a' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("vitamin_a") != RealmFieldType.OBJECT) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'NutrientUnit' for field 'vitamin_a'");
            }
            if (!transaction.hasTable("class_NutrientUnit")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_NutrientUnit' for field 'vitamin_a'");
            }
            Table table_0 = transaction.getTable("class_NutrientUnit");
            if (!table.getLinkTarget(columnInfo.vitamin_aIndex).hasSameSchema(table_0)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'vitamin_a': '" + table.getLinkTarget(columnInfo.vitamin_aIndex).getName() + "' expected - was '" + table_0.getName() + "'");
            }
            if (!columnTypes.containsKey("phosphorous")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'phosphorous' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("phosphorous") != RealmFieldType.OBJECT) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'NutrientUnit' for field 'phosphorous'");
            }
            if (!transaction.hasTable("class_NutrientUnit")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_NutrientUnit' for field 'phosphorous'");
            }
            Table table_1 = transaction.getTable("class_NutrientUnit");
            if (!table.getLinkTarget(columnInfo.phosphorousIndex).hasSameSchema(table_1)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'phosphorous': '" + table.getLinkTarget(columnInfo.phosphorousIndex).getName() + "' expected - was '" + table_1.getName() + "'");
            }
            if (!columnTypes.containsKey("retinol")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'retinol' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("retinol") != RealmFieldType.OBJECT) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'NutrientUnit' for field 'retinol'");
            }
            if (!transaction.hasTable("class_NutrientUnit")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_NutrientUnit' for field 'retinol'");
            }
            Table table_2 = transaction.getTable("class_NutrientUnit");
            if (!table.getLinkTarget(columnInfo.retinolIndex).hasSameSchema(table_2)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'retinol': '" + table.getLinkTarget(columnInfo.retinolIndex).getName() + "' expected - was '" + table_2.getName() + "'");
            }
            if (!columnTypes.containsKey("iron")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'iron' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("iron") != RealmFieldType.OBJECT) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'NutrientUnit' for field 'iron'");
            }
            if (!transaction.hasTable("class_NutrientUnit")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_NutrientUnit' for field 'iron'");
            }
            Table table_3 = transaction.getTable("class_NutrientUnit");
            if (!table.getLinkTarget(columnInfo.ironIndex).hasSameSchema(table_3)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'iron': '" + table.getLinkTarget(columnInfo.ironIndex).getName() + "' expected - was '" + table_3.getName() + "'");
            }
            if (!columnTypes.containsKey("thiamin")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'thiamin' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("thiamin") != RealmFieldType.OBJECT) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'NutrientUnit' for field 'thiamin'");
            }
            if (!transaction.hasTable("class_NutrientUnit")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_NutrientUnit' for field 'thiamin'");
            }
            Table table_4 = transaction.getTable("class_NutrientUnit");
            if (!table.getLinkTarget(columnInfo.thiaminIndex).hasSameSchema(table_4)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'thiamin': '" + table.getLinkTarget(columnInfo.thiaminIndex).getName() + "' expected - was '" + table_4.getName() + "'");
            }
            if (!columnTypes.containsKey("selenium")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'selenium' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("selenium") != RealmFieldType.OBJECT) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'NutrientUnit' for field 'selenium'");
            }
            if (!transaction.hasTable("class_NutrientUnit")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_NutrientUnit' for field 'selenium'");
            }
            Table table_5 = transaction.getTable("class_NutrientUnit");
            if (!table.getLinkTarget(columnInfo.seleniumIndex).hasSameSchema(table_5)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'selenium': '" + table.getLinkTarget(columnInfo.seleniumIndex).getName() + "' expected - was '" + table_5.getName() + "'");
            }
            if (!columnTypes.containsKey("starch")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'starch' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("starch") != RealmFieldType.OBJECT) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'NutrientUnit' for field 'starch'");
            }
            if (!transaction.hasTable("class_NutrientUnit")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_NutrientUnit' for field 'starch'");
            }
            Table table_6 = transaction.getTable("class_NutrientUnit");
            if (!table.getLinkTarget(columnInfo.starchIndex).hasSameSchema(table_6)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'starch': '" + table.getLinkTarget(columnInfo.starchIndex).getName() + "' expected - was '" + table_6.getName() + "'");
            }
            if (!columnTypes.containsKey("zinc")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'zinc' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("zinc") != RealmFieldType.OBJECT) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'NutrientUnit' for field 'zinc'");
            }
            if (!transaction.hasTable("class_NutrientUnit")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_NutrientUnit' for field 'zinc'");
            }
            Table table_7 = transaction.getTable("class_NutrientUnit");
            if (!table.getLinkTarget(columnInfo.zincIndex).hasSameSchema(table_7)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'zinc': '" + table.getLinkTarget(columnInfo.zincIndex).getName() + "' expected - was '" + table_7.getName() + "'");
            }
            if (!columnTypes.containsKey("water")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'water' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("water") != RealmFieldType.OBJECT) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'NutrientUnit' for field 'water'");
            }
            if (!transaction.hasTable("class_NutrientUnit")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_NutrientUnit' for field 'water'");
            }
            Table table_8 = transaction.getTable("class_NutrientUnit");
            if (!table.getLinkTarget(columnInfo.waterIndex).hasSameSchema(table_8)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'water': '" + table.getLinkTarget(columnInfo.waterIndex).getName() + "' expected - was '" + table_8.getName() + "'");
            }
            if (!columnTypes.containsKey("riboflavin")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'riboflavin' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("riboflavin") != RealmFieldType.OBJECT) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'NutrientUnit' for field 'riboflavin'");
            }
            if (!transaction.hasTable("class_NutrientUnit")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_NutrientUnit' for field 'riboflavin'");
            }
            Table table_9 = transaction.getTable("class_NutrientUnit");
            if (!table.getLinkTarget(columnInfo.riboflavinIndex).hasSameSchema(table_9)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'riboflavin': '" + table.getLinkTarget(columnInfo.riboflavinIndex).getName() + "' expected - was '" + table_9.getName() + "'");
            }
            if (!columnTypes.containsKey("calcium")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'calcium' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("calcium") != RealmFieldType.OBJECT) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'NutrientUnit' for field 'calcium'");
            }
            if (!transaction.hasTable("class_NutrientUnit")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_NutrientUnit' for field 'calcium'");
            }
            Table table_10 = transaction.getTable("class_NutrientUnit");
            if (!table.getLinkTarget(columnInfo.calciumIndex).hasSameSchema(table_10)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'calcium': '" + table.getLinkTarget(columnInfo.calciumIndex).getName() + "' expected - was '" + table_10.getName() + "'");
            }
            if (!columnTypes.containsKey("vitamin_c")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'vitamin_c' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("vitamin_c") != RealmFieldType.OBJECT) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'NutrientUnit' for field 'vitamin_c'");
            }
            if (!transaction.hasTable("class_NutrientUnit")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_NutrientUnit' for field 'vitamin_c'");
            }
            Table table_11 = transaction.getTable("class_NutrientUnit");
            if (!table.getLinkTarget(columnInfo.vitamin_cIndex).hasSameSchema(table_11)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'vitamin_c': '" + table.getLinkTarget(columnInfo.vitamin_cIndex).getName() + "' expected - was '" + table_11.getName() + "'");
            }
            if (!columnTypes.containsKey("b_carotene")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'b_carotene' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("b_carotene") != RealmFieldType.OBJECT) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'NutrientUnit' for field 'b_carotene'");
            }
            if (!transaction.hasTable("class_NutrientUnit")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_NutrientUnit' for field 'b_carotene'");
            }
            Table table_12 = transaction.getTable("class_NutrientUnit");
            if (!table.getLinkTarget(columnInfo.b_caroteneIndex).hasSameSchema(table_12)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'b_carotene': '" + table.getLinkTarget(columnInfo.b_caroteneIndex).getName() + "' expected - was '" + table_12.getName() + "'");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(transaction.getPath(), "The Extra class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_Extra";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static Extra createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        Extra obj = realm.createObject(Extra.class);
        if (json.has("vitamin_a")) {
            if (json.isNull("vitamin_a")) {
                ((ExtraRealmProxyInterface) obj).realmSet$vitamin_a(null);
            } else {
                com.example.sgupta.nutrinfo.NutrientUnit vitamin_aObj = NutrientUnitRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("vitamin_a"), update);
                ((ExtraRealmProxyInterface) obj).realmSet$vitamin_a(vitamin_aObj);
            }
        }
        if (json.has("phosphorous")) {
            if (json.isNull("phosphorous")) {
                ((ExtraRealmProxyInterface) obj).realmSet$phosphorous(null);
            } else {
                com.example.sgupta.nutrinfo.NutrientUnit phosphorousObj = NutrientUnitRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("phosphorous"), update);
                ((ExtraRealmProxyInterface) obj).realmSet$phosphorous(phosphorousObj);
            }
        }
        if (json.has("retinol")) {
            if (json.isNull("retinol")) {
                ((ExtraRealmProxyInterface) obj).realmSet$retinol(null);
            } else {
                com.example.sgupta.nutrinfo.NutrientUnit retinolObj = NutrientUnitRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("retinol"), update);
                ((ExtraRealmProxyInterface) obj).realmSet$retinol(retinolObj);
            }
        }
        if (json.has("iron")) {
            if (json.isNull("iron")) {
                ((ExtraRealmProxyInterface) obj).realmSet$iron(null);
            } else {
                com.example.sgupta.nutrinfo.NutrientUnit ironObj = NutrientUnitRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("iron"), update);
                ((ExtraRealmProxyInterface) obj).realmSet$iron(ironObj);
            }
        }
        if (json.has("thiamin")) {
            if (json.isNull("thiamin")) {
                ((ExtraRealmProxyInterface) obj).realmSet$thiamin(null);
            } else {
                com.example.sgupta.nutrinfo.NutrientUnit thiaminObj = NutrientUnitRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("thiamin"), update);
                ((ExtraRealmProxyInterface) obj).realmSet$thiamin(thiaminObj);
            }
        }
        if (json.has("selenium")) {
            if (json.isNull("selenium")) {
                ((ExtraRealmProxyInterface) obj).realmSet$selenium(null);
            } else {
                com.example.sgupta.nutrinfo.NutrientUnit seleniumObj = NutrientUnitRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("selenium"), update);
                ((ExtraRealmProxyInterface) obj).realmSet$selenium(seleniumObj);
            }
        }
        if (json.has("starch")) {
            if (json.isNull("starch")) {
                ((ExtraRealmProxyInterface) obj).realmSet$starch(null);
            } else {
                com.example.sgupta.nutrinfo.NutrientUnit starchObj = NutrientUnitRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("starch"), update);
                ((ExtraRealmProxyInterface) obj).realmSet$starch(starchObj);
            }
        }
        if (json.has("zinc")) {
            if (json.isNull("zinc")) {
                ((ExtraRealmProxyInterface) obj).realmSet$zinc(null);
            } else {
                com.example.sgupta.nutrinfo.NutrientUnit zincObj = NutrientUnitRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("zinc"), update);
                ((ExtraRealmProxyInterface) obj).realmSet$zinc(zincObj);
            }
        }
        if (json.has("water")) {
            if (json.isNull("water")) {
                ((ExtraRealmProxyInterface) obj).realmSet$water(null);
            } else {
                com.example.sgupta.nutrinfo.NutrientUnit waterObj = NutrientUnitRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("water"), update);
                ((ExtraRealmProxyInterface) obj).realmSet$water(waterObj);
            }
        }
        if (json.has("riboflavin")) {
            if (json.isNull("riboflavin")) {
                ((ExtraRealmProxyInterface) obj).realmSet$riboflavin(null);
            } else {
                com.example.sgupta.nutrinfo.NutrientUnit riboflavinObj = NutrientUnitRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("riboflavin"), update);
                ((ExtraRealmProxyInterface) obj).realmSet$riboflavin(riboflavinObj);
            }
        }
        if (json.has("calcium")) {
            if (json.isNull("calcium")) {
                ((ExtraRealmProxyInterface) obj).realmSet$calcium(null);
            } else {
                com.example.sgupta.nutrinfo.NutrientUnit calciumObj = NutrientUnitRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("calcium"), update);
                ((ExtraRealmProxyInterface) obj).realmSet$calcium(calciumObj);
            }
        }
        if (json.has("vitamin_c")) {
            if (json.isNull("vitamin_c")) {
                ((ExtraRealmProxyInterface) obj).realmSet$vitamin_c(null);
            } else {
                com.example.sgupta.nutrinfo.NutrientUnit vitamin_cObj = NutrientUnitRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("vitamin_c"), update);
                ((ExtraRealmProxyInterface) obj).realmSet$vitamin_c(vitamin_cObj);
            }
        }
        if (json.has("b_carotene")) {
            if (json.isNull("b_carotene")) {
                ((ExtraRealmProxyInterface) obj).realmSet$b_carotene(null);
            } else {
                com.example.sgupta.nutrinfo.NutrientUnit b_caroteneObj = NutrientUnitRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("b_carotene"), update);
                ((ExtraRealmProxyInterface) obj).realmSet$b_carotene(b_caroteneObj);
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    public static Extra createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        Extra obj = realm.createObject(Extra.class);
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("vitamin_a")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ExtraRealmProxyInterface) obj).realmSet$vitamin_a(null);
                } else {
                    com.example.sgupta.nutrinfo.NutrientUnit vitamin_aObj = NutrientUnitRealmProxy.createUsingJsonStream(realm, reader);
                    ((ExtraRealmProxyInterface) obj).realmSet$vitamin_a(vitamin_aObj);
                }
            } else if (name.equals("phosphorous")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ExtraRealmProxyInterface) obj).realmSet$phosphorous(null);
                } else {
                    com.example.sgupta.nutrinfo.NutrientUnit phosphorousObj = NutrientUnitRealmProxy.createUsingJsonStream(realm, reader);
                    ((ExtraRealmProxyInterface) obj).realmSet$phosphorous(phosphorousObj);
                }
            } else if (name.equals("retinol")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ExtraRealmProxyInterface) obj).realmSet$retinol(null);
                } else {
                    com.example.sgupta.nutrinfo.NutrientUnit retinolObj = NutrientUnitRealmProxy.createUsingJsonStream(realm, reader);
                    ((ExtraRealmProxyInterface) obj).realmSet$retinol(retinolObj);
                }
            } else if (name.equals("iron")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ExtraRealmProxyInterface) obj).realmSet$iron(null);
                } else {
                    com.example.sgupta.nutrinfo.NutrientUnit ironObj = NutrientUnitRealmProxy.createUsingJsonStream(realm, reader);
                    ((ExtraRealmProxyInterface) obj).realmSet$iron(ironObj);
                }
            } else if (name.equals("thiamin")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ExtraRealmProxyInterface) obj).realmSet$thiamin(null);
                } else {
                    com.example.sgupta.nutrinfo.NutrientUnit thiaminObj = NutrientUnitRealmProxy.createUsingJsonStream(realm, reader);
                    ((ExtraRealmProxyInterface) obj).realmSet$thiamin(thiaminObj);
                }
            } else if (name.equals("selenium")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ExtraRealmProxyInterface) obj).realmSet$selenium(null);
                } else {
                    com.example.sgupta.nutrinfo.NutrientUnit seleniumObj = NutrientUnitRealmProxy.createUsingJsonStream(realm, reader);
                    ((ExtraRealmProxyInterface) obj).realmSet$selenium(seleniumObj);
                }
            } else if (name.equals("starch")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ExtraRealmProxyInterface) obj).realmSet$starch(null);
                } else {
                    com.example.sgupta.nutrinfo.NutrientUnit starchObj = NutrientUnitRealmProxy.createUsingJsonStream(realm, reader);
                    ((ExtraRealmProxyInterface) obj).realmSet$starch(starchObj);
                }
            } else if (name.equals("zinc")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ExtraRealmProxyInterface) obj).realmSet$zinc(null);
                } else {
                    com.example.sgupta.nutrinfo.NutrientUnit zincObj = NutrientUnitRealmProxy.createUsingJsonStream(realm, reader);
                    ((ExtraRealmProxyInterface) obj).realmSet$zinc(zincObj);
                }
            } else if (name.equals("water")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ExtraRealmProxyInterface) obj).realmSet$water(null);
                } else {
                    com.example.sgupta.nutrinfo.NutrientUnit waterObj = NutrientUnitRealmProxy.createUsingJsonStream(realm, reader);
                    ((ExtraRealmProxyInterface) obj).realmSet$water(waterObj);
                }
            } else if (name.equals("riboflavin")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ExtraRealmProxyInterface) obj).realmSet$riboflavin(null);
                } else {
                    com.example.sgupta.nutrinfo.NutrientUnit riboflavinObj = NutrientUnitRealmProxy.createUsingJsonStream(realm, reader);
                    ((ExtraRealmProxyInterface) obj).realmSet$riboflavin(riboflavinObj);
                }
            } else if (name.equals("calcium")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ExtraRealmProxyInterface) obj).realmSet$calcium(null);
                } else {
                    com.example.sgupta.nutrinfo.NutrientUnit calciumObj = NutrientUnitRealmProxy.createUsingJsonStream(realm, reader);
                    ((ExtraRealmProxyInterface) obj).realmSet$calcium(calciumObj);
                }
            } else if (name.equals("vitamin_c")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ExtraRealmProxyInterface) obj).realmSet$vitamin_c(null);
                } else {
                    com.example.sgupta.nutrinfo.NutrientUnit vitamin_cObj = NutrientUnitRealmProxy.createUsingJsonStream(realm, reader);
                    ((ExtraRealmProxyInterface) obj).realmSet$vitamin_c(vitamin_cObj);
                }
            } else if (name.equals("b_carotene")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ExtraRealmProxyInterface) obj).realmSet$b_carotene(null);
                } else {
                    com.example.sgupta.nutrinfo.NutrientUnit b_caroteneObj = NutrientUnitRealmProxy.createUsingJsonStream(realm, reader);
                    ((ExtraRealmProxyInterface) obj).realmSet$b_carotene(b_caroteneObj);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return obj;
    }

    public static Extra copyOrUpdate(Realm realm, Extra object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        return copy(realm, object, update, cache);
    }

    public static Extra copy(Realm realm, Extra newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        Extra realmObject = realm.createObject(Extra.class);
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com.example.sgupta.nutrinfo.NutrientUnit vitamin_aObj = ((ExtraRealmProxyInterface) newObject).realmGet$vitamin_a();
        if (vitamin_aObj != null) {
            com.example.sgupta.nutrinfo.NutrientUnit cachevitamin_a = (com.example.sgupta.nutrinfo.NutrientUnit) cache.get(vitamin_aObj);
            if (cachevitamin_a != null) {
                ((ExtraRealmProxyInterface) realmObject).realmSet$vitamin_a(cachevitamin_a);
            } else {
                ((ExtraRealmProxyInterface) realmObject).realmSet$vitamin_a(NutrientUnitRealmProxy.copyOrUpdate(realm, vitamin_aObj, update, cache));
            }
        } else {
            ((ExtraRealmProxyInterface) realmObject).realmSet$vitamin_a(null);
        }

        com.example.sgupta.nutrinfo.NutrientUnit phosphorousObj = ((ExtraRealmProxyInterface) newObject).realmGet$phosphorous();
        if (phosphorousObj != null) {
            com.example.sgupta.nutrinfo.NutrientUnit cachephosphorous = (com.example.sgupta.nutrinfo.NutrientUnit) cache.get(phosphorousObj);
            if (cachephosphorous != null) {
                ((ExtraRealmProxyInterface) realmObject).realmSet$phosphorous(cachephosphorous);
            } else {
                ((ExtraRealmProxyInterface) realmObject).realmSet$phosphorous(NutrientUnitRealmProxy.copyOrUpdate(realm, phosphorousObj, update, cache));
            }
        } else {
            ((ExtraRealmProxyInterface) realmObject).realmSet$phosphorous(null);
        }

        com.example.sgupta.nutrinfo.NutrientUnit retinolObj = ((ExtraRealmProxyInterface) newObject).realmGet$retinol();
        if (retinolObj != null) {
            com.example.sgupta.nutrinfo.NutrientUnit cacheretinol = (com.example.sgupta.nutrinfo.NutrientUnit) cache.get(retinolObj);
            if (cacheretinol != null) {
                ((ExtraRealmProxyInterface) realmObject).realmSet$retinol(cacheretinol);
            } else {
                ((ExtraRealmProxyInterface) realmObject).realmSet$retinol(NutrientUnitRealmProxy.copyOrUpdate(realm, retinolObj, update, cache));
            }
        } else {
            ((ExtraRealmProxyInterface) realmObject).realmSet$retinol(null);
        }

        com.example.sgupta.nutrinfo.NutrientUnit ironObj = ((ExtraRealmProxyInterface) newObject).realmGet$iron();
        if (ironObj != null) {
            com.example.sgupta.nutrinfo.NutrientUnit cacheiron = (com.example.sgupta.nutrinfo.NutrientUnit) cache.get(ironObj);
            if (cacheiron != null) {
                ((ExtraRealmProxyInterface) realmObject).realmSet$iron(cacheiron);
            } else {
                ((ExtraRealmProxyInterface) realmObject).realmSet$iron(NutrientUnitRealmProxy.copyOrUpdate(realm, ironObj, update, cache));
            }
        } else {
            ((ExtraRealmProxyInterface) realmObject).realmSet$iron(null);
        }

        com.example.sgupta.nutrinfo.NutrientUnit thiaminObj = ((ExtraRealmProxyInterface) newObject).realmGet$thiamin();
        if (thiaminObj != null) {
            com.example.sgupta.nutrinfo.NutrientUnit cachethiamin = (com.example.sgupta.nutrinfo.NutrientUnit) cache.get(thiaminObj);
            if (cachethiamin != null) {
                ((ExtraRealmProxyInterface) realmObject).realmSet$thiamin(cachethiamin);
            } else {
                ((ExtraRealmProxyInterface) realmObject).realmSet$thiamin(NutrientUnitRealmProxy.copyOrUpdate(realm, thiaminObj, update, cache));
            }
        } else {
            ((ExtraRealmProxyInterface) realmObject).realmSet$thiamin(null);
        }

        com.example.sgupta.nutrinfo.NutrientUnit seleniumObj = ((ExtraRealmProxyInterface) newObject).realmGet$selenium();
        if (seleniumObj != null) {
            com.example.sgupta.nutrinfo.NutrientUnit cacheselenium = (com.example.sgupta.nutrinfo.NutrientUnit) cache.get(seleniumObj);
            if (cacheselenium != null) {
                ((ExtraRealmProxyInterface) realmObject).realmSet$selenium(cacheselenium);
            } else {
                ((ExtraRealmProxyInterface) realmObject).realmSet$selenium(NutrientUnitRealmProxy.copyOrUpdate(realm, seleniumObj, update, cache));
            }
        } else {
            ((ExtraRealmProxyInterface) realmObject).realmSet$selenium(null);
        }

        com.example.sgupta.nutrinfo.NutrientUnit starchObj = ((ExtraRealmProxyInterface) newObject).realmGet$starch();
        if (starchObj != null) {
            com.example.sgupta.nutrinfo.NutrientUnit cachestarch = (com.example.sgupta.nutrinfo.NutrientUnit) cache.get(starchObj);
            if (cachestarch != null) {
                ((ExtraRealmProxyInterface) realmObject).realmSet$starch(cachestarch);
            } else {
                ((ExtraRealmProxyInterface) realmObject).realmSet$starch(NutrientUnitRealmProxy.copyOrUpdate(realm, starchObj, update, cache));
            }
        } else {
            ((ExtraRealmProxyInterface) realmObject).realmSet$starch(null);
        }

        com.example.sgupta.nutrinfo.NutrientUnit zincObj = ((ExtraRealmProxyInterface) newObject).realmGet$zinc();
        if (zincObj != null) {
            com.example.sgupta.nutrinfo.NutrientUnit cachezinc = (com.example.sgupta.nutrinfo.NutrientUnit) cache.get(zincObj);
            if (cachezinc != null) {
                ((ExtraRealmProxyInterface) realmObject).realmSet$zinc(cachezinc);
            } else {
                ((ExtraRealmProxyInterface) realmObject).realmSet$zinc(NutrientUnitRealmProxy.copyOrUpdate(realm, zincObj, update, cache));
            }
        } else {
            ((ExtraRealmProxyInterface) realmObject).realmSet$zinc(null);
        }

        com.example.sgupta.nutrinfo.NutrientUnit waterObj = ((ExtraRealmProxyInterface) newObject).realmGet$water();
        if (waterObj != null) {
            com.example.sgupta.nutrinfo.NutrientUnit cachewater = (com.example.sgupta.nutrinfo.NutrientUnit) cache.get(waterObj);
            if (cachewater != null) {
                ((ExtraRealmProxyInterface) realmObject).realmSet$water(cachewater);
            } else {
                ((ExtraRealmProxyInterface) realmObject).realmSet$water(NutrientUnitRealmProxy.copyOrUpdate(realm, waterObj, update, cache));
            }
        } else {
            ((ExtraRealmProxyInterface) realmObject).realmSet$water(null);
        }

        com.example.sgupta.nutrinfo.NutrientUnit riboflavinObj = ((ExtraRealmProxyInterface) newObject).realmGet$riboflavin();
        if (riboflavinObj != null) {
            com.example.sgupta.nutrinfo.NutrientUnit cacheriboflavin = (com.example.sgupta.nutrinfo.NutrientUnit) cache.get(riboflavinObj);
            if (cacheriboflavin != null) {
                ((ExtraRealmProxyInterface) realmObject).realmSet$riboflavin(cacheriboflavin);
            } else {
                ((ExtraRealmProxyInterface) realmObject).realmSet$riboflavin(NutrientUnitRealmProxy.copyOrUpdate(realm, riboflavinObj, update, cache));
            }
        } else {
            ((ExtraRealmProxyInterface) realmObject).realmSet$riboflavin(null);
        }

        com.example.sgupta.nutrinfo.NutrientUnit calciumObj = ((ExtraRealmProxyInterface) newObject).realmGet$calcium();
        if (calciumObj != null) {
            com.example.sgupta.nutrinfo.NutrientUnit cachecalcium = (com.example.sgupta.nutrinfo.NutrientUnit) cache.get(calciumObj);
            if (cachecalcium != null) {
                ((ExtraRealmProxyInterface) realmObject).realmSet$calcium(cachecalcium);
            } else {
                ((ExtraRealmProxyInterface) realmObject).realmSet$calcium(NutrientUnitRealmProxy.copyOrUpdate(realm, calciumObj, update, cache));
            }
        } else {
            ((ExtraRealmProxyInterface) realmObject).realmSet$calcium(null);
        }

        com.example.sgupta.nutrinfo.NutrientUnit vitamin_cObj = ((ExtraRealmProxyInterface) newObject).realmGet$vitamin_c();
        if (vitamin_cObj != null) {
            com.example.sgupta.nutrinfo.NutrientUnit cachevitamin_c = (com.example.sgupta.nutrinfo.NutrientUnit) cache.get(vitamin_cObj);
            if (cachevitamin_c != null) {
                ((ExtraRealmProxyInterface) realmObject).realmSet$vitamin_c(cachevitamin_c);
            } else {
                ((ExtraRealmProxyInterface) realmObject).realmSet$vitamin_c(NutrientUnitRealmProxy.copyOrUpdate(realm, vitamin_cObj, update, cache));
            }
        } else {
            ((ExtraRealmProxyInterface) realmObject).realmSet$vitamin_c(null);
        }

        com.example.sgupta.nutrinfo.NutrientUnit b_caroteneObj = ((ExtraRealmProxyInterface) newObject).realmGet$b_carotene();
        if (b_caroteneObj != null) {
            com.example.sgupta.nutrinfo.NutrientUnit cacheb_carotene = (com.example.sgupta.nutrinfo.NutrientUnit) cache.get(b_caroteneObj);
            if (cacheb_carotene != null) {
                ((ExtraRealmProxyInterface) realmObject).realmSet$b_carotene(cacheb_carotene);
            } else {
                ((ExtraRealmProxyInterface) realmObject).realmSet$b_carotene(NutrientUnitRealmProxy.copyOrUpdate(realm, b_caroteneObj, update, cache));
            }
        } else {
            ((ExtraRealmProxyInterface) realmObject).realmSet$b_carotene(null);
        }
        return realmObject;
    }

    public static Extra createDetachedCopy(Extra realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        Extra standaloneObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (Extra)cachedObject.object;
            } else {
                standaloneObject = (Extra)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            standaloneObject = new Extra();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, standaloneObject));
        }

        // Deep copy of vitamin_a
        ((ExtraRealmProxyInterface) standaloneObject).realmSet$vitamin_a(NutrientUnitRealmProxy.createDetachedCopy(((ExtraRealmProxyInterface) realmObject).realmGet$vitamin_a(), currentDepth + 1, maxDepth, cache));

        // Deep copy of phosphorous
        ((ExtraRealmProxyInterface) standaloneObject).realmSet$phosphorous(NutrientUnitRealmProxy.createDetachedCopy(((ExtraRealmProxyInterface) realmObject).realmGet$phosphorous(), currentDepth + 1, maxDepth, cache));

        // Deep copy of retinol
        ((ExtraRealmProxyInterface) standaloneObject).realmSet$retinol(NutrientUnitRealmProxy.createDetachedCopy(((ExtraRealmProxyInterface) realmObject).realmGet$retinol(), currentDepth + 1, maxDepth, cache));

        // Deep copy of iron
        ((ExtraRealmProxyInterface) standaloneObject).realmSet$iron(NutrientUnitRealmProxy.createDetachedCopy(((ExtraRealmProxyInterface) realmObject).realmGet$iron(), currentDepth + 1, maxDepth, cache));

        // Deep copy of thiamin
        ((ExtraRealmProxyInterface) standaloneObject).realmSet$thiamin(NutrientUnitRealmProxy.createDetachedCopy(((ExtraRealmProxyInterface) realmObject).realmGet$thiamin(), currentDepth + 1, maxDepth, cache));

        // Deep copy of selenium
        ((ExtraRealmProxyInterface) standaloneObject).realmSet$selenium(NutrientUnitRealmProxy.createDetachedCopy(((ExtraRealmProxyInterface) realmObject).realmGet$selenium(), currentDepth + 1, maxDepth, cache));

        // Deep copy of starch
        ((ExtraRealmProxyInterface) standaloneObject).realmSet$starch(NutrientUnitRealmProxy.createDetachedCopy(((ExtraRealmProxyInterface) realmObject).realmGet$starch(), currentDepth + 1, maxDepth, cache));

        // Deep copy of zinc
        ((ExtraRealmProxyInterface) standaloneObject).realmSet$zinc(NutrientUnitRealmProxy.createDetachedCopy(((ExtraRealmProxyInterface) realmObject).realmGet$zinc(), currentDepth + 1, maxDepth, cache));

        // Deep copy of water
        ((ExtraRealmProxyInterface) standaloneObject).realmSet$water(NutrientUnitRealmProxy.createDetachedCopy(((ExtraRealmProxyInterface) realmObject).realmGet$water(), currentDepth + 1, maxDepth, cache));

        // Deep copy of riboflavin
        ((ExtraRealmProxyInterface) standaloneObject).realmSet$riboflavin(NutrientUnitRealmProxy.createDetachedCopy(((ExtraRealmProxyInterface) realmObject).realmGet$riboflavin(), currentDepth + 1, maxDepth, cache));

        // Deep copy of calcium
        ((ExtraRealmProxyInterface) standaloneObject).realmSet$calcium(NutrientUnitRealmProxy.createDetachedCopy(((ExtraRealmProxyInterface) realmObject).realmGet$calcium(), currentDepth + 1, maxDepth, cache));

        // Deep copy of vitamin_c
        ((ExtraRealmProxyInterface) standaloneObject).realmSet$vitamin_c(NutrientUnitRealmProxy.createDetachedCopy(((ExtraRealmProxyInterface) realmObject).realmGet$vitamin_c(), currentDepth + 1, maxDepth, cache));

        // Deep copy of b_carotene
        ((ExtraRealmProxyInterface) standaloneObject).realmSet$b_carotene(NutrientUnitRealmProxy.createDetachedCopy(((ExtraRealmProxyInterface) realmObject).realmGet$b_carotene(), currentDepth + 1, maxDepth, cache));
        return standaloneObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Extra = [");
        stringBuilder.append("{vitamin_a:");
        stringBuilder.append(realmGet$vitamin_a() != null ? "NutrientUnit" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{phosphorous:");
        stringBuilder.append(realmGet$phosphorous() != null ? "NutrientUnit" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{retinol:");
        stringBuilder.append(realmGet$retinol() != null ? "NutrientUnit" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{iron:");
        stringBuilder.append(realmGet$iron() != null ? "NutrientUnit" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{thiamin:");
        stringBuilder.append(realmGet$thiamin() != null ? "NutrientUnit" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{selenium:");
        stringBuilder.append(realmGet$selenium() != null ? "NutrientUnit" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{starch:");
        stringBuilder.append(realmGet$starch() != null ? "NutrientUnit" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{zinc:");
        stringBuilder.append(realmGet$zinc() != null ? "NutrientUnit" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{water:");
        stringBuilder.append(realmGet$water() != null ? "NutrientUnit" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{riboflavin:");
        stringBuilder.append(realmGet$riboflavin() != null ? "NutrientUnit" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{calcium:");
        stringBuilder.append(realmGet$calcium() != null ? "NutrientUnit" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{vitamin_c:");
        stringBuilder.append(realmGet$vitamin_c() != null ? "NutrientUnit" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{b_carotene:");
        stringBuilder.append(realmGet$b_carotene() != null ? "NutrientUnit" : "null");
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
        ExtraRealmProxy aExtra = (ExtraRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aExtra.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aExtra.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aExtra.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
