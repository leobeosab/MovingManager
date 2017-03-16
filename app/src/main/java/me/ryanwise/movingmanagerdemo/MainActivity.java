package me.ryanwise.movingmanagerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BackgroundRetrieveMoves.Listener {

    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.movinglist);
        new BackgroundRetrieveMoves(this).execute();
    }

    @Override
    public void onLoaded(ArrayList<MovingItemModel> data) {
        MovingItemAdapter adapter = new MovingItemAdapter(this, data);
        listView.setAdapter(adapter);
    }

    private ArrayList<MovingItemModel> getMovesFromApi() {
        ArrayList<MovingItemModel> data = new ArrayList<MovingItemModel>();
        return data;
    }
}
