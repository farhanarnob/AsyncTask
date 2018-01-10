package com.example.android.restful;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by hp on 1/9/2018.
 */

public class RealmInitializationApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);

        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name("saving_zone.realm")
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.deleteRealm(configuration);
        Realm.setDefaultConfiguration(configuration);
    }
}
