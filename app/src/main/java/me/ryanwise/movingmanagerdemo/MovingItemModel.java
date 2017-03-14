package me.ryanwise.movingmanagerdemo;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Ryan on 3/13/2017.
 */

//Used to hold data for each list item
public class MovingItemModel {

    public String address, familyName, imageUrl;

    //Used for manual testing
    public MovingItemModel(String address, String familyName, String imageUrl) {
        this.address = address;
        this.familyName = familyName;
        this.imageUrl = imageUrl;
    }

    //For when we grab from an API endpoint
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
