package com.gurpreet.singh.nasa_picture_app.network

import com.gurpreet.singh.nasa_picture_app.data.ImageData
import com.gurpreet.singh.nasa_picture_app.data.ImageDataNetworkResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.QueryMap

private const val BASE_URL = "https://mrandrioddev.github.io/"

private val client = OkHttpClient.Builder().apply {
    addInterceptor(IconsInterceptor())
}.build()

private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .client(client)
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl(BASE_URL)
        .build()

interface NASAApiService {
    @GET("mockApis.github.io")
    fun getImagesData(): Deferred<ImageDataNetworkResponse>
}

object ImagesAPI {
    val retrofitService: NASAApiService by lazy {
        retrofit.create(NASAApiService::class.java)
    }
}