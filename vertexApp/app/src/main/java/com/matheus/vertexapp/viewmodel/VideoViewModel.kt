package com.matheus.vertexapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.matheus.vertexapp.BuildConfig
import com.matheus.vertexapp.data.model.DetailVideoResponse
import com.matheus.vertexapp.data.model.VideoResponse
import com.matheus.vertexapp.data.model.VideosResponse
import com.matheus.vertexapp.data.repository.VideoRespository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.HttpURLConnection

class VideoViewModel(private val repository: VideoRespository)  : ViewModel(){

    val allVideo = MutableLiveData<VideosResponse>()
    val failToGetAllVideos = MutableLiveData<String>()
    val detailVideo = MutableLiveData<DetailVideoResponse>()
    val failToGetDetailVideo = MutableLiveData<String>()
    private val apiKey = BuildConfig.API_KEY

    fun getStatisticVideo(id: String, part : String = "snippet,statistics", key : String = apiKey){
        repository.getStatisticVideo(id, part, key).enqueue(
            object : Callback<DetailVideoResponse>{
                override fun onResponse(
                    call: Call<DetailVideoResponse>,
                    response: Response<DetailVideoResponse>
                ) {
                    if(response.code() in 200..299){
                        val body = response.body()
                        detailVideo.postValue(body)
                        return
                    }
                }

                override fun onFailure(call: Call<DetailVideoResponse>, t: Throwable) {
                    failToGetDetailVideo.postValue("Erro ao se comunicar com a API")
                }

            }
        )

    }
    fun filterVideos(type : String = "video", part : String = "id,snippet", query : String, key : String = apiKey){
        repository.filterVideos(type, part, query, key).enqueue(
            object : Callback<VideosResponse>{
                override fun onResponse(
                    call: Call<VideosResponse>,
                    response: Response<VideosResponse>
                ) {
                    if(response.code() in 200..299){
                        val body = response.body()
                        allVideo.postValue(body)
                        return
                    }
                    when(response.code()){
                        HttpURLConnection.HTTP_FORBIDDEN->{
                            failToGetAllVideos.postValue("Não autorizado.")
                            return
                        }
                        HttpURLConnection.HTTP_BAD_REQUEST->{
                            failToGetAllVideos.postValue("Parâmetro passado inválido.")
                            return
                        }
                        HttpURLConnection.HTTP_NOT_FOUND->{
                            failToGetAllVideos.postValue("Não encontrado.")
                            return
                        }
                        else->{
                            failToGetAllVideos.postValue("Infelizmente tivemos um problema.")
                            return
                        }
                    }

                }

                override fun onFailure(call: Call<VideosResponse>, t: Throwable) {
                    failToGetAllVideos.postValue("Erro ao se comunicar com a API")
                }
            }
        )
    }
}