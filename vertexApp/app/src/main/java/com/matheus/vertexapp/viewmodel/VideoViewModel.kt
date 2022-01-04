package com.matheus.vertexapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.matheus.vertexapp.data.model.VideosResponse
import com.matheus.vertexapp.data.repository.VideoRespository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.HttpURLConnection

class VideoViewModel(private val repository: VideoRespository)  : ViewModel(){

    val allMovies = MutableLiveData<VideosResponse>()
    val failToGetAllMovies = MutableLiveData<String>()
    private val apiKey = ""

    fun filterVideos(type : String = "video", part : String = "id,snippet", query : String, key : String = apiKey){
        repository.filterVideos(type, part, query, key).enqueue(
            object : Callback<VideosResponse>{
                override fun onResponse(
                    call: Call<VideosResponse>,
                    response: Response<VideosResponse>
                ) {
                    if(response.code() in 200..299){
                        val body = response.body()
                        allMovies.postValue(body)
                        return
                    }
                    when(response.code()){
                        HttpURLConnection.HTTP_FORBIDDEN->{
                            failToGetAllMovies.postValue("Não autorizado.")
                            return
                        }
                        HttpURLConnection.HTTP_BAD_REQUEST->{
                            failToGetAllMovies.postValue("Parâmetro passado inválido.")
                            return
                        }
                        HttpURLConnection.HTTP_NOT_FOUND->{
                            failToGetAllMovies.postValue("Não encontrado.")
                            return
                        }
                        else->{
                            failToGetAllMovies.postValue("Infelizmente tivemos um problema.")
                            return
                        }
                    }

                }

                override fun onFailure(call: Call<VideosResponse>, t: Throwable) {
                    failToGetAllMovies.postValue("Erro ao se comunicar com a API")
                }
            }
        )
    }
}