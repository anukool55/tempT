package com.example.anukool.tempt;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
//fetching of JSON data is performed in Background function
public class BackGround extends AsyncTask<Void,Void,Void>{
//it is our base url
URL baseURL;




    String APIid="&APPID=17ff58ac89488d78cb7946cbe30d4169";
String city="Delhi";
//in this data variable all the data  will be stored
String data="";
    JSONObject jo;
   //this clloct variable will contain the value of temprature
    double clloct;
    @Override
    protected Void doInBackground(Void... voids) {


city= String.valueOf(MainActivity.e1.getText());

        try {
            baseURL = new URL("https://api.openweathermap.org/data/2.5/weather?q="+city+"&units=metric&APPID=17ff58ac89488d78cb7946cbe30d4169");
//opening connection with url
            HttpsURLConnection connection=(HttpsURLConnection)baseURL.openConnection();
           //setting up input stream
            InputStream is=connection.getInputStream();
         //setting uo bufferreader to read inoutstream data
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
String line="";
while(line!=null)
{
   line=br.readLine();
   data=data+line;
}



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
//the data which is to be displayed is parsed in onPostexcute function
    @Override
    protected void onPostExecute(Void aVoid) {


        super.onPostExecute(aVoid);
       try {
          jo=new JSONObject(data);

            JSONObject job=jo.getJSONObject("main");
           clloct=  job.getDouble("temp");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        String stringdouble= Double.toString(clloct);
        MainActivity.t1.setText(stringdouble);



    }
}
