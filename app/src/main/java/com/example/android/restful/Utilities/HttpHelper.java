package com.example.android.restful.Utilities;

import com.example.android.restful.model.RequestPackage;

import java.io.IOException;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * Helper class for working with a remote server
 */

public class HttpHelper {


    /**
     * Returns text from a URL on a web server
     *
     * @return String of date which is json formatted.
     * @throws IOException for detecting that connection is not successful.
     */

    public static String downloadUrl(RequestPackage requestPackage) throws IOException {


        String address = requestPackage.getEndpoint();
        String encodedParam = requestPackage.getEncodedParams();

        if (requestPackage.getMethod().equals("GET") &&
                encodedParam.length() > 0) {
            address = String.format("%s?%s", address, encodedParam);
        }

        // OkHttpClient side creation
        OkHttpClient client = new OkHttpClient();

        Request.Builder requestBuilder = new Request.Builder().url(address);


//        Post method start
        if (requestPackage.getMethod().equals("POST")) {
            MultipartBody.Builder builder = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM);
            Map<String, String> params = requestPackage.getParams();
            for (String key : params.keySet()) {
                builder.addFormDataPart(key, params.get(key));
            }
            RequestBody requestBody = builder.build();
            requestBuilder.method("POST", requestBody);
        }

//        Post method end



        Request request = requestBuilder.build();

        Response response = client.newCall(request).execute();

        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Exception: response code:" + response.code());
        }

    }


}
