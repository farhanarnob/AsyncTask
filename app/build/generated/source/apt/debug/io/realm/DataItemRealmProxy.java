package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class DataItemRealmProxy extends com.example.android.restful.model.DataItem
    implements RealmObjectProxy, DataItemRealmProxyInterface {

    static final class DataItemColumnInfo extends ColumnInfo {
        long idIndex;
        long itemNameIndex;
        long categoryIndex;
        long descriptionIndex;
        long sortIndex;
        long priceIndex;
        long imageIndex;
        long starStatusIndex;

        DataItemColumnInfo(OsSchemaInfo schemaInfo) {
            super(8);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("DataItem");
            this.idIndex = addColumnDetails("id", objectSchemaInfo);
            this.itemNameIndex = addColumnDetails("itemName", objectSchemaInfo);
            this.categoryIndex = addColumnDetails("category", objectSchemaInfo);
            this.descriptionIndex = addColumnDetails("description", objectSchemaInfo);
            this.sortIndex = addColumnDetails("sort", objectSchemaInfo);
            this.priceIndex = addColumnDetails("price", objectSchemaInfo);
            this.imageIndex = addColumnDetails("image", objectSchemaInfo);
            this.starStatusIndex = addColumnDetails("starStatus", objectSchemaInfo);
        }

        DataItemColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new DataItemColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final DataItemColumnInfo src = (DataItemColumnInfo) rawSrc;
            final DataItemColumnInfo dst = (DataItemColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.itemNameIndex = src.itemNameIndex;
            dst.categoryIndex = src.categoryIndex;
            dst.descriptionIndex = src.descriptionIndex;
            dst.sortIndex = src.sortIndex;
            dst.priceIndex = src.priceIndex;
            dst.imageIndex = src.imageIndex;
            dst.starStatusIndex = src.starStatusIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(8);
        fieldNames.add("id");
        fieldNames.add("itemName");
        fieldNames.add("category");
        fieldNames.add("description");
        fieldNames.add("sort");
        fieldNames.add("price");
        fieldNames.add("image");
        fieldNames.add("starStatus");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private DataItemColumnInfo columnInfo;
    private ProxyState<com.example.android.restful.model.DataItem> proxyState;

    DataItemRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (DataItemColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.android.restful.model.DataItem>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.idIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.idIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.idIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$itemName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.itemNameIndex);
    }

    @Override
    public void realmSet$itemName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.itemNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.itemNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.itemNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.itemNameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$category() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.categoryIndex);
    }

    @Override
    public void realmSet$category(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.categoryIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.categoryIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.categoryIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.categoryIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$description() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.descriptionIndex);
    }

    @Override
    public void realmSet$description(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.descriptionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.descriptionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.descriptionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.descriptionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$sort() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.sortIndex);
    }

    @Override
    public void realmSet$sort(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.sortIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.sortIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$price() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.priceIndex);
    }

    @Override
    public void realmSet$price(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.priceIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.priceIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$image() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.imageIndex);
    }

    @Override
    public void realmSet$image(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.imageIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.imageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.imageIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.imageIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$starStatus() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.starStatusIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.starStatusIndex);
    }

    @Override
    public void realmSet$starStatus(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.starStatusIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.starStatusIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.starStatusIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.starStatusIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("DataItem", 8, 0);
        builder.addPersistedProperty("id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("itemName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("category", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("description", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sort", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("price", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("image", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("starStatus", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static DataItemColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new DataItemColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "DataItem";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.example.android.restful.model.DataItem createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.android.restful.model.DataItem obj = realm.createObjectInternal(com.example.android.restful.model.DataItem.class, true, excludeFields);

        final DataItemRealmProxyInterface objProxy = (DataItemRealmProxyInterface) obj;
        if (json.has("id")) {
            if (json.isNull("id")) {
                objProxy.realmSet$id(null);
            } else {
                objProxy.realmSet$id((String) json.getString("id"));
            }
        }
        if (json.has("itemName")) {
            if (json.isNull("itemName")) {
                objProxy.realmSet$itemName(null);
            } else {
                objProxy.realmSet$itemName((String) json.getString("itemName"));
            }
        }
        if (json.has("category")) {
            if (json.isNull("category")) {
                objProxy.realmSet$category(null);
            } else {
                objProxy.realmSet$category((String) json.getString("category"));
            }
        }
        if (json.has("description")) {
            if (json.isNull("description")) {
                objProxy.realmSet$description(null);
            } else {
                objProxy.realmSet$description((String) json.getString("description"));
            }
        }
        if (json.has("sort")) {
            if (json.isNull("sort")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'sort' to null.");
            } else {
                objProxy.realmSet$sort((int) json.getInt("sort"));
            }
        }
        if (json.has("price")) {
            if (json.isNull("price")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'price' to null.");
            } else {
                objProxy.realmSet$price((double) json.getDouble("price"));
            }
        }
        if (json.has("image")) {
            if (json.isNull("image")) {
                objProxy.realmSet$image(null);
            } else {
                objProxy.realmSet$image((String) json.getString("image"));
            }
        }
        if (json.has("starStatus")) {
            if (json.isNull("starStatus")) {
                objProxy.realmSet$starStatus(null);
            } else {
                objProxy.realmSet$starStatus((int) json.getInt("starStatus"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.android.restful.model.DataItem createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.example.android.restful.model.DataItem obj = new com.example.android.restful.model.DataItem();
        final DataItemRealmProxyInterface objProxy = (DataItemRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$id(null);
                }
            } else if (name.equals("itemName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$itemName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$itemName(null);
                }
            } else if (name.equals("category")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$category((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$category(null);
                }
            } else if (name.equals("description")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$description((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$description(null);
                }
            } else if (name.equals("sort")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sort((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'sort' to null.");
                }
            } else if (name.equals("price")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$price((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'price' to null.");
                }
            } else if (name.equals("image")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$image((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$image(null);
                }
            } else if (name.equals("starStatus")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$starStatus((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$starStatus(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static com.example.android.restful.model.DataItem copyOrUpdate(Realm realm, com.example.android.restful.model.DataItem object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.example.android.restful.model.DataItem) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static com.example.android.restful.model.DataItem copy(Realm realm, com.example.android.restful.model.DataItem newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.android.restful.model.DataItem) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.example.android.restful.model.DataItem realmObject = realm.createObjectInternal(com.example.android.restful.model.DataItem.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        DataItemRealmProxyInterface realmObjectSource = (DataItemRealmProxyInterface) newObject;
        DataItemRealmProxyInterface realmObjectCopy = (DataItemRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$id(realmObjectSource.realmGet$id());
        realmObjectCopy.realmSet$itemName(realmObjectSource.realmGet$itemName());
        realmObjectCopy.realmSet$category(realmObjectSource.realmGet$category());
        realmObjectCopy.realmSet$description(realmObjectSource.realmGet$description());
        realmObjectCopy.realmSet$sort(realmObjectSource.realmGet$sort());
        realmObjectCopy.realmSet$price(realmObjectSource.realmGet$price());
        realmObjectCopy.realmSet$image(realmObjectSource.realmGet$image());
        realmObjectCopy.realmSet$starStatus(realmObjectSource.realmGet$starStatus());
        return realmObject;
    }

    public static long insert(Realm realm, com.example.android.restful.model.DataItem object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.android.restful.model.DataItem.class);
        long tableNativePtr = table.getNativePtr();
        DataItemColumnInfo columnInfo = (DataItemColumnInfo) realm.getSchema().getColumnInfo(com.example.android.restful.model.DataItem.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$id = ((DataItemRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
        }
        String realmGet$itemName = ((DataItemRealmProxyInterface) object).realmGet$itemName();
        if (realmGet$itemName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.itemNameIndex, rowIndex, realmGet$itemName, false);
        }
        String realmGet$category = ((DataItemRealmProxyInterface) object).realmGet$category();
        if (realmGet$category != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.categoryIndex, rowIndex, realmGet$category, false);
        }
        String realmGet$description = ((DataItemRealmProxyInterface) object).realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.sortIndex, rowIndex, ((DataItemRealmProxyInterface) object).realmGet$sort(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.priceIndex, rowIndex, ((DataItemRealmProxyInterface) object).realmGet$price(), false);
        String realmGet$image = ((DataItemRealmProxyInterface) object).realmGet$image();
        if (realmGet$image != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.imageIndex, rowIndex, realmGet$image, false);
        }
        Number realmGet$starStatus = ((DataItemRealmProxyInterface) object).realmGet$starStatus();
        if (realmGet$starStatus != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.starStatusIndex, rowIndex, realmGet$starStatus.longValue(), false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.android.restful.model.DataItem.class);
        long tableNativePtr = table.getNativePtr();
        DataItemColumnInfo columnInfo = (DataItemColumnInfo) realm.getSchema().getColumnInfo(com.example.android.restful.model.DataItem.class);
        com.example.android.restful.model.DataItem object = null;
        while (objects.hasNext()) {
            object = (com.example.android.restful.model.DataItem) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$id = ((DataItemRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
            }
            String realmGet$itemName = ((DataItemRealmProxyInterface) object).realmGet$itemName();
            if (realmGet$itemName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.itemNameIndex, rowIndex, realmGet$itemName, false);
            }
            String realmGet$category = ((DataItemRealmProxyInterface) object).realmGet$category();
            if (realmGet$category != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.categoryIndex, rowIndex, realmGet$category, false);
            }
            String realmGet$description = ((DataItemRealmProxyInterface) object).realmGet$description();
            if (realmGet$description != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.sortIndex, rowIndex, ((DataItemRealmProxyInterface) object).realmGet$sort(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.priceIndex, rowIndex, ((DataItemRealmProxyInterface) object).realmGet$price(), false);
            String realmGet$image = ((DataItemRealmProxyInterface) object).realmGet$image();
            if (realmGet$image != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.imageIndex, rowIndex, realmGet$image, false);
            }
            Number realmGet$starStatus = ((DataItemRealmProxyInterface) object).realmGet$starStatus();
            if (realmGet$starStatus != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.starStatusIndex, rowIndex, realmGet$starStatus.longValue(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.android.restful.model.DataItem object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.android.restful.model.DataItem.class);
        long tableNativePtr = table.getNativePtr();
        DataItemColumnInfo columnInfo = (DataItemColumnInfo) realm.getSchema().getColumnInfo(com.example.android.restful.model.DataItem.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$id = ((DataItemRealmProxyInterface) object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
        }
        String realmGet$itemName = ((DataItemRealmProxyInterface) object).realmGet$itemName();
        if (realmGet$itemName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.itemNameIndex, rowIndex, realmGet$itemName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.itemNameIndex, rowIndex, false);
        }
        String realmGet$category = ((DataItemRealmProxyInterface) object).realmGet$category();
        if (realmGet$category != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.categoryIndex, rowIndex, realmGet$category, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.categoryIndex, rowIndex, false);
        }
        String realmGet$description = ((DataItemRealmProxyInterface) object).realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.descriptionIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.sortIndex, rowIndex, ((DataItemRealmProxyInterface) object).realmGet$sort(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.priceIndex, rowIndex, ((DataItemRealmProxyInterface) object).realmGet$price(), false);
        String realmGet$image = ((DataItemRealmProxyInterface) object).realmGet$image();
        if (realmGet$image != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.imageIndex, rowIndex, realmGet$image, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.imageIndex, rowIndex, false);
        }
        Number realmGet$starStatus = ((DataItemRealmProxyInterface) object).realmGet$starStatus();
        if (realmGet$starStatus != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.starStatusIndex, rowIndex, realmGet$starStatus.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.starStatusIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.android.restful.model.DataItem.class);
        long tableNativePtr = table.getNativePtr();
        DataItemColumnInfo columnInfo = (DataItemColumnInfo) realm.getSchema().getColumnInfo(com.example.android.restful.model.DataItem.class);
        com.example.android.restful.model.DataItem object = null;
        while (objects.hasNext()) {
            object = (com.example.android.restful.model.DataItem) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$id = ((DataItemRealmProxyInterface) object).realmGet$id();
            if (realmGet$id != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
            }
            String realmGet$itemName = ((DataItemRealmProxyInterface) object).realmGet$itemName();
            if (realmGet$itemName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.itemNameIndex, rowIndex, realmGet$itemName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.itemNameIndex, rowIndex, false);
            }
            String realmGet$category = ((DataItemRealmProxyInterface) object).realmGet$category();
            if (realmGet$category != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.categoryIndex, rowIndex, realmGet$category, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.categoryIndex, rowIndex, false);
            }
            String realmGet$description = ((DataItemRealmProxyInterface) object).realmGet$description();
            if (realmGet$description != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descriptionIndex, rowIndex, realmGet$description, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.descriptionIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.sortIndex, rowIndex, ((DataItemRealmProxyInterface) object).realmGet$sort(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.priceIndex, rowIndex, ((DataItemRealmProxyInterface) object).realmGet$price(), false);
            String realmGet$image = ((DataItemRealmProxyInterface) object).realmGet$image();
            if (realmGet$image != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.imageIndex, rowIndex, realmGet$image, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.imageIndex, rowIndex, false);
            }
            Number realmGet$starStatus = ((DataItemRealmProxyInterface) object).realmGet$starStatus();
            if (realmGet$starStatus != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.starStatusIndex, rowIndex, realmGet$starStatus.longValue(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.starStatusIndex, rowIndex, false);
            }
        }
    }

    public static com.example.android.restful.model.DataItem createDetachedCopy(com.example.android.restful.model.DataItem realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.android.restful.model.DataItem unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.example.android.restful.model.DataItem();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.android.restful.model.DataItem) cachedObject.object;
            }
            unmanagedObject = (com.example.android.restful.model.DataItem) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        DataItemRealmProxyInterface unmanagedCopy = (DataItemRealmProxyInterface) unmanagedObject;
        DataItemRealmProxyInterface realmSource = (DataItemRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$itemName(realmSource.realmGet$itemName());
        unmanagedCopy.realmSet$category(realmSource.realmGet$category());
        unmanagedCopy.realmSet$description(realmSource.realmGet$description());
        unmanagedCopy.realmSet$sort(realmSource.realmGet$sort());
        unmanagedCopy.realmSet$price(realmSource.realmGet$price());
        unmanagedCopy.realmSet$image(realmSource.realmGet$image());
        unmanagedCopy.realmSet$starStatus(realmSource.realmGet$starStatus());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("DataItem = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{itemName:");
        stringBuilder.append(realmGet$itemName() != null ? realmGet$itemName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{category:");
        stringBuilder.append(realmGet$category() != null ? realmGet$category() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{description:");
        stringBuilder.append(realmGet$description() != null ? realmGet$description() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sort:");
        stringBuilder.append(realmGet$sort());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{price:");
        stringBuilder.append(realmGet$price());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{image:");
        stringBuilder.append(realmGet$image() != null ? realmGet$image() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{starStatus:");
        stringBuilder.append(realmGet$starStatus() != null ? realmGet$starStatus() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
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
        DataItemRealmProxy aDataItem = (DataItemRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aDataItem.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aDataItem.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aDataItem.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
