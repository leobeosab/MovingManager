package me.ryanwise.movingmanagerdemo;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Ryan on 3/13/2017.
 */

//Used to hold data for each list item
public class MovingItemModel {

    public int id;
    public String oldAddress, destinationAddress, familyName, imageUrl;

    //Used for manual testing
    public MovingItemModel(int id, String oldAddress, String destinationAddress, String familyName, String imageUrl) {
        this.id = id;
        this.oldAddress = oldAddress;
        this.destinationAddress = destinationAddress;
        this.familyName = familyName;
        this.imageUrl = imageUrl;
    }

    //For when we grab from an API endpoint
    public MovingItemModel(JSONObject data) {
        try {
            this.id = Integer.parseInt(data.getString("id"));
            this.oldAddress = data.getString("old_address");
            this.destinationAddress = data.getString("destination_address");
            this.familyName = data.getString("family_name");
            this.imageUrl = data.getString("preview_image_url");
        } catch (JSONException e) {
            System.err.print("Error while decoding JSON variables");
            e.printStackTrace();
        }
    }

}
