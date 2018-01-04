package com.example.android.restful;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

/**
 * Created by hp on 1/4/2018.
 */

public class MyAsyncTaskLoader extends AsyncTaskLoader<String> {
    public MyAsyncTaskLoader(Context context) {
        super(context);
    }

    @Override
    public void deliverResult(String data) {
        data += " delivered";
        super.deliverResult(data);
    }

    @Override
    public String loadInBackground() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Field Buzz";
    }
}
