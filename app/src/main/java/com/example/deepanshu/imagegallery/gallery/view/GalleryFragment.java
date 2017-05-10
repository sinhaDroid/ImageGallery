package com.example.deepanshu.imagegallery.gallery.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
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

    private FloatingActionButton mFab;

    private GalleryPresenter mGalleryPresenter;

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

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 4);
        mGallery = (RecyclerView) getActivity().findViewById(R.id.gallery_rcv);
        mGallery.setHasFixedSize(true);
        mGallery.setLayoutManager(layoutManager);

        mFab = (FloatingActionButton) getActivity().findViewById(R.id.camera_fab);
        mFab.setOnClickListener(this);

        mGalleryPresenter = GalleryPresenterImpl.newInstance(this);
        mGalleryPresenter.onActivityCreated();
    }

    @Override
    public void setAdapter(ImageGalleryAdapter imageGalleryAdapter) {
        mGallery.setAdapter(imageGalleryAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.camera_fab:
                mGalleryPresenter.onClickCamera();
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mGalleryPresenter.onActivityResult(requestCode, resultCode, data);
    }
}
