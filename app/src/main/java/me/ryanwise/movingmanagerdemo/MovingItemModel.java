package me.ryanwise.movingmanagerdemo;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Ryan on 3/13/2017.
 */

public class MovingItemModel {

    public String address, familyName, imageUrl;

    public MovingItemModel(String address, String familyName, String imageUrl) {
        this.address = address;
        this.familyName = familyName;
        this.imageUrl = imageUrl;
    }

    public MovingItemModel(JSONObject data) {
        try {
            this.address = data.getString("address");
            this.familyName = data.getString("familyName");
            this.imageUrl = data.getString("imageUrl");
        } catch (JSONException e) {
            System.err.print("Error while decoding JSON variables");
            e.printStackTrace();
        }
    }

}
