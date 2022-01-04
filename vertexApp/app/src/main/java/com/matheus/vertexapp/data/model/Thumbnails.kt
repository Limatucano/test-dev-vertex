package com.matheus.vertexapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Thumbnails(
    val default : ThumbnailDefault,
    val medium : ThumbnailMedium,
    val high : ThumbnailHigh,
): Parcelable