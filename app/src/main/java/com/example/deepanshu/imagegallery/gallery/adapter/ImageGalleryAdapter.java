package com.example.deepanshu.imagegallery.gallery.adapter;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.deepanshu.imagegallery.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deepanshu on 10/5/17.
 */

public class ImageGalleryAdapter extends RecyclerView.Adapter<ImageGalleryAdapter.MyViewHolder> {

    private List<Bitmap> bitmapList = new ArrayList<>();

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.inflater_image, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    private Bitmap getItem(int position) {
        return bitmapList.get(position);
    }

    @Override
    public int getItemCount() {
        return bitmapList.size();
    }

    public void add(Bitmap bitmap) {
        bitmapList.add(bitmap);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
