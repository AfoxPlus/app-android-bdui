package com.afoxplus.bdui.data.sources.remote.model.response

import com.google.gson.annotations.SerializedName

internal data class ScreenResponse(
    @SerializedName("topBar") val topBar: ComponentResponse? = null,
    @SerializedName("content") val content: List<ComponentResponse>,
    @SerializedName("bottomBar") val bottomBar: ComponentResponse? = null
)