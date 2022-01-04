package com.matheus.vertexapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class IdVideo(
    val kind : String,
    val videoId : String,
): Parcelable