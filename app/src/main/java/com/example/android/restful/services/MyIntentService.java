package com.example.android.restful.services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.example.android.restful.model.DataItem;

import java.io.IOException;

import retrofit2.Call;

/**
 * Created by Arnob on 1/4/2018.
 * For learning IntentService
 */

public class MyIntentService extends IntentService {
    public static final String MY_SERVICE_MESSAGE = "MyServiceMessage";
    public static final String My_SERVICE_PAYLOAD = "MyServicePayload";
    public static final String REQUEST_PACKAGE = "requestPackage";
    private static final String TAG = MyIntentService.class.getSimpleName();

    public MyIntentService() {
        super("My Intent Service");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

//        Make the web service request
        MyWebService myWebService = MyWebService.retrofit.create(MyWebService.class);
        Call<DataItem[]> dataItemCall = myWebService.getData();


        DataItem[] dataItems;

        try {
            dataItems = dataItemCall.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
            Log.i(TAG, "onHandled Intent:" + e.getMessage());
            return;
        }


//        RequestPackage requestPackage = intent != null ? (RequestPackage) intent.getParcelableExtra(REQUEST_PACKAGE) : null;
//        String response;
//        try {
//            response = HttpHelper.downloadUrl(requestPackage);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return;
//        }
//
//        // gson
//        Gson gson = new Gson();
//        DataItem[] dataItem = gson.fromJson(response, DataItem[].class);
//
//        Log.i(TAG, dataItem.getClass().getSimpleName());
        Intent intent1 = new Intent(MY_SERVICE_MESSAGE);
        intent1.putExtra(My_SERVICE_PAYLOAD, dataItems);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent1);
    }

    @Override
    public void onCreate() {

        Log.i(TAG, "On Create");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "On Destroy");
        super.onDestroy();
    }
}
