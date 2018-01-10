package com.example.android.restful.Utilities;

import android.util.Log;

import com.example.android.restful.model.DataItem;

import java.util.Arrays;
import java.util.List;

import io.realm.Realm;

/**
 * Created by hp on 1/10/2018.
 */

public class RealmProcessor {
    private static final String TAG = RealmProcessor.class.getSimpleName();
    private Realm realm;

    public void open() {
        // initialize realm
        realm = Realm.getDefaultInstance();
    }

    public void close() {
        if (!realm.isClosed()) realm.close();

    }

    public void createDataItemAllAsync(final DataItem[] dataItems) {
        final List<DataItem> dataItemList = Arrays.asList(dataItems);
        if (!realm.isClosed()) {
            realm.executeTransactionAsync(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    realm.insert(dataItemList);
                }
            });
        }
        Log.i(TAG, "data inserted into the realm.");

    }

    public void createSingleDataItem(final DataItem dataItem) {

    }
}
