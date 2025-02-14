package com.afoxplus.bdui.delivery.components.business

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import com.afoxplus.bdui.cross.extensions.toModel
import com.afoxplus.bdui.delivery.models.EstablishmentModel
import com.afoxplus.bdui.domain.entities.CardComponent
import com.afoxplus.uikit.designsystem.atoms.UIKitIcon
import com.afoxplus.uikit.designsystem.foundations.UIKitColorTheme
import com.afoxplus.uikit.designsystem.foundations.UIKitIconTheme
import com.afoxplus.uikit.designsystem.foundations.UIKitTheme
import com.afoxplus.uikit.designsystem.organisms.UIKitCardEstablishment
import com.afoxplus.uikit.objects.vendor.Establishment

@Composable
fun TopEstablishmentHandler(cardComponent: CardComponent, onBack: () -> Unit) {
    cardComponent.content?.toModel(EstablishmentModel::class.java)?.let { establishment ->
        Box(modifier = Modifier) {
            UIKitCardEstablishment(
                shape = UIKitTheme.shapes.default,
                elevation = CardDefaults.cardElevation(defaultElevation = UIKitTheme.spacing.spacing00),
                establishment = Establishment(
                    primaryType = establishment.primaryType,
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
            BackButton(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(
                        start = UIKitTheme.spacing.spacing16,
                        top = UIKitTheme.spacing.spacing42
                    ),
                onClick = onBack
            )
        }
    }
}

@Composable
private fun BackButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Box(
        modifier = modifier
            .clickable { onClick() }
            .clip(RoundedCornerShape(UIKitTheme.spacing.spacing08))
            .background(
                UIKitColorTheme.light01.copy(alpha = 0.8f)
            )
    ) {
        UIKitIcon(
            modifier = Modifier.padding(UIKitTheme.spacing.spacing08),
            icon = UIKitIconTheme.icon_back
        )
    }

}