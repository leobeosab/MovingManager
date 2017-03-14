package me.ryanwise.movingmanagerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<MovingItemModel> data = new ArrayList<MovingItemModel>();
        data.add(new MovingItemModel("123 North shore drive, 49240, Grand Rapids, Mi", "Stark Family", "http://wallpaperlayer.com/img/2015/9/programming-wallpaper-background-8233-8552-hd-wallpapers.jpg"));

        MovingItemAdapter adapter = new MovingItemAdapter(this, data);

        ListView listView = (ListView) findViewById(R.id.movinglist);
        listView.setAdapter(adapter);
    }
}
