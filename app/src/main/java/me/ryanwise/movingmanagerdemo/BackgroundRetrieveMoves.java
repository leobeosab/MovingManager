package me.ryanwise.movingmanagerdemo;

import android.os.AsyncTask;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Ryan on 3/15/2017.
 */

public class BackgroundRetrieveMoves extends AsyncTask<String, Void, ArrayList<MovingItemModel>> {

    private Listener listener;

    public BackgroundRetrieveMoves(Listener listener) {
        this.listener = listener;
    }

    public interface Listener {
        void onLoaded(ArrayList<MovingItemModel> data);
    }

    protected ArrayList<MovingItemModel> doInBackground(String... urls) {
        ArrayList<MovingItemModel> data = new ArrayList<MovingItemModel>();

        JSONObject response = new JSONParser().urlGetRequest("http://192.168.1.234:8080");

        if (response != null) {
            try {
                JSONArray json_moves = response.getJSONArray("moves");
                for (int i = 0; i < json_moves.length(); i++) {
                    JSONObject iter = json_moves.getJSONObject(i);
                    data.add(new MovingItemModel(iter));
                }
            } catch (JSONException e) {
                System.err.println(e.toString());
            }
        }
        return data;
    }

    protected void onPostExecute(ArrayList<MovingItemModel> result) {
        listener.onLoaded(result);
    }
}
