package com.matheus.vertexapp.data.repository

import com.matheus.vertexapp.data.api.ServiceProvider
import com.matheus.vertexapp.data.model.DetailVideoResponse
import retrofit2.Call

class VideoRespository {
    fun filterVideos(type :String, part :String, query :String, key :String) = ServiceProvider.service.filterVideos(type,part,query,key)

    fun getStatisticVideo(id : String, part :String, key :String) : Call<DetailVideoResponse> = ServiceProvider.service.getStatisticVideo(id,part,key)
}