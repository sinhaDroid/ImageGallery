package com.example.deepanshu.imagegallery.gallery.db;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    private void setSharedStringSetData(String key, HashSet<String> valueList) {
        getEditor().putStringSet(key, valueList).apply();
    }

    private Set<String> getSharedStringSetData(String key) {
        return getSharedPreferences().getStringSet(key, null);
    }

    private SharedPreferences.Editor getEditor() {
        return getSharedPreferences().edit();
    }

    public void saveImage(String bitMapToString) {
        getImageList().add(bitMapToString);
        saveImageList(getImageList());
    }

    public List<String> getImageList() {
        Set<String> imageList = getSharedStringSetData("IMAGE_LIST");

        if (null != imageList && imageList.size() > 0) {
            return new ArrayList<>(imageList);
        }
        return new ArrayList<>();
    }

    private void saveImageList(List<String> imageList) {
        HashSet<String> set = new HashSet<>();
        set.addAll(imageList);
        setSharedStringSetData("IMAGE_LIST", set);
    }
}
