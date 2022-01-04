package com.matheus.vertexapp.view.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.matheus.vertexapp.R
import com.matheus.vertexapp.data.model.VideoResponse
import com.matheus.vertexapp.view.ResultFragment

class VideosAdapter(private val videos : List<VideoResponse>, var clickItemListener : OnClickItemListener) : RecyclerView.Adapter<VideosAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.videos_items,parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = videos[position]
        holder.initialize(item,clickItemListener,position)
    }

    override fun getItemCount(): Int = videos.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val thumbnailVideo = itemView.findViewById<ImageView>(R.id.thumbnail)
        val titleVideo = itemView.findViewById<TextView>(R.id.title)
        val descriptionVideo = itemView.findViewById<TextView>(R.id.description)
        val btnDetail = itemView.findViewById<TextView>(R.id.btnDetail)
        fun initialize(item: VideoResponse, action: OnClickItemListener, position: Int){
            setValuesToFields(item)
            btnDetail.setOnClickListener{
                Log.d("TESTE", "tteste")
                action.onItemClick(item, position)
            }

        }
        fun setValuesToFields(item : VideoResponse)  = item.snippet.apply{
            titleVideo.text = title
            descriptionVideo.text = description
            Glide.with(itemView.context).load(thumbnails.medium.url).into(thumbnailVideo)
        }

    }

    interface OnClickItemListener{
        fun onItemClick(item: VideoResponse, position: Int)
    }

}