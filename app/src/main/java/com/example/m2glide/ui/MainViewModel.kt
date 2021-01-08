package com.example.m2glide.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.m2glide.network.WebClient
import androidx.lifecycle.viewModelScope
import com.example.m2glide.domain.Photo
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val mutablePhotosLiveData = MutableLiveData<List<Photo>>()
    val photosLiveData: LiveData<List<Photo>> = mutablePhotosLiveData
    private val query: MutableLiveData<String> = MutableLiveData<String>()

    init {
        query.value="nature"
        updatePhotos()
    }

    private fun updatePhotos(){
        viewModelScope.launch {
            val searchResponse = WebClient.client.fetchImages(research = query.value.toString())
            val photosList = searchResponse.photos.map { photo ->
                Photo(
                        id = photo.id, url = photo.src.portrait, photographer = photo.photographer
                )
            }
            mutablePhotosLiveData.postValue(photosList)
        }
    }

    fun updateQuery(research: String){
        query.value = research
        updatePhotos()
    }


}