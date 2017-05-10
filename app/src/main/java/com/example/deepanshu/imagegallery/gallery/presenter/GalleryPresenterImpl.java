package com.example.deepanshu.imagegallery.gallery.presenter;

import android.os.Bundle;

import com.example.deepanshu.imagegallery.gallery.adapter.ImageGalleryAdapter;
import com.example.deepanshu.imagegallery.gallery.view.GalleryFragment;
import com.example.deepanshu.imagegallery.gallery.view.GalleryView;

/**
 * Created by deepanshu on 10/5/17.
 */

public class GalleryPresenterImpl implements GalleryPresenter {

    private GalleryView mGalleryView;

    public GalleryPresenterImpl(GalleryView galleryView) {
        this.mGalleryView = galleryView;
    }

    public static GalleryPresenterImpl newInstance(GalleryView galleryView) {
        return new GalleryPresenterImpl(galleryView);
    }

    @Override
    public void onActivityCreated() {
        mGalleryView.setAdapter(new ImageGalleryAdapter());
    }
}
