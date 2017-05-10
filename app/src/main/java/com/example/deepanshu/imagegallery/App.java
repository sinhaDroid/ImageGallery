package com.example.deepanshu.imagegallery;

import android.app.Application;

import com.example.deepanshu.imagegallery.gallery.db.GalleryDataHandler;

/**
 * Created by deepanshu on 10/5/17.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Initializing Gallery Data Handler
        GalleryDataHandler.getInstance().init(this);
    }
}
