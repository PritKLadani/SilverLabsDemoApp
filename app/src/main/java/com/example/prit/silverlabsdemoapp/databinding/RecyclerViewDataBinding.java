package com.example.prit.silverlabsdemoapp.databinding;

import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.prit.silverlabsdemoapp.R;
import com.example.prit.silverlabsdemoapp.adapter.DataAdapter;
import com.example.prit.silverlabsdemoapp.model.DataModel;

import java.util.List;

public class RecyclerViewDataBinding {
    /**
     * Binds the data to the {@link android.support.v7.widget.RecyclerView.Adapter}, sets the
     * recycler view on the adapter, and performs some other recycler view initialization.
     *
     * @param recyclerView passed in automatically with the data binding
     * @param adapter      must be explicitly passed in
     * @param data         must be explicitly passed in
     */
    @BindingAdapter({"app:adapter", "app:data"})
    public void bind(RecyclerView recyclerView, DataAdapter adapter, List<DataModel> data) {
        recyclerView.setAdapter(adapter);
        adapter.updateData(data);
    }

    @BindingAdapter("imageUrl")
    public static void bindRecyclerViewAdapter(final ImageView imageView, String imageUrl) {
        if (imageUrl != null) {
            if (imageView.getTag(R.id.imageView) == null || !imageView.getTag(R.id.imageView).equals(imageUrl)) {
                imageView.setImageBitmap(null);
                imageView.setTag(R.id.imageView, imageUrl);
                Glide.with(imageView.getContext())
                        .load(imageUrl)
                        .apply(RequestOptions.circleCropTransform())
                        .into(imageView);
//                Glide.with(imageView.getContext()).load(imageUrl).into(imageView);
            }
        } else {
            imageView.setTag(R.id.imageView, null);
            imageView.setImageBitmap(null);
        }
    }
}
