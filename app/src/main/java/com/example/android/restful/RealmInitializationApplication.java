package com.example.android.restful;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by hp on 1/9/2018.
 */

public class RealmInitializationApplication extends Application {

    // Schema version was 1 previously. new version is 2.
    public static final int SCHEMA_VERSION = 2;

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);

        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name("saving_zone.realm")
                .schemaVersion(SCHEMA_VERSION)
                .migration(new MyMygration())
                .build();
        Realm.setDefaultConfiguration(configuration);
    }
}
