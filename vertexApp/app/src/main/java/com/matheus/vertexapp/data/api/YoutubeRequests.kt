package com.matheus.vertexapp.data.api

import com.matheus.vertexapp.data.model.DetailVideoResponse
import com.matheus.vertexapp.data.model.VideosResponse
import com.matheus.vertexapp.view.SearchFragmentDirections
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

    @GET("videos")
    fun getStatisticVideo(
        @Query("id") id : String,
        @Query("part") part : String,
        @Query("key") key : String)
    : Call<DetailVideoResponse>
}