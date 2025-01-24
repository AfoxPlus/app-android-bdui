package com.afoxplus.bdui.delivery.models

import com.google.gson.annotations.SerializedName
import java.text.DecimalFormat

internal data class ProductModel(
    @SerializedName("productImageUrl") val imageUrl: String,
    @SerializedName("productName") val name: String,
    @SerializedName("productDescription") val description: String,
    @SerializedName("productCurrency") val currency: CurrencyModel,
    @SerializedName("productPrice") val price: Double
) {

    fun getPriceFormat(): String {
        val numberFormat = DecimalFormat("#,###.00")
        return "${currency.value} ${numberFormat.format(price)}"
    }


}