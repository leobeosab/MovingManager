package me.ryanwise.movingmanagerdemo;

import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by Ryan on 3/15/2017.
 */

public class JSONParser {

    //read : Return complete data as string from a reader
    private static String read(Reader rd) {
        StringBuilder sb = new StringBuilder();
        int cp;
        try {
            //read every character in until end character appears
            while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
            }
        } catch (IOException e) {
            Log.v("SOMETAG", e.toString());
            //System.err.println(e.toString());
        }


        return sb.toString();
    }

    //urlGetRequest : Make a get request to a url and return JSONObject from respone
    public JSONObject urlGetRequest(String url) {
        try {
            InputStream is = new URL(url).openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonString = read(br);
            is.close();
            Log.v("SOMETAG", jsonString);
            return new JSONObject(jsonString);
        } catch (Exception e) {
           Log.v("SOMETAG", e.toString());
        }

        return null;
    }

}
