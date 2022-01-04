package com.matheus.vertexapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Snippet(
    val publishedAt : String,
    val channelId : String,
    val title : String,
    val description : String,
    val thumbnails : Thumbnails,
): Parcelable