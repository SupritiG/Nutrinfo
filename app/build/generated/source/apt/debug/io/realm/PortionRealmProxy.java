package io.realm;


import android.util.JsonReader;
import android.util.JsonToken;
import com.example.sgupta.nutrinfo.Nutrient;
import com.example.sgupta.nutrinfo.Portion;
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

public class PortionRealmProxy extends Portion
    implements RealmObjectProxy, PortionRealmProxyInterface {

    static final class PortionColumnInfo extends ColumnInfo {

        public final long nameIndex;
        public final long nutrientsIndex;

        PortionColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(2);
            this.nameIndex = getValidColumnIndex(path, table, "Portion", "name");
            indicesMap.put("name", this.nameIndex);

            this.nutrientsIndex = getValidColumnIndex(path, table, "Portion", "nutrients");
            indicesMap.put("nutrients", this.nutrientsIndex);

            setIndicesMap(indicesMap);
        }
    }

    private final PortionColumnInfo columnInfo;
    private final ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("name");
        fieldNames.add("nutrients");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    PortionRealmProxy(ColumnInfo columnInfo) {
        this.columnInfo = (PortionColumnInfo) columnInfo;
        this.proxyState = new ProxyState(Portion.class);
    }

    @SuppressWarnings("cast")
    public String realmGet$name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameIndex);
    }

    public void realmSet$name(String value) {
        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameIndex, value);
    }

    public Nutrient realmGet$nutrients() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.nutrientsIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.example.sgupta.nutrinfo.Nutrient.class, proxyState.getRow$realm().getLink(columnInfo.nutrientsIndex));
    }

    public void realmSet$nutrients(Nutrient value) {
        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.nutrientsIndex);
            return;
        }
        if (!RealmObject.isValid(value)) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy)value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.nutrientsIndex, ((RealmObjectProxy)value).realmGet$proxyState().getRow$realm().getIndex());
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if (!transaction.hasTable("class_Portion")) {
            Table table = transaction.getTable("class_Portion");
            table.addColumn(RealmFieldType.STRING, "name", Table.NULLABLE);
            if (!transaction.hasTable("class_Nutrient")) {
                NutrientRealmProxy.initTable(transaction);
            }
            table.addColumnLink(RealmFieldType.OBJECT, "nutrients", transaction.getTable("class_Nutrient"));
            table.setPrimaryKey("");
            return table;
        }
        return transaction.getTable("class_Portion");
    }

    public static PortionColumnInfo validateTable(ImplicitTransaction transaction) {
        if (transaction.hasTable("class_Portion")) {
            Table table = transaction.getTable("class_Portion");
            if (table.getColumnCount() != 2) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field count does not match - expected 2 but was " + table.getColumnCount());
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < 2; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final PortionColumnInfo columnInfo = new PortionColumnInfo(transaction.getPath(), table);

            if (!columnTypes.containsKey("name")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'name' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("name") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'name' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.nameIndex)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field 'name' is required. Either set @Required to field 'name' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("nutrients")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'nutrients' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("nutrients") != RealmFieldType.OBJECT) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'Nutrient' for field 'nutrients'");
            }
            if (!transaction.hasTable("class_Nutrient")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_Nutrient' for field 'nutrients'");
            }
            Table table_1 = transaction.getTable("class_Nutrient");
            if (!table.getLinkTarget(columnInfo.nutrientsIndex).hasSameSchema(table_1)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'nutrients': '" + table.getLinkTarget(columnInfo.nutrientsIndex).getName() + "' expected - was '" + table_1.getName() + "'");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(transaction.getPath(), "The Portion class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_Portion";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static Portion createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        Portion obj = realm.createObject(Portion.class);
        if (json.has("name")) {
            if (json.isNull("name")) {
                ((PortionRealmProxyInterface) obj).realmSet$name(null);
            } else {
                ((PortionRealmProxyInterface) obj).realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("nutrients")) {
            if (json.isNull("nutrients")) {
                ((PortionRealmProxyInterface) obj).realmSet$nutrients(null);
            } else {
                com.example.sgupta.nutrinfo.Nutrient nutrientsObj = NutrientRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("nutrients"), update);
                ((PortionRealmProxyInterface) obj).realmSet$nutrients(nutrientsObj);
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    public static Portion createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        Portion obj = realm.createObject(Portion.class);
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PortionRealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((PortionRealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
            } else if (name.equals("nutrients")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PortionRealmProxyInterface) obj).realmSet$nutrients(null);
                } else {
                    com.example.sgupta.nutrinfo.Nutrient nutrientsObj = NutrientRealmProxy.createUsingJsonStream(realm, reader);
                    ((PortionRealmProxyInterface) obj).realmSet$nutrients(nutrientsObj);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return obj;
    }

    public static Portion copyOrUpdate(Realm realm, Portion object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        return copy(realm, object, update, cache);
    }

    public static Portion copy(Realm realm, Portion newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        Portion realmObject = realm.createObject(Portion.class);
        cache.put(newObject, (RealmObjectProxy) realmObject);
        ((PortionRealmProxyInterface) realmObject).realmSet$name(((PortionRealmProxyInterface) newObject).realmGet$name());

        com.example.sgupta.nutrinfo.Nutrient nutrientsObj = ((PortionRealmProxyInterface) newObject).realmGet$nutrients();
        if (nutrientsObj != null) {
            com.example.sgupta.nutrinfo.Nutrient cachenutrients = (com.example.sgupta.nutrinfo.Nutrient) cache.get(nutrientsObj);
            if (cachenutrients != null) {
                ((PortionRealmProxyInterface) realmObject).realmSet$nutrients(cachenutrients);
            } else {
                ((PortionRealmProxyInterface) realmObject).realmSet$nutrients(NutrientRealmProxy.copyOrUpdate(realm, nutrientsObj, update, cache));
            }
        } else {
            ((PortionRealmProxyInterface) realmObject).realmSet$nutrients(null);
        }
        return realmObject;
    }

    public static Portion createDetachedCopy(Portion realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        Portion standaloneObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (Portion)cachedObject.object;
            } else {
                standaloneObject = (Portion)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            standaloneObject = new Portion();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, standaloneObject));
        }
        ((PortionRealmProxyInterface) standaloneObject).realmSet$name(((PortionRealmProxyInterface) realmObject).realmGet$name());

        // Deep copy of nutrients
        ((PortionRealmProxyInterface) standaloneObject).realmSet$nutrients(NutrientRealmProxy.createDetachedCopy(((PortionRealmProxyInterface) realmObject).realmGet$nutrients(), currentDepth + 1, maxDepth, cache));
        return standaloneObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Portion = [");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nutrients:");
        stringBuilder.append(realmGet$nutrients() != null ? "Nutrient" : "null");
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
        PortionRealmProxy aPortion = (PortionRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPortion.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPortion.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPortion.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
