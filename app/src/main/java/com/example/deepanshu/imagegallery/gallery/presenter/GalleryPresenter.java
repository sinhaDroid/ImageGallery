package com.example.deepanshu.imagegallery.gallery.presenter;

import android.content.Intent;

/**
 * Created by deepanshu on 10/5/17.
 */

public interface GalleryPresenter {
    void onActivityCreated();

    void onClickCamera();

    void onActivityResult(int requestCode, int resultCode, Intent data);
}
