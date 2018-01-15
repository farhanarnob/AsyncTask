package com.example.android.restful.services;

import android.util.Log;

import com.example.android.restful.DetailsViewActivity;
import com.example.android.restful.MainActivity;
import com.example.android.restful.model.DataItem;
import com.example.android.restful.model.DataItemFields;
import com.example.android.restful.observer.RealmExecuteDone;

import java.util.Arrays;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

import static com.example.android.restful.model.DataItemFields.ITEM_NAME;
import static com.example.android.restful.model.WorkType.INSERT;

/**
 * Created by hp on 1/10/2018.
 */

public class RealmProcessor {
    private static final String TAG = RealmProcessor.class.getSimpleName();
    private boolean deleted = false;
    private Realm realm;
    private RealmExecuteDone realmExecuteDone;


    public RealmProcessor(DetailsViewActivity detailsViewActivity) {
        realmExecuteDone = detailsViewActivity;
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
                    realmExecuteDone.ProgressDone(INSERT);
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
        return realm.where(DataItem.class)
                .isNotNull(ITEM_NAME)
                .lessThanOrEqualTo(DataItemFields.PRICE, Double.valueOf(maxPrice))
                .findAll();

    }

    public DataItem getData(String id) {
        return realm.where(DataItem.class)
                .contains(DataItemFields.ID, id).findFirst();

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

    public DataItem updateDescription(String idOfData, final String description) {
        if(realm==null)
            realm=Realm.getDefaultInstance();
        final DataItem dataItem = realm.where(DataItem.class).equalTo(DataItemFields.ID, idOfData).findFirst();
        Log.i(TAG,dataItem.getId());

//        process 1
//        realm.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                dataItem.setDescription(description);
//            }
//        });
//        realmExecuteDone.ProgressDone(UPDATE);

//        process 2
//        Replaced with realm.execute
//        realm.beginTransaction();
//        dataItem.setDescription(description);
//        realm.commitTransaction();
//
//        process 3
//        Another process
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                dataItem.setDescription("Never thought that it is always sweets");
            }
        });

        return dataItem;
    }
}

