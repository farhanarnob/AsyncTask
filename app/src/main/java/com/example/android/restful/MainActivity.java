package com.example.android.restful;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<String> {

    public TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = (TextView) findViewById(R.id.output);

    }

    public void runClickHandler(View view) {
        getSupportLoaderManager().initLoader(0,null,this).startLoading();
    }

    public void clearClickHandler(View view) {
        output.setText("");
    }

    @Override
    public Loader<String> onCreateLoader(int id, Bundle args) {
//        output.append("Loader created");
        return new MyAsyncTaskLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String data) {
//        output.append("Loader finished");
    }

    @Override
    public void onLoaderReset(Loader<String> loader) {

    }

    public class MyAsyncTaskLoader extends AsyncTaskLoader<String>{

        MyAsyncTaskLoader(Context context) {
            super(context);
        }

        @Override
        public String loadInBackground() {
            return "load worked";
        }
    }

}
