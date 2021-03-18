package com.gurpreet.singh.nasa_picture_app.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.gurpreet.singh.nasa_picture_app.data.ImageData

@BindingAdapter("loadImage")
fun ImageView.setPremiumOrFreeBadge(url: String?) {
    url?.let {

        Glide.with(this)
                .load(url)
                .into(this)
    }
}
