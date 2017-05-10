package com.example.deepanshu.imagegallery.gallery.view;

import android.content.Intent;

import com.example.deepanshu.imagegallery.gallery.adapter.ImageGalleryAdapter;

/**
 * Created by deepanshu on 10/5/17.
 */

public interface GalleryView {
    void setAdapter(ImageGalleryAdapter imageGalleryAdapter);

    void startActivityForResult(Intent intent, int requestCode);
}
