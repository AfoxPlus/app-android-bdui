package com.afoxplus.bdui.delivery.models

import com.google.gson.annotations.SerializedName

internal data class CurrencyModel(
    @SerializedName("code") val code: String,
    @SerializedName("value") val value: String
)