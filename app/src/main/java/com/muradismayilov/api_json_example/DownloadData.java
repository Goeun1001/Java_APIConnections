package com.muradismayilov.api_json_example;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class DownloadData extends AsyncTask<String,Void,String> {

    @Override
    protected String doInBackground(String... strings) {

        String result = "";
        URL url;
        HttpsURLConnection conn;

        try {
            url = new URL(strings[0]);
            conn = (HttpsURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(30000);
            Map<String, Object> params = new LinkedHashMap();

            params.put("email", MainActivity.emailText.getText().toString());
            params.put("password", MainActivity.passwordText.getText().toString());
            params.put("username", MainActivity.usernameText.getText().toString());
            StringBuilder postData = new StringBuilder();
            Iterator var6 = params.entrySet().iterator();

            while(var6.hasNext()) {
                Map.Entry<String, Object> param = (Map.Entry)var6.next();
                if (postData.length() != 0) {
                    postData.append('&');
                }

                postData.append(URLEncoder.encode((String)param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
            }

            byte[] postDataBytes = postData.toString().getBytes("UTF-8");
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);
            conn.connect();

            InputStream inputStream = conn.getInputStream();
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
            String text = jsonObject.getString("message");

            MainActivity.textView.setText(text);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}