package com.example.android.restful.Utilities;

/**
 * Created by arnob on 1/7/2018.
 * for learning http connection
 */

import com.example.android.restful.model.RequestPackage;

import java.io.IOException;
import java.io.InputStream;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Helper class for working with a remote server
 */

public class HttpHelper {


    /**
     * Returns text from a URL on a web server
     *
     * @return
     * @throws IOException
     */

    public static String downloadUrl(RequestPackage requestPackage) throws IOException {


        InputStream is = null;

        String address = requestPackage.getEndpoint();
        String encodedParam = requestPackage.getEncodedParams();

        if (requestPackage.getMethod().equals("GET") &&
                encodedParam.length() > 0) {
            address = String.format("%s?%s", address, encodedParam);
        }

        // OkHttpClient side creation
        OkHttpClient client = new OkHttpClient();

        Request.Builder requestBuilder = new Request.Builder().url(address);

        Request request = requestBuilder.build();

        Response response = client.newCall(request).execute();

        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Exception: response code:" + response.code());
        }

    }


}
