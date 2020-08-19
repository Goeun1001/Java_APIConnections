package com.muradismayilov.api_json_example;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class DownloadData extends AsyncTask<String,Void,String> {


    @Override
    protected String doInBackground(String... strings) {

        String result = "";
        URL url;
        HttpsURLConnection httpsURLConnection;

        try {
            url = new URL(strings[0]);
            httpsURLConnection = (HttpsURLConnection) url.openConnection();

            InputStream inputStream = httpsURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            int data = inputStreamReader.read();

            while(data > 0){

                char character = (char)data;
                result += character;

                data = inputStreamReader.read();
            }

            return result;

        } catch (Exception e) {
            return null;
        }

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        try {
            JSONObject jsonObject = new JSONObject(s);
            String text = jsonObject.getString("id");

            MainActivity.textView.setText(text);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
