package com.gurpreet.singh.nasa_picture_app.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gurpreet.singh.nasa_picture_app.data.ImageData
import com.gurpreet.singh.nasa_picture_app.view_model.ImageDetailsViewModel

class ImageDetailsViewModelFactory(
    private val imageData: ImageData,
    private val imageDataList: ArrayList<ImageData>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ImageDetailsViewModel::class.java)) {
            return ImageDetailsViewModel(imageData, imageDataList) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
