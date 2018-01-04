package com.example.android.restful;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.android.restful.services.MyIntentService;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

    private static final String JSON_URL = "http://localhost/nadiaservices/json/itemsfeed.php";

    public TextView output;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = (TextView) findViewById(R.id.output);

    }

    public void runClickHandler(View view) {
        getSupportLoaderManager().initLoader(0, null, this).forceLoad();
        Intent intent = new Intent(this, MyIntentService.class);
        intent.setData(Uri.parse(JSON_URL));
//        One thread will be used.
        startService(intent);
        startService(intent);
        startService(intent);
    }

    public void clearClickHandler(View view) {
        output.setText("");
    }


    @Override
    public Loader<String> onCreateLoader(int id, Bundle args) {
        output.append("AsyncTask will be loaded\n");
        return new MyAsyncTaskLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String data) {
        output.append(data + " is your data");
    }


    @Override
    public void onLoaderReset(Loader<String> loader) {

    }
}
