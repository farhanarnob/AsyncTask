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
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.restful.Utilities.NetworkHelper;
import com.example.android.restful.Utilities.RealmProcessor;
import com.example.android.restful.model.DataItem;
import com.example.android.restful.observer.RealmExecuteDone;
import com.example.android.restful.services.MyIntentService;
import com.example.android.restful.services.MyWebService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements RealmExecuteDone {

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
    private NumberPicker numberPicker;
    private boolean dataAlreadyInserted = false;
    private RealmProcessor realmProcessor;
    private boolean networkOk;
    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        output = (TextView) findViewById(R.id.output);


        numberPickerInitialization();


        LocalBroadcastManager.getInstance(getApplicationContext())
                .registerReceiver(broadcastReceiver,
                        new IntentFilter(MyIntentService.MY_SERVICE_MESSAGE));

        networkOk = NetworkHelper.hasNetworkAccess(this);
        output.append("Network Okay: " + networkOk);

        realmProcessor = new RealmProcessor(this);
        realmProcessor.open();


    }


    public void runClickHandler(View view) {
        if (networkOk) {
            requestData();
//            requestData("Desserts");
        } else {
            Toast.makeText(this, "Network not available!", Toast.LENGTH_SHORT).show();
        }
    }

    public void clearClickHandler(View view) {
        dataAlreadyInserted = realmProcessor.deleteRealmObject();
        output.setText("");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this)
                .unregisterReceiver(broadcastReceiver);
        realmProcessor.close();

    }


    private void requestData() {

        if (realmProcessor.realmIsEmpty() && !dataAlreadyInserted) {
            MyWebService myWebService = MyWebService.retrofit.create(MyWebService.class);
            Call<DataItem[]> call = myWebService.getData();
            sendRequest(call);
        } else {
            showDataFromRealm(numberPicker.getValue());
        }
    }

    private void requestData(String category) {
        if (realmProcessor.realmIsEmpty() && !dataAlreadyInserted) {
            MyWebService myWebService = MyWebService.retrofit.create(MyWebService.class);
            Call<DataItem[]> call = myWebService.getData(category);
            sendRequest(call);
        } else {
            showDataFromRealm(numberPicker.getValue());
        }
    }

    private void sendRequest(Call<DataItem[]> call) {
        call.enqueue(new Callback<DataItem[]>() {
            @Override
            public void onResponse(@NonNull Call<DataItem[]> call, @NonNull Response<DataItem[]> response) {
                DataItem[] dataItems = response.body();
                dataAlreadyInserted = realmProcessor.createDataItemAllAsync(dataItems);
            }

            @Override
            public void onFailure(@NonNull Call<DataItem[]> call, @NonNull Throwable t) {

            }
        });
    }


    @Override
    public void insertionDone() {
        showDataFromRealm(numberPicker.getValue());

    }

    private void showDataFromRealm(int newVal) {
        DataItem[] dataItems = realmProcessor.getData(newVal);
        output.setText("");
        for (DataItem dataItem : dataItems) {
            output.append("\n" + dataItem.getItemName() + " # Price: $" + dataItem.getPrice());
        }
    }


    private void numberPickerInitialization() {
        numberPicker = (NumberPicker) findViewById(R.id.np);
        numberPicker.setMinValue(4);
        numberPicker.setMaxValue(14);
        numberPicker.setValue(10);
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                showDataFromRealm(newVal);
            }
        });
    }
}