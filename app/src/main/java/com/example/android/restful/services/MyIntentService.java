package com.example.android.restful.services;

import android.app.IntentService;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

/**
 * Created by Arnob on 1/4/2018.
 * For learning IntentService
 */

public class MyIntentService extends IntentService {
    public static final String MY_SERVICE_MESSAGE = "MyServiceMessage";
    public static final String My_SERVICE_PAYLOAD = "MyServicePayload";
    private static final String TAG = MyIntentService.class.getSimpleName();

    public MyIntentService() {
        super("My Intent Service");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Uri uri = intent != null ? intent.getData() : null;
        Log.i(TAG, uri != null ? uri.toString() : null);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Intent intent1 = new Intent(MY_SERVICE_MESSAGE);
        intent1.putExtra(My_SERVICE_PAYLOAD, "Service all done.");
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
