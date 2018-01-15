package com.example.android.restful;

import com.example.android.restful.model.DataItemFields;

import io.realm.DynamicRealm;
import io.realm.DynamicRealmObject;
import io.realm.RealmMigration;
import io.realm.RealmObjectSchema;

/**
 * Created by hp on 1/15/2018.
 */

class MyMygration implements RealmMigration {
    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        if (oldVersion == 1) {
            RealmObjectSchema objectSchema = realm.getSchema()
                    .get("DataItem");
            objectSchema.addField(DataItemFields.STAR_STATUS, Integer.class)
                    .transform(new RealmObjectSchema.Function() {
                        @Override
                        public void apply(DynamicRealmObject obj) {
                            obj.set(DataItemFields.STAR_STATUS, 5);
                        }
                    });
        }
    }
}
