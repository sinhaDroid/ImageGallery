package com.example.deepanshu.imagegallery.gallery.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.deepanshu.imagegallery.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deepanshu on 10/5/17.
 */

public class ImageGalleryAdapter extends RecyclerView.Adapter<ImageGalleryAdapter.MyViewHolder> {

    private List<Bitmap> bitmapList = new ArrayList<>();

    @Override
    public ImageGalleryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.inflater_image, parent, false));
    }

    @Override
    public void onBindViewHolder(ImageGalleryAdapter.MyViewHolder holder, int position) {
        holder.bind(getItem(position));
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

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.iv_photo);
        }

        void bind(Bitmap item) {
            imageView.setImageBitmap(item);
        }
    }
}
