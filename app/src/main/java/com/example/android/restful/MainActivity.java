package com.example.android.restful;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.android.restful.Utilities.NetworkHelper;
import com.example.android.restful.model.DataItem;
import com.example.android.restful.model.SingleData;
import com.example.android.restful.services.MyIntentService;

public class MainActivity extends AppCompatActivity {

    private static final String JSON_URL = "https://reqres.in/api/unknown";
    public TextView output;
    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            DataItem message = intent.getParcelableExtra(MyIntentService.My_SERVICE_PAYLOAD);
            SingleData[] singleData = message.getData().toArray(new SingleData[0]);
            for (SingleData data :
                    singleData) {
                output.append("\n" + data.getName() + " # " + data.getYear());
            }
        }
    };
    private boolean networkOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        output = (TextView) findViewById(R.id.output);

        networkOk = NetworkHelper.hasNetworkAccess(this);
        output.append("Network Okay: " + networkOk);

    }

    public void runClickHandler(View view) {
//        getSupportLoaderManager().initLoader(0, null, this).forceLoad();
        Intent intent = new Intent(this, MyIntentService.class);
        intent.setData(Uri.parse(JSON_URL));
//        One thread will be used.
        startService(intent);
        LocalBroadcastManager.getInstance(this)
                .registerReceiver(broadcastReceiver, new IntentFilter(MyIntentService.MY_SERVICE_MESSAGE));
    }

    public void clearClickHandler(View view) {
        output.setText("");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this)
                .unregisterReceiver(broadcastReceiver);
    }
}
