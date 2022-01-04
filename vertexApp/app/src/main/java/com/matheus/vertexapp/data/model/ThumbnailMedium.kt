package com.matheus.vertexapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ThumbnailMedium(
    val url : String,
    val width : Int,
    val height : Int,
): Parcelable