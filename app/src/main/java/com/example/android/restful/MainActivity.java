package com.example.android.restful;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.restful.Utilities.NetworkHelper;
import com.example.android.restful.data.MyAdapterRealmAdapter;
import com.example.android.restful.model.DataItem;
import com.example.android.restful.observer.RealmExecuteDone;
import com.example.android.restful.services.MyWebService;
import com.example.android.restful.services.RealmProcessor;

import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.android.restful.model.WorkType.INSERT;

public class MainActivity extends AppCompatActivity implements RealmExecuteDone {

    private static final String JSON_URL = "http://560057.youcanlearnit.net/services/json/itemsfeed.php";
    public TextView output;
    MyAdapterRealmAdapter myAdapterRealmAdapter;
    private RecyclerView dataRecyclerView;
    private NumberPicker numberPicker;
    private boolean dataAlreadyInserted = false;
    private RealmProcessor realmProcessor;
    private boolean networkOk;
    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        // id initialization
        numberPickerInitialization();
        dataRecyclerView = (RecyclerView) findViewById(R.id.recycleViewData);
        initializeRecycleView();

        // network test
        networkOk = NetworkHelper.hasNetworkAccess(this);

        // realm initialization
        realmProcessor = new RealmProcessor(this);
        realmProcessor.open();


    }

    private void initializeRecycleView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dataRecyclerView.setLayoutManager(layoutManager);
        dataRecyclerView.setHasFixedSize(true);
        myAdapterRealmAdapter = new MyAdapterRealmAdapter(null, true);
        dataRecyclerView.setAdapter(myAdapterRealmAdapter);
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
    protected void onResume() {
        super.onResume();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    @Override
    public void ProgressDone(int type) {
        switch (type) {
            case INSERT: {
                showDataFromRealm(numberPicker.getValue());
                break;
            }
        }


    }

    private void showDataFromRealm(int newVal) {
        RealmResults<DataItem> realmResults = realmProcessor.getData(newVal);
        myAdapterRealmAdapter.updateData(realmResults);
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