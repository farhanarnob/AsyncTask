package com.example.android.restful.Utilities;

/**
 * Created by arnob on 1/7/2018.
 * for learning http connection
 */

import com.example.android.restful.model.RequestPackage;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


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

        try {


            URL url = new URL(address);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setReadTimeout(10000);

            conn.setConnectTimeout(15000);

            conn.setRequestMethod("GET");

            conn.setDoInput(true);

            conn.connect();


            int responseCode = conn.getResponseCode();

            if (responseCode != 200) {

                throw new IOException("Got response code " + responseCode);

            }

            is = conn.getInputStream();

            return readStream(is);


        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            if (is != null) {

                is.close();

            }

        }

        return null;

    }


    /**
     * Reads an InputStream and converts it to a String.
     *
     * @param stream
     * @return
     * @throws IOException
     */

    private static String readStream(InputStream stream) throws IOException {


        byte[] buffer = new byte[1024];

        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();

        BufferedOutputStream out = null;

        try {

            int length = 0;

            out = new BufferedOutputStream(byteArray);

            while ((length = stream.read(buffer)) > 0) {

                out.write(buffer, 0, length);

            }

            out.flush();

            return byteArray.toString();

        } catch (IOException e) {

            e.printStackTrace();

            return null;

        } finally {

            if (out != null) {

                out.close();

            }

        }

    }


}
