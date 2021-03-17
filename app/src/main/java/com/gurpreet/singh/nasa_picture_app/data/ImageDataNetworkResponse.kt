package com.gurpreet.singh.nasa_picture_app.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImageDataNetworkResponse(
        val listImages: List<ImageData>
) : Parcelable