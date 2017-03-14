package me.ryanwise.movingmanagerdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by Ryan on 3/13/2017.
 */

//Downloads an image and sets it asynchronously
public class BackgroundDownloadImage extends AsyncTask<String, Void, Bitmap> {

    ImageView image;

    public BackgroundDownloadImage(ImageView image) {
        this.image = image;
    }

    protected Bitmap doInBackground(String... urls) {
        String imageUrl = urls[0];
        Bitmap downloadedImage = null;
        try {
            InputStream data = new URL(imageUrl).openStream();
            downloadedImage = BitmapFactory.decodeStream(data);
        } catch(Exception e) {
            System.err.println("Error while downloading image from url");
            e.printStackTrace();
        }

        return downloadedImage;
    }

    protected void onPostExecute(Bitmap result) {
        image.setImageBitmap(result);
    }

}
