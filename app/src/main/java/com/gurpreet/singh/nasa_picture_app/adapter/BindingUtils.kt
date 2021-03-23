package com.gurpreet.singh.nasa_picture_app.adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.gurpreet.singh.nasa_picture_app.R
import com.gurpreet.singh.nasa_picture_app.data.ImageData

@BindingAdapter("loadImage")
fun ImageView.loadImageFromUrl(url: String?) {
    url?.let {

        Glide.with(this)
            .load(url)
            .apply(RequestOptions().placeholder(R.drawable.loading_animation))
            .error(R.drawable.ic_broken_image)
            .into(this)
    }
}
