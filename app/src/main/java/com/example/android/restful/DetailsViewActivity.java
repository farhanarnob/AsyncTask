package com.example.android.restful;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.restful.model.DataItem;
import com.example.android.restful.observer.RealmExecuteDone;
import com.example.android.restful.services.RealmProcessor;

import static com.example.android.restful.model.DataItemFields.ID;
import static com.example.android.restful.model.WorkType.UPDATE;

/**
 * Created by hp on 1/11/2018.
 */

public class DetailsViewActivity extends AppCompatActivity implements RealmExecuteDone {
    private final String TAG = DetailsViewActivity.class.getSimpleName();
    private DataItem dataItem;
    private TextView textViewHeadline, textViewDescription, textViewInfo, textViewPrice;
    private ImageView imageViewDetails;
    private RealmProcessor mRealmProcessor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        mRealmProcessor = new RealmProcessor(DetailsViewActivity.this);
        mRealmProcessor.open();
        Bundle bundle = getIntent().getExtras();
        String dataItemID = bundle.getString(ID,"");

        Log.i(TAG, "dataItemID" + dataItemID);

        dataItem = mRealmProcessor.getData(dataItemID);
        initializeView();
        setupOrUpdateView(dataItem);
        DataItem dataItemp = mRealmProcessor.updateDescription(dataItemID, "HELLO BOSS");
        Log.d(TAG,dataItem.getDescription());
        setupOrUpdateView(dataItemp);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mRealmProcessor.close();
    }

    private void initializeView() {
        textViewHeadline = (TextView) findViewById(R.id.textViewHeadline);
        textViewDescription = (TextView) findViewById(R.id.textViewDescription);
        textViewInfo = (TextView) findViewById(R.id.textViewInfo);
        textViewPrice = (TextView) findViewById(R.id.textViewPrice);
    }

    private void setupOrUpdateView(DataItem dataItem) {
        textViewHeadline.setText(dataItem.getItemName());
        textViewInfo.setText(dataItem.getCategory());
        textViewPrice.setText(String.format("price:%s", dataItem.getPrice()));
        textViewDescription.setText(dataItem.getDescription());
    }

    @Override
    public void ProgressDone(int type) {
        switch (type) {
            case UPDATE: {
              //  showUpdatedValue();
                break;
            }
        }
    }

    private void showUpdatedValue() {

        dataItem = mRealmProcessor.getData(dataItem.getId());
        setupOrUpdateView(dataItem);
    }

}
