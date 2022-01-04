package com.matheus.vertexapp.data.repository

import com.matheus.vertexapp.data.api.ServiceProvider

class VideoRespository {
    fun filterVideos(type :String, part :String, query :String, key :String) = ServiceProvider.service.filterVideos(type,part,query,key)
}