package com.example.android.restful.Utilities;

import android.util.Log;

import com.example.android.restful.MainActivity;
import com.example.android.restful.model.DataItem;
import com.example.android.restful.model.DataItemFields;
import com.example.android.restful.observer.RealmExecuteDone;

import java.util.Arrays;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

import static com.example.android.restful.model.DataItemFields.ITEM_NAME;

/**
 * Created by hp on 1/10/2018.
 */

public class RealmProcessor {
    private static final String TAG = RealmProcessor.class.getSimpleName();
    private boolean deleted = false;
    private Realm realm;
    private RealmExecuteDone realmExecuteDone;


    private RealmProcessor() {
    }

    public RealmProcessor(MainActivity mainActivity) {
        realmExecuteDone = mainActivity;
    }

    public void open() {
        // initialize realm
        realm = Realm.getDefaultInstance();
    }

    public void close() {
        if (!realm.isClosed()) realm.close();

    }

    public boolean createDataItemAllAsync(final DataItem[] dataItems) {
        final List<DataItem> dataItemList = Arrays.asList(dataItems);
        if (!realm.isClosed()) {
            realm.executeTransactionAsync(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    realm.insert(dataItemList);
                }
            }, new Realm.Transaction.OnSuccess() {
                @Override
                public void onSuccess() {
                    realmExecuteDone.insertionDone();
                }
            });
        }
        Log.i(TAG, "data inserted into the realm.");
        return true;
    }

    public void createSingleDataItem(final DataItem dataItem) {

    }

    public boolean realmIsEmpty() {
        return realm.isEmpty();
    }

    public RealmResults<DataItem> getData(int maxPrice) {
        String array[] = {"apple pie"};
        return realm.where(DataItem.class)
                .isNotNull(ITEM_NAME)
//                .in(ITEM_NAME,array,Case.INSENSITIVE)
                .lessThanOrEqualTo(DataItemFields.PRICE, Double.valueOf(maxPrice))
                .findAll();

    }

    public boolean deleteRealmObject() {
        deleted = false;
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.where(DataItem.class).findAll().deleteAllFromRealm();
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                deleted = true;
            }
        });
        return deleted;
    }
}
