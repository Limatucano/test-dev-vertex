package com.matheus.vertexapp.data.api

import com.matheus.vertexapp.data.model.VideosResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface YoutubeRequests {

    @GET("search")
    fun filterVideos(
        @Query("type") type : String,
        @Query("part") part : String,
        @Query("q") query : String,
        @Query("key") key : String)
    : Call<VideosResponse>
}