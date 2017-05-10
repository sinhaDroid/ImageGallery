package com.example.deepanshu.imagegallery.gallery.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.deepanshu.imagegallery.R;
import com.example.deepanshu.imagegallery.gallery.adapter.ImageGalleryAdapter;
import com.example.deepanshu.imagegallery.gallery.presenter.GalleryPresenter;
import com.example.deepanshu.imagegallery.gallery.presenter.GalleryPresenterImpl;

/**
 * Created by deepanshu on 10/5/17.
 */

public class GalleryFragment extends Fragment implements GalleryView, View.OnClickListener {

    private RecyclerView mGallery;

    private GalleryPresenter mGalleryPresenter;

    // Class calling itself
    public static GalleryFragment newInstance() {
        return new GalleryFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gallery, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mGallery = (RecyclerView) getActivity().findViewById(R.id.gallery_rcv);

        getActivity().findViewById(R.id.camera_fab).setOnClickListener(this);

        // for separation of logic from UI Interface
        mGalleryPresenter = GalleryPresenterImpl.newInstance(this);
        mGalleryPresenter.onActivityCreated();
    }

    /**
     * Setting Adapter
     * @param imageGalleryAdapter
     */
    @Override
    public void setAdapter(ImageGalleryAdapter imageGalleryAdapter) {
        mGallery.setAdapter(imageGalleryAdapter);
        mGallery.setHasFixedSize(true);
        mGallery.setLayoutManager(new GridLayoutManager(getContext(), 4));
    }

    @Override
    public void showEmptyMessage() {
        mGallery.setVisibility(View.GONE);
        getActivity().findViewById(R.id.no_image_tv).setVisibility(View.VISIBLE);
    }

    @Override
    public void showImages() {
        getActivity().findViewById(R.id.no_image_tv).setVisibility(View.GONE);
        mGallery.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.camera_fab:
                mGalleryPresenter.onClickCamera();
                break;
        }
    }

    /**
     * To handle activity result
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mGalleryPresenter.onActivityResult(requestCode, resultCode, data);
    }
}
