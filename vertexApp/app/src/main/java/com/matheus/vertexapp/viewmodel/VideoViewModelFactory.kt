package com.matheus.vertexapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.matheus.vertexapp.data.repository.VideoRespository
import java.lang.IllegalArgumentException

class VideoViewModelFactory(private val repository : VideoRespository) :  ViewModelProvider.Factory{
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(VideoViewModel::class.java)){
            VideoViewModel(this.repository) as T
        }else{
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}