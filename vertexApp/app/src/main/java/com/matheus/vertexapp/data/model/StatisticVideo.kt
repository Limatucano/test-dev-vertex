package com.matheus.vertexapp.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StatisticVideo(
    val viewCount : String,
    val favoriteCount : String,
    val commentCount : String,
): Parcelable