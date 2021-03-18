package com.gurpreet.singh.nasa_picture_app.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.gurpreet.singh.nasa_picture_app.data.ImageData

@BindingAdapter("loadImage")
fun ImageView.setPremiumOrFreeBadge(item: ImageData) {
    item?.let {

        Glide.with(this)
                .load(item.url)
                .into(this)
    }
}
