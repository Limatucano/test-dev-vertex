package com.matheus.vertexapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DetailVideoResponse(
    val kind : String,
    val etag : String,
    val nextPageToken : String? = null,
    val items : List<Video>
) : Parcelable

@Parcelize
data class Video(
    val kind : String,
    val etag : String,
    val id : String,
    val snippet : Snippet,
    val statistics : StatisticVideo? = null,
): Parcelable