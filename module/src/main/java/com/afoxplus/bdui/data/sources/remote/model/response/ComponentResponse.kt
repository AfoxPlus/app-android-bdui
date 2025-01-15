package com.afoxplus.bdui.data.sources.remote.model.response

import com.google.gson.annotations.SerializedName

internal data class ComponentResponse(
    @SerializedName("name") val name: String,
    @SerializedName("type") val type: String,
    @SerializedName("spacingHorizontal") val spacingHorizontal: String? = null,
    @SerializedName("spacingVertical") val spacingVertical: String? = null,
    @SerializedName("backgroundToken") val backgroundToken: String? = null,
    @SerializedName("colorToken") val colorToken: String? = null,
    @SerializedName("typographyToken") val typographyToken: String? = null,
    @SerializedName("content") val content: Map<String, Any>? = null,
    @SerializedName("children") val children: List<ComponentResponse>? = null,
    //Grid
    @SerializedName("spacingBetweenComponents") val spacingBetweenComponents: String? = null,
    @SerializedName("gridType") val gridType: String? = null,
    @SerializedName("gridSize") val gridSize: Number? = null,
    @SerializedName("items") val items: List<ComponentResponse>? = null,
    //Card
    @SerializedName("elevation") val elevation: String? = null,
    @SerializedName("border") val border: String? = null,
    @SerializedName("stroke") val stroke: String? = null,
    //Icon
    @SerializedName("iconToken") val iconToken: String? = null,
    @SerializedName("size") val size: String? = null,
    @SerializedName("hintToken") val hintToken: String? = null
)