package com.matheus.vertexapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class VideosResponse(
    val kind : String,
    val etag : String,
    val nextPageToken : String? = null,
    val items : List<VideoResponse>
) : Parcelable

