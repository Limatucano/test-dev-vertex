package com.matheus.vertexapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class VideoResponse(
    val kind : String,
    val etag : String,
    val id : IdVideo,
    val snippet : Snippet
): Parcelable