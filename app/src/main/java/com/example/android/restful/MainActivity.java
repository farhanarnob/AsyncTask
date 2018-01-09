package com.example.android.restful;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.restful.Utilities.NetworkHelper;
import com.example.android.restful.model.DataItem;
import com.example.android.restful.services.MyIntentService;
import com.example.android.restful.services.MyWebService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String JSON_URL = "http://560057.youcanlearnit.net/services/json/itemsfeed.php";

    public TextView output;
    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            DataItem[] dataItems = (DataItem[]) intent
                    .getParcelableArrayExtra(MyIntentService.My_SERVICE_PAYLOAD);
            for (DataItem data :
                    dataItems) {
                output.append("\n" + data.getItemName() + " # " + data.getPrice());
            }
        }
    };
    private boolean networkOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        output = (TextView) findViewById(R.id.output);


        LocalBroadcastManager.getInstance(getApplicationContext())
                .registerReceiver(broadcastReceiver,
                        new IntentFilter(MyIntentService.MY_SERVICE_MESSAGE));

        networkOk = NetworkHelper.hasNetworkAccess(this);
        output.append("Network Okay: " + networkOk);

    }

    public void runClickHandler(View view) {
        if (networkOk) {
//            requestData();
            requestData("Desserts");
//            RequestPackage requestPackage = new RequestPackage();
//
//            requestPackage.setEndPoint(JSON_URL);
//            requestPackage.setParam("category", "desserts");
//            requestPackage.setMethod("POST");
//
//            Intent intent = new Intent(this, MyIntentService.class);
//            intent.putExtra(REQUEST_PACKAGE, requestPackage);
//            startService(intent);
        } else {
            Toast.makeText(this, "Network not available!", Toast.LENGTH_SHORT).show();
        }
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


    private void requestData() {
//        Intent intent = new Intent(this, MyIntentService.class);
//        startService(intent);
        MyWebService myWebService = MyWebService.retrofit.create(MyWebService.class);
        Call<DataItem[]> call = myWebService.getData();
        sendRequest(call);
    }

    private void requestData(String category) {
        MyWebService myWebService = MyWebService.retrofit.create(MyWebService.class);
        Call<DataItem[]> call = myWebService.getData(category);
        sendRequest(call);
    }

    private void sendRequest(Call<DataItem[]> call) {
        call.enqueue(new Callback<DataItem[]>() {
            @Override
            public void onResponse(@NonNull Call<DataItem[]> call, @NonNull Response<DataItem[]> response) {
                DataItem[] dataItems = response.body();
                for (DataItem data :
                        dataItems != null ? dataItems : new DataItem[0]) {
                    output.append("\n" + data.getItemName() + " # " + data.getPrice());
                }
            }

            @Override
            public void onFailure(@NonNull Call<DataItem[]> call, @NonNull Throwable t) {

            }
        });
    }
}
