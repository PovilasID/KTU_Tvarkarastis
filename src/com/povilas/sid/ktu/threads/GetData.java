package com.povilas.sid.ktu.threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import android.os.AsyncTask;

public class GetData extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... params) {
    String str = null;
           try {
               // Create a URL for the desired page
               URL url = new URL(params[0]);

               // Read all the text returned by the server
               InputStream is = url.openStream();
               InputStreamReader isr = new InputStreamReader(is);
               BufferedReader in = new BufferedReader(isr);
               String temp;
               while((temp = in.readLine()) != null){
            	   str += temp;
               }
               is.close();
               isr.close();
               in.close();
           } catch (MalformedURLException e) {
            e.printStackTrace();
           } catch (IOException e) {
            e.printStackTrace();
           }
    return str;
    }
       @Override
       protected void onPostExecute(String result) {
       }
}
