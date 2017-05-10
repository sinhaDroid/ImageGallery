package com.example.deepanshu.imagegallery.gallery.db;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deepanshu on 10/5/17.
 */

public class GalleryDataHandler {

    private static final GalleryDataHandler ourInstance = new GalleryDataHandler();

    public static GalleryDataHandler getInstance() {
        return ourInstance;
    }

    private GalleryDataHandler() {
    }

    private SharedPreferences mSharedPreferences;

    public void init(Context context) {
        mSharedPreferences = context.getSharedPreferences(GalleryDataHandler.class.getCanonicalName(), Context.MODE_PRIVATE);
    }

    private SharedPreferences getSharedPreferences() {
        return mSharedPreferences;
    }

    public void setSharedStringData(String key, String value) {
        getEditor().putString(key, value).apply();
    }

    public String getSharedStringData(String key) {
        return getSharedPreferences().getString(key, null);
    }

    private SharedPreferences.Editor getEditor() {
        return getSharedPreferences().edit();
    }

    public void saveImage(String bitMapToString) {
        getImageList().add(bitMapToString);
        saveImageList(getImageList());
    }

    public List<String> getImageList() {
        String imageList = getSharedStringData("IMAGE_LIST");

        if (null != imageList && imageList.length() > 0) {
            return new ArrayList<>();
        }
        return new ArrayList<>();
    }

    public void saveImageList(List<String> imageList) {
//        setSharedStringData("IMAGE_LIST", imageList);
    }
}
