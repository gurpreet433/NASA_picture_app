package com.gurpreet.singh.nasa_picture_app.network

import okhttp3.Interceptor
import okhttp3.Response

class IconsInterceptor : Interceptor {

    //This adds the token to the header.
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Authorization", "Bearer " + "")
            .build()

        return chain.proceed(request)
    }
}