package com.gurpreet.singh.nasa_picture_app.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImageDataNetworkResponse(

        @Json(name = "copyright")
        val copyright: String,
        @Json(name = "date")
        val date: String,
        @Json(name = "explanation")
        val explanation: String,
        @Json(name = "hdurl")
        val hdurl: String,
        @Json(name = "media_type")
        val media_type: String,
        @Json(name = "service_version")
        val service_version: String,
        @Json(name = "title")
        val title: String,
        @Json(name = "url")
        val url: String

) : Parcelable