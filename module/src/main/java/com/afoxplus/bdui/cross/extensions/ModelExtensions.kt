package com.afoxplus.bdui.cross.extensions

import com.google.gson.Gson

internal fun <T> Map<String, Any>.toModel(classOf: Class<T>): T {
    val gson = Gson()
    val json = gson.toJson(this)
    return gson.fromJson(json, classOf)
}