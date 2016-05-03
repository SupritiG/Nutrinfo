package io.realm;


import android.util.JsonReader;
import android.util.JsonToken;
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

public class NutrientUnitRealmProxy extends NutrientUnit
    implements RealmObjectProxy, NutrientUnitRealmProxyInterface {

    static final class NutrientUnitColumnInfo extends ColumnInfo {

        public final long valueIndex;

        NutrientUnitColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(1);
            this.valueIndex = getValidColumnIndex(path, table, "NutrientUnit", "value");
            indicesMap.put("value", this.valueIndex);

            setIndicesMap(indicesMap);
        }
    }

    private final NutrientUnitColumnInfo columnInfo;
    private final ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("value");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    NutrientUnitRealmProxy(ColumnInfo columnInfo) {
        this.columnInfo = (NutrientUnitColumnInfo) columnInfo;
        this.proxyState = new ProxyState(NutrientUnit.class);
    }

    @SuppressWarnings("cast")
    public Float realmGet$value() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.valueIndex)) {
            return null;
        }
        return (float) proxyState.getRow$realm().getFloat(columnInfo.valueIndex);
    }

    public void realmSet$value(Float value) {
        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.valueIndex);
            return;
        }
        proxyState.getRow$realm().setFloat(columnInfo.valueIndex, value);
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if (!transaction.hasTable("class_NutrientUnit")) {
            Table table = transaction.getTable("class_NutrientUnit");
            table.addColumn(RealmFieldType.FLOAT, "value", Table.NULLABLE);
            table.setPrimaryKey("");
            return table;
        }
        return transaction.getTable("class_NutrientUnit");
    }

    public static NutrientUnitColumnInfo validateTable(ImplicitTransaction transaction) {
        if (transaction.hasTable("class_NutrientUnit")) {
            Table table = transaction.getTable("class_NutrientUnit");
            if (table.getColumnCount() != 1) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field count does not match - expected 1 but was " + table.getColumnCount());
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < 1; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final NutrientUnitColumnInfo columnInfo = new NutrientUnitColumnInfo(transaction.getPath(), table);

            if (!columnTypes.containsKey("value")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'value' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("value") != RealmFieldType.FLOAT) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'Float' for field 'value' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.valueIndex)) {
                throw new RealmMigrationNeededException(transaction.getPath(),"Field 'value' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'value' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(transaction.getPath(), "The NutrientUnit class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_NutrientUnit";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static NutrientUnit createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        NutrientUnit obj = realm.createObject(NutrientUnit.class);
        if (json.has("value")) {
            if (json.isNull("value")) {
                ((NutrientUnitRealmProxyInterface) obj).realmSet$value(null);
            } else {
                ((NutrientUnitRealmProxyInterface) obj).realmSet$value((float) json.getDouble("value"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    public static NutrientUnit createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        NutrientUnit obj = realm.createObject(NutrientUnit.class);
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("value")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((NutrientUnitRealmProxyInterface) obj).realmSet$value(null);
                } else {
                    ((NutrientUnitRealmProxyInterface) obj).realmSet$value((float) reader.nextDouble());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return obj;
    }

    public static NutrientUnit copyOrUpdate(Realm realm, NutrientUnit object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        return copy(realm, object, update, cache);
    }

    public static NutrientUnit copy(Realm realm, NutrientUnit newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        NutrientUnit realmObject = realm.createObject(NutrientUnit.class);
        cache.put(newObject, (RealmObjectProxy) realmObject);
        ((NutrientUnitRealmProxyInterface) realmObject).realmSet$value(((NutrientUnitRealmProxyInterface) newObject).realmGet$value());
        return realmObject;
    }

    public static NutrientUnit createDetachedCopy(NutrientUnit realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        NutrientUnit standaloneObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (NutrientUnit)cachedObject.object;
            } else {
                standaloneObject = (NutrientUnit)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            standaloneObject = new NutrientUnit();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, standaloneObject));
        }
        ((NutrientUnitRealmProxyInterface) standaloneObject).realmSet$value(((NutrientUnitRealmProxyInterface) realmObject).realmGet$value());
        return standaloneObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("NutrientUnit = [");
        stringBuilder.append("{value:");
        stringBuilder.append(realmGet$value() != null ? realmGet$value() : "null");
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
        NutrientUnitRealmProxy aNutrientUnit = (NutrientUnitRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aNutrientUnit.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aNutrientUnit.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aNutrientUnit.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
