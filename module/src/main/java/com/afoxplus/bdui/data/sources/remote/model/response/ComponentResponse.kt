package com.afoxplus.bdui.data.sources.remote.model.response

import com.google.gson.annotations.SerializedName

internal data class ComponentResponse(
    @SerializedName("id") val id: String,
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
    @SerializedName("hintToken") val hintToken: String? = null,

    //Button
    @SerializedName("style") val style: String? = null,
    @SerializedName("borderStroke") val borderStroke: BorderStrokeResponse? = null,
    @SerializedName("shape") val shape: String? = null,
    @SerializedName("contentPadding") val paddingValues: PaddingValuesResponse? = null,
    @SerializedName("state") val state: String? = null,
    @SerializedName("action") val action: String? = null,

    //Text
    @SerializedName("colorExpandableText") val colorExpandableText: String? = null,
    @SerializedName("typographyTokenExpandableText") val typographyTokenExpandableText: String? = null,
    @SerializedName("maxLines") val maxLines: Number? = null,
    @SerializedName("textAlign") val textAlign: String? = null
)

internal data class BorderStrokeResponse(
    @SerializedName("with") val with: String? = null,
    @SerializedName("color") val color: String? = null
)

internal data class PaddingValuesResponse(
    @SerializedName("vertical") val vertical: String? = null,
    @SerializedName("horizontal") val horizontal: String? = null
)