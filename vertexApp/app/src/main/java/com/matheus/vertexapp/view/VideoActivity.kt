package com.matheus.vertexapp.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.*
import androidx.navigation.Navigation
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView
import com.matheus.vertexapp.BuildConfig
import com.matheus.vertexapp.R
import com.matheus.vertexapp.data.model.DetailVideoResponse
import com.matheus.vertexapp.data.model.VideoResponse
import com.matheus.vertexapp.data.model.VideosResponse
import com.matheus.vertexapp.data.repository.VideoRespository
import com.matheus.vertexapp.databinding.ActivityVideoBinding
import com.matheus.vertexapp.viewmodel.VideoViewModel
import com.matheus.vertexapp.viewmodel.VideoViewModelFactory

class VideoActivity : YouTubeBaseActivity() , YouTubePlayer.OnInitializedListener {
    private lateinit var player: YouTubePlayerView
    private var videoItem : DetailVideoResponse? = null
    private lateinit var viewBinding : ActivityVideoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityVideoBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        player = findViewById<YouTubePlayerView>(R.id.youtubePlayer)

        player.initialize(BuildConfig.API_KEY,this)
        val bundle = intent.extras
        if (bundle == null) {
            Log.e("Bundle", "Erro ao transferir dados")
            return
        }
        val args = VideoActivityArgs.fromBundle(bundle)
        videoItem = args.videoItem

        viewBinding.btnBack.setOnClickListener {
            onBackPressed()
        }
        viewBinding.title.text = videoItem!!.items.get(0).snippet.title
        viewBinding.description.text = videoItem!!.items.get(0).snippet.description
        viewBinding.visualization.text = videoItem!!.items.get(0).statistics?.viewCount



    }

    override fun onInitializationSuccess(
        provider: YouTubePlayer.Provider?,
        player: YouTubePlayer?,
        wasRestored: Boolean
    ) {
        if (!wasRestored) {
            player?.cueVideo(videoItem?.items?.get(0)?.id);
        }
    }

    override fun onInitializationFailure(
        provider: YouTubePlayer.Provider?,
        result: YouTubeInitializationResult?
    ) {
        Log.d("TESTE",result.toString())
    }

}