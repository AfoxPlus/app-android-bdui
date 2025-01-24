package com.afoxplus.bdui.cross.extensions

import com.afoxplus.bdui.delivery.models.CurrencyModel
import com.afoxplus.bdui.delivery.models.ProductModel
import com.google.gson.Gson

internal fun Map<String, Any>.toCurrencyModel(): CurrencyModel {
    val gson = Gson()
    val json = gson.toJson(this)
    return gson.fromJson(json, CurrencyModel::class.java)
}

internal fun Map<String, Any>.toProductModel(): ProductModel {
    val gson = Gson()
    val json = gson.toJson(this)
    return gson.fromJson(json, ProductModel::class.java)
}