package io.realm;


import android.util.JsonReader;
import android.util.JsonToken;
import com.example.sgupta.nutrinfo.Extra;
import com.example.sgupta.nutrinfo.Important;
import com.example.sgupta.nutrinfo.Nutrient;
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

public class NutrientRealmProxy extends Nutrient
    implements RealmObjectProxy, NutrientRealmProxyInterface {

    static final class NutrientColumnInfo extends ColumnInfo {

        public final long importantIndex;
        public final long extraIndex;

        NutrientColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(2);
            this.importantIndex = getValidColumnIndex(path, table, "Nutrient", "important");
            indicesMap.put("important", this.importantIndex);

            this.extraIndex = getValidColumnIndex(path, table, "Nutrient", "extra");
            indicesMap.put("extra", this.extraIndex);

            setIndicesMap(indicesMap);
        }
    }

    private final NutrientColumnInfo columnInfo;
    private final ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("important");
        fieldNames.add("extra");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    NutrientRealmProxy(ColumnInfo columnInfo) {
        this.columnInfo = (NutrientColumnInfo) columnInfo;
        this.proxyState = new ProxyState(Nutrient.class);
    }

    public Important realmGet$important() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.importantIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.example.sgupta.nutrinfo.Important.class, proxyState.getRow$realm().getLink(columnInfo.importantIndex));
    }

    public void realmSet$important(Important value) {
        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.importantIndex);
            return;
        }
        if (!RealmObject.isValid(value)) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy)value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.importantIndex, ((RealmObjectProxy)value).realmGet$proxyState().getRow$realm().getIndex());
    }

    public Extra realmGet$extra() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNullLink(columnInfo.extraIndex)) {
            return null;
        }
        return proxyState.getRealm$realm().get(com.example.sgupta.nutrinfo.Extra.class, proxyState.getRow$realm().getLink(columnInfo.extraIndex));
    }

    public void realmSet$extra(Extra value) {
        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().nullifyLink(columnInfo.extraIndex);
            return;
        }
        if (!RealmObject.isValid(value)) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((RealmObjectProxy)value).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        proxyState.getRow$realm().setLink(columnInfo.extraIndex, ((RealmObjectProxy)value).realmGet$proxyState().getRow$realm().getIndex());
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if (!transaction.hasTable("class_Nutrient")) {
            Table table = transaction.getTable("class_Nutrient");
            if (!transaction.hasTable("class_Important")) {
                ImportantRealmProxy.initTable(transaction);
            }
            table.addColumnLink(RealmFieldType.OBJECT, "important", transaction.getTable("class_Important"));
            if (!transaction.hasTable("class_Extra")) {
                ExtraRealmProxy.initTable(transaction);
            }
            table.addColumnLink(RealmFieldType.OBJECT, "extra", transaction.getTable("class_Extra"));
            table.setPrimaryKey("");
            return table;
        }
        return transaction.getTable("class_Nutrient");
    }

    public static NutrientColumnInfo validateTable(ImplicitTransaction transaction) {
        if (transaction.hasTable("class_Nutrient")) {
            Table table = transaction.getTable("class_Nutrient");
            if (table.getColumnCount() != 2) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field count does not match - expected 2 but was " + table.getColumnCount());
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < 2; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final NutrientColumnInfo columnInfo = new NutrientColumnInfo(transaction.getPath(), table);

            if (!columnTypes.containsKey("important")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'important' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("important") != RealmFieldType.OBJECT) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'Important' for field 'important'");
            }
            if (!transaction.hasTable("class_Important")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_Important' for field 'important'");
            }
            Table table_0 = transaction.getTable("class_Important");
            if (!table.getLinkTarget(columnInfo.importantIndex).hasSameSchema(table_0)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'important': '" + table.getLinkTarget(columnInfo.importantIndex).getName() + "' expected - was '" + table_0.getName() + "'");
            }
            if (!columnTypes.containsKey("extra")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'extra' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("extra") != RealmFieldType.OBJECT) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'Extra' for field 'extra'");
            }
            if (!transaction.hasTable("class_Extra")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_Extra' for field 'extra'");
            }
            Table table_1 = transaction.getTable("class_Extra");
            if (!table.getLinkTarget(columnInfo.extraIndex).hasSameSchema(table_1)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmObject for field 'extra': '" + table.getLinkTarget(columnInfo.extraIndex).getName() + "' expected - was '" + table_1.getName() + "'");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(transaction.getPath(), "The Nutrient class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_Nutrient";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static Nutrient createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        Nutrient obj = realm.createObject(Nutrient.class);
        if (json.has("important")) {
            if (json.isNull("important")) {
                ((NutrientRealmProxyInterface) obj).realmSet$important(null);
            } else {
                com.example.sgupta.nutrinfo.Important importantObj = ImportantRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("important"), update);
                ((NutrientRealmProxyInterface) obj).realmSet$important(importantObj);
            }
        }
        if (json.has("extra")) {
            if (json.isNull("extra")) {
                ((NutrientRealmProxyInterface) obj).realmSet$extra(null);
            } else {
                com.example.sgupta.nutrinfo.Extra extraObj = ExtraRealmProxy.createOrUpdateUsingJsonObject(realm, json.getJSONObject("extra"), update);
                ((NutrientRealmProxyInterface) obj).realmSet$extra(extraObj);
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    public static Nutrient createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        Nutrient obj = realm.createObject(Nutrient.class);
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("important")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((NutrientRealmProxyInterface) obj).realmSet$important(null);
                } else {
                    com.example.sgupta.nutrinfo.Important importantObj = ImportantRealmProxy.createUsingJsonStream(realm, reader);
                    ((NutrientRealmProxyInterface) obj).realmSet$important(importantObj);
                }
            } else if (name.equals("extra")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((NutrientRealmProxyInterface) obj).realmSet$extra(null);
                } else {
                    com.example.sgupta.nutrinfo.Extra extraObj = ExtraRealmProxy.createUsingJsonStream(realm, reader);
                    ((NutrientRealmProxyInterface) obj).realmSet$extra(extraObj);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return obj;
    }

    public static Nutrient copyOrUpdate(Realm realm, Nutrient object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        return copy(realm, object, update, cache);
    }

    public static Nutrient copy(Realm realm, Nutrient newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        Nutrient realmObject = realm.createObject(Nutrient.class);
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com.example.sgupta.nutrinfo.Important importantObj = ((NutrientRealmProxyInterface) newObject).realmGet$important();
        if (importantObj != null) {
            com.example.sgupta.nutrinfo.Important cacheimportant = (com.example.sgupta.nutrinfo.Important) cache.get(importantObj);
            if (cacheimportant != null) {
                ((NutrientRealmProxyInterface) realmObject).realmSet$important(cacheimportant);
            } else {
                ((NutrientRealmProxyInterface) realmObject).realmSet$important(ImportantRealmProxy.copyOrUpdate(realm, importantObj, update, cache));
            }
        } else {
            ((NutrientRealmProxyInterface) realmObject).realmSet$important(null);
        }

        com.example.sgupta.nutrinfo.Extra extraObj = ((NutrientRealmProxyInterface) newObject).realmGet$extra();
        if (extraObj != null) {
            com.example.sgupta.nutrinfo.Extra cacheextra = (com.example.sgupta.nutrinfo.Extra) cache.get(extraObj);
            if (cacheextra != null) {
                ((NutrientRealmProxyInterface) realmObject).realmSet$extra(cacheextra);
            } else {
                ((NutrientRealmProxyInterface) realmObject).realmSet$extra(ExtraRealmProxy.copyOrUpdate(realm, extraObj, update, cache));
            }
        } else {
            ((NutrientRealmProxyInterface) realmObject).realmSet$extra(null);
        }
        return realmObject;
    }

    public static Nutrient createDetachedCopy(Nutrient realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        Nutrient standaloneObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (Nutrient)cachedObject.object;
            } else {
                standaloneObject = (Nutrient)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            standaloneObject = new Nutrient();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, standaloneObject));
        }

        // Deep copy of important
        ((NutrientRealmProxyInterface) standaloneObject).realmSet$important(ImportantRealmProxy.createDetachedCopy(((NutrientRealmProxyInterface) realmObject).realmGet$important(), currentDepth + 1, maxDepth, cache));

        // Deep copy of extra
        ((NutrientRealmProxyInterface) standaloneObject).realmSet$extra(ExtraRealmProxy.createDetachedCopy(((NutrientRealmProxyInterface) realmObject).realmGet$extra(), currentDepth + 1, maxDepth, cache));
        return standaloneObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Nutrient = [");
        stringBuilder.append("{important:");
        stringBuilder.append(realmGet$important() != null ? "Important" : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{extra:");
        stringBuilder.append(realmGet$extra() != null ? "Extra" : "null");
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
        NutrientRealmProxy aNutrient = (NutrientRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aNutrient.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aNutrient.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aNutrient.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
