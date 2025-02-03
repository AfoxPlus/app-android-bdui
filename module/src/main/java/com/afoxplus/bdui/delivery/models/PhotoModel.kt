package com.afoxplus.bdui.delivery.models

import com.google.gson.annotations.SerializedName

internal data class PhotoModel(
    @SerializedName("name") val name: String,
    @SerializedName("heightPx") val heightPx: String,
    @SerializedName("widthPx") val widthPx: String
)