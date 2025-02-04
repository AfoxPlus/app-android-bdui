package com.afoxplus.bdui.delivery.models

import com.google.gson.annotations.SerializedName

internal data class EstablishmentModel(
    @SerializedName("establishmentUrlBanner") val urlBanner: String,
    @SerializedName("establishmentUrlLogo") val urlLogo: String,
    @SerializedName("establishmentName") val name: String,
    @SerializedName("establishmentPrimaryType") val primaryType: String,
    @SerializedName("establishmentRating") val rating: Float,
    @SerializedName("establishmentUserRatingCount") val ratingCount: Long,
    @SerializedName("establishmentIsVerified") val isVerified: Boolean,
    @SerializedName("establishmentIsOpen") val isOpen: Boolean,
    @SerializedName("establishmenthasSubscription") val hasSubscription: Boolean
)