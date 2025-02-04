package com.afoxplus.bdui.delivery.components.business

import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.afoxplus.bdui.cross.extensions.toModel
import com.afoxplus.bdui.delivery.models.EstablishmentModel
import com.afoxplus.bdui.domain.entities.CardComponent
import com.afoxplus.uikit.designsystem.foundations.UIKitTheme
import com.afoxplus.uikit.designsystem.organisms.UIKitCardEstablishment
import com.afoxplus.uikit.objects.vendor.Establishment

@Composable
fun TopEstablishmentHandler(cardComponent: CardComponent) {
    cardComponent.content?.toModel(EstablishmentModel::class.java)?.let { establishment ->
        UIKitCardEstablishment(
            shape = UIKitTheme.shapes.default,
            elevation = CardDefaults.cardElevation(defaultElevation = UIKitTheme.spacing.spacing00),
            establishment = Establishment(
                imageLandscape = establishment.urlBanner,
                imagePortrait = establishment.urlLogo,
                name = establishment.name,
                description = establishment.primaryType,
                hasSubscription = establishment.hasSubscription,
                isOpen = establishment.isOpen,
                rating = establishment.rating,
                addressDescription = "",
                phoneDescription = ""
            ),
            context = LocalContext.current
        ) {}
    }
}