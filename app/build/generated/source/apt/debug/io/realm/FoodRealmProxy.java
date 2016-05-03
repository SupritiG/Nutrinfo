package io.realm;


import android.util.JsonReader;
import android.util.JsonToken;
import com.example.sgupta.nutrinfo.Food;
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

public class FoodRealmProxy extends Food
    implements RealmObjectProxy, FoodRealmProxyInterface {

    static final class FoodColumnInfo extends ColumnInfo {

        public final long _idIndex;
        public final long nameIndex;
        public final long sourceIndex;
        public final long portionsIndex;

        FoodColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(4);
            this._idIndex = getValidColumnIndex(path, table, "Food", "_id");
            indicesMap.put("_id", this._idIndex);

            this.nameIndex = getValidColumnIndex(path, table, "Food", "name");
            indicesMap.put("name", this.nameIndex);

            this.sourceIndex = getValidColumnIndex(path, table, "Food", "source");
            indicesMap.put("source", this.sourceIndex);

            this.portionsIndex = getValidColumnIndex(path, table, "Food", "portions");
            indicesMap.put("portions", this.portionsIndex);

            setIndicesMap(indicesMap);
        }
    }

    private final FoodColumnInfo columnInfo;
    private final ProxyState proxyState;
    private RealmList<Portion> portionsRealmList;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("_id");
        fieldNames.add("name");
        fieldNames.add("source");
        fieldNames.add("portions");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    FoodRealmProxy(ColumnInfo columnInfo) {
        this.columnInfo = (FoodColumnInfo) columnInfo;
        this.proxyState = new ProxyState(Food.class);
    }

    @SuppressWarnings("cast")
    public String realmGet$_id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo._idIndex);
    }

    public void realmSet$_id(String value) {
        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo._idIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo._idIndex, value);
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

    @SuppressWarnings("cast")
    public String realmGet$source() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sourceIndex);
    }

    public void realmSet$source(String value) {
        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sourceIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sourceIndex, value);
    }

    public RealmList<Portion> realmGet$portions() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (portionsRealmList != null) {
            return portionsRealmList;
        } else {
            LinkView linkView = proxyState.getRow$realm().getLinkList(columnInfo.portionsIndex);
            portionsRealmList = new RealmList<Portion>(Portion.class, linkView, proxyState.getRealm$realm());
            return portionsRealmList;
        }
    }

    public void realmSet$portions(RealmList<Portion> value) {
        proxyState.getRealm$realm().checkIfValid();
        LinkView links = proxyState.getRow$realm().getLinkList(columnInfo.portionsIndex);
        links.clear();
        if (value == null) {
            return;
        }
        for (RealmModel linkedObject : (RealmList<? extends RealmModel>) value) {
            if (!RealmObject.isValid(linkedObject)) {
                throw new IllegalArgumentException("Each element of 'value' must be a valid managed object.");
            }
            if (((RealmObjectProxy)linkedObject).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
                throw new IllegalArgumentException("Each element of 'value' must belong to the same Realm.");
            }
            links.add(((RealmObjectProxy)linkedObject).realmGet$proxyState().getRow$realm().getIndex());
        }
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if (!transaction.hasTable("class_Food")) {
            Table table = transaction.getTable("class_Food");
            table.addColumn(RealmFieldType.STRING, "_id", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "name", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "source", Table.NULLABLE);
            if (!transaction.hasTable("class_Portion")) {
                PortionRealmProxy.initTable(transaction);
            }
            table.addColumnLink(RealmFieldType.LIST, "portions", transaction.getTable("class_Portion"));
            table.addSearchIndex(table.getColumnIndex("_id"));
            table.setPrimaryKey("_id");
            return table;
        }
        return transaction.getTable("class_Food");
    }

    public static FoodColumnInfo validateTable(ImplicitTransaction transaction) {
        if (transaction.hasTable("class_Food")) {
            Table table = transaction.getTable("class_Food");
            if (table.getColumnCount() != 4) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field count does not match - expected 4 but was " + table.getColumnCount());
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < 4; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final FoodColumnInfo columnInfo = new FoodColumnInfo(transaction.getPath(), table);

            if (!columnTypes.containsKey("_id")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field '_id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("_id") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field '_id' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo._idIndex)) {
                throw new RealmMigrationNeededException(transaction.getPath(),"@PrimaryKey field '_id' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("_id")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Primary key not defined for field '_id' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("_id"))) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Index not defined for field '_id' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("name")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'name' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("name") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'name' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.nameIndex)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field 'name' is required. Either set @Required to field 'name' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("source")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'source' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("source") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'source' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.sourceIndex)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field 'source' is required. Either set @Required to field 'source' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("portions")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'portions'");
            }
            if (columnTypes.get("portions") != RealmFieldType.LIST) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'Portion' for field 'portions'");
            }
            if (!transaction.hasTable("class_Portion")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing class 'class_Portion' for field 'portions'");
            }
            Table table_3 = transaction.getTable("class_Portion");
            if (!table.getLinkTarget(columnInfo.portionsIndex).hasSameSchema(table_3)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid RealmList type for field 'portions': '" + table.getLinkTarget(columnInfo.portionsIndex).getName() + "' expected - was '" + table_3.getName() + "'");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(transaction.getPath(), "The Food class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_Food";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static Food createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        Food obj = null;
        if (update) {
            Table table = realm.getTable(Food.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (json.isNull("_id")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("_id"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                obj = new FoodRealmProxy(realm.schema.getColumnInfo(Food.class));
                ((RealmObjectProxy)obj).realmGet$proxyState().setRealm$realm(realm);
                ((RealmObjectProxy)obj).realmGet$proxyState().setRow$realm(table.getUncheckedRow(rowIndex));
            }
        }
        if (obj == null) {
            if (json.has("_id")) {
                if (json.isNull("_id")) {
                    obj = (FoodRealmProxy) realm.createObject(Food.class, null);
                } else {
                    obj = (FoodRealmProxy) realm.createObject(Food.class, json.getString("_id"));
                }
            } else {
                obj = (FoodRealmProxy) realm.createObject(Food.class);
            }
        }
        if (json.has("_id")) {
            if (json.isNull("_id")) {
                ((FoodRealmProxyInterface) obj).realmSet$_id(null);
            } else {
                ((FoodRealmProxyInterface) obj).realmSet$_id((String) json.getString("_id"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                ((FoodRealmProxyInterface) obj).realmSet$name(null);
            } else {
                ((FoodRealmProxyInterface) obj).realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("source")) {
            if (json.isNull("source")) {
                ((FoodRealmProxyInterface) obj).realmSet$source(null);
            } else {
                ((FoodRealmProxyInterface) obj).realmSet$source((String) json.getString("source"));
            }
        }
        if (json.has("portions")) {
            if (json.isNull("portions")) {
                ((FoodRealmProxyInterface) obj).realmSet$portions(null);
            } else {
                ((FoodRealmProxyInterface) obj).realmGet$portions().clear();
                JSONArray array = json.getJSONArray("portions");
                for (int i = 0; i < array.length(); i++) {
                    com.example.sgupta.nutrinfo.Portion item = PortionRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    ((FoodRealmProxyInterface) obj).realmGet$portions().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    public static Food createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        Food obj = realm.createObject(Food.class);
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("_id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((FoodRealmProxyInterface) obj).realmSet$_id(null);
                } else {
                    ((FoodRealmProxyInterface) obj).realmSet$_id((String) reader.nextString());
                }
            } else if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((FoodRealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((FoodRealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
            } else if (name.equals("source")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((FoodRealmProxyInterface) obj).realmSet$source(null);
                } else {
                    ((FoodRealmProxyInterface) obj).realmSet$source((String) reader.nextString());
                }
            } else if (name.equals("portions")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((FoodRealmProxyInterface) obj).realmSet$portions(null);
                } else {
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.example.sgupta.nutrinfo.Portion item = PortionRealmProxy.createUsingJsonStream(realm, reader);
                        ((FoodRealmProxyInterface) obj).realmGet$portions().add(item);
                    }
                    reader.endArray();
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return obj;
    }

    public static Food copyOrUpdate(Realm realm, Food object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        Food realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(Food.class);
            long pkColumnIndex = table.getPrimaryKey();
            String value = ((FoodRealmProxyInterface) object).realmGet$_id();
            long rowIndex = TableOrView.NO_MATCH;
            if (value == null) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, value);
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                realmObject = new FoodRealmProxy(realm.schema.getColumnInfo(Food.class));
                ((RealmObjectProxy)realmObject).realmGet$proxyState().setRealm$realm(realm);
                ((RealmObjectProxy)realmObject).realmGet$proxyState().setRow$realm(table.getUncheckedRow(rowIndex));
                cache.put(object, (RealmObjectProxy) realmObject);
            } else {
                canUpdate = false;
            }
        }

        if (canUpdate) {
            return update(realm, realmObject, object, cache);
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static Food copy(Realm realm, Food newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        Food realmObject = realm.createObject(Food.class, ((FoodRealmProxyInterface) newObject).realmGet$_id());
        cache.put(newObject, (RealmObjectProxy) realmObject);
        ((FoodRealmProxyInterface) realmObject).realmSet$_id(((FoodRealmProxyInterface) newObject).realmGet$_id());
        ((FoodRealmProxyInterface) realmObject).realmSet$name(((FoodRealmProxyInterface) newObject).realmGet$name());
        ((FoodRealmProxyInterface) realmObject).realmSet$source(((FoodRealmProxyInterface) newObject).realmGet$source());

        RealmList<Portion> portionsList = ((FoodRealmProxyInterface) newObject).realmGet$portions();
        if (portionsList != null) {
            RealmList<Portion> portionsRealmList = ((FoodRealmProxyInterface) realmObject).realmGet$portions();
            for (int i = 0; i < portionsList.size(); i++) {
                Portion portionsItem = portionsList.get(i);
                Portion cacheportions = (Portion) cache.get(portionsItem);
                if (cacheportions != null) {
                    portionsRealmList.add(cacheportions);
                } else {
                    portionsRealmList.add(PortionRealmProxy.copyOrUpdate(realm, portionsList.get(i), update, cache));
                }
            }
        }

        return realmObject;
    }

    public static Food createDetachedCopy(Food realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        Food standaloneObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (Food)cachedObject.object;
            } else {
                standaloneObject = (Food)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            standaloneObject = new Food();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, standaloneObject));
        }
        ((FoodRealmProxyInterface) standaloneObject).realmSet$_id(((FoodRealmProxyInterface) realmObject).realmGet$_id());
        ((FoodRealmProxyInterface) standaloneObject).realmSet$name(((FoodRealmProxyInterface) realmObject).realmGet$name());
        ((FoodRealmProxyInterface) standaloneObject).realmSet$source(((FoodRealmProxyInterface) realmObject).realmGet$source());

        // Deep copy of portions
        if (currentDepth == maxDepth) {
            ((FoodRealmProxyInterface) standaloneObject).realmSet$portions(null);
        } else {
            RealmList<Portion> managedportionsList = ((FoodRealmProxyInterface) realmObject).realmGet$portions();
            RealmList<Portion> standaloneportionsList = new RealmList<Portion>();
            ((FoodRealmProxyInterface) standaloneObject).realmSet$portions(standaloneportionsList);
            int nextDepth = currentDepth + 1;
            int size = managedportionsList.size();
            for (int i = 0; i < size; i++) {
                Portion item = PortionRealmProxy.createDetachedCopy(managedportionsList.get(i), nextDepth, maxDepth, cache);
                standaloneportionsList.add(item);
            }
        }
        return standaloneObject;
    }

    static Food update(Realm realm, Food realmObject, Food newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((FoodRealmProxyInterface) realmObject).realmSet$name(((FoodRealmProxyInterface) newObject).realmGet$name());
        ((FoodRealmProxyInterface) realmObject).realmSet$source(((FoodRealmProxyInterface) newObject).realmGet$source());
        RealmList<Portion> portionsList = ((FoodRealmProxyInterface) newObject).realmGet$portions();
        RealmList<Portion> portionsRealmList = ((FoodRealmProxyInterface) realmObject).realmGet$portions();
        portionsRealmList.clear();
        if (portionsList != null) {
            for (int i = 0; i < portionsList.size(); i++) {
                Portion portionsItem = portionsList.get(i);
                Portion cacheportions = (Portion) cache.get(portionsItem);
                if (cacheportions != null) {
                    portionsRealmList.add(cacheportions);
                } else {
                    portionsRealmList.add(PortionRealmProxy.copyOrUpdate(realm, portionsList.get(i), true, cache));
                }
            }
        }
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Food = [");
        stringBuilder.append("{_id:");
        stringBuilder.append(realmGet$_id() != null ? realmGet$_id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{source:");
        stringBuilder.append(realmGet$source() != null ? realmGet$source() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{portions:");
        stringBuilder.append("RealmList<Portion>[").append(realmGet$portions().size()).append("]");
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
        FoodRealmProxy aFood = (FoodRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aFood.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aFood.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aFood.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
