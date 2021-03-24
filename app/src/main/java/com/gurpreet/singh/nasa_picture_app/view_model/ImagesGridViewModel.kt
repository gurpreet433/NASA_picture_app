package com.gurpreet.singh.nasa_picture_app.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gurpreet.singh.nasa_picture_app.data.ImageData
import com.gurpreet.singh.nasa_picture_app.network.ImagesAPI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ImagesGridViewModel: ViewModel() {
    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private var _imagesList = MutableLiveData<List<ImageData>>()

    val imagesList : LiveData<List<ImageData>>
        get() = _imagesList

    init {
        getImageData()
    }

    private fun getImageData(){
        lateinit var resultStatus : String

        coroutineScope.launch {
            var getServerResponseDeferred = ImagesAPI.retrofitService.getImagesDataAsync()
            resultStatus = try {
                var serverResponse = getServerResponseDeferred.await()
                _imagesList.value = serverResponse
                "Success"

            } catch (t:Throwable){
                "Failure" + t.message
            }

            Log.i("api_response", resultStatus + "")
        }
    }
}
