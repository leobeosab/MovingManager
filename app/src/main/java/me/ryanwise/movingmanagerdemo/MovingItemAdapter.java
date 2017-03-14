package me.ryanwise.movingmanagerdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ryan on 3/13/2017.
 */

//Simple list adapter for disaplaying all the information we need
public class MovingItemAdapter extends ArrayAdapter<MovingItemModel> {

    public MovingItemAdapter(Context context, ArrayList<MovingItemModel> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MovingItemModel item = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.moving_item_view, parent, false);
        }

        TextView familyName = (TextView) convertView.findViewById(R.id.family_name);
        TextView address = (TextView) convertView.findViewById(R.id.address);

        familyName.setText(item.familyName);
        address.setText(item.address);

        ImageView imageView =  (ImageView) convertView.findViewById(R.id.preview);
        new BackgroundDownloadImage(imageView).execute(item.imageUrl); //Download image asynchronously

        return convertView;
    }
}
