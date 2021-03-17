package com.gurpreet.singh.nasa_picture_app.view_model

import android.util.Log
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

    var imagesList = MutableLiveData<List<ImageData>>()

    init {
        getImageData()
    }

    private fun getImageData(){
        var resultStatus = ""

        coroutineScope.launch {
            var getServerResponseDeferred = ImagesAPI.retrofitService.getImagesData()
            resultStatus = try {
                var serverResponse = getServerResponseDeferred.await()
                imagesList.value = serverResponse.listImages
                "Success"

            } catch (t:Throwable){
                "Failure" + t.message
            }

            Log.i("apiresponse", resultStatus + "")
        }
    }
}
