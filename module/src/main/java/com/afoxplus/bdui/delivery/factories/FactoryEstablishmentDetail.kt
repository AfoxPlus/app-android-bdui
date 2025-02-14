package com.afoxplus.bdui.delivery.factories

import androidx.compose.runtime.Composable
import com.afoxplus.bdui.delivery.components.BDUIButton
import com.afoxplus.bdui.delivery.components.BDUIExpandableText
import com.afoxplus.bdui.delivery.components.BDUIGridPhotos
import com.afoxplus.bdui.delivery.components.business.RowCardMenuHandler
import com.afoxplus.bdui.delivery.components.BDUISectionTitle
import com.afoxplus.bdui.delivery.components.RowIconTextHandler
import com.afoxplus.bdui.delivery.components.business.TopEstablishmentHandler
import com.afoxplus.bdui.domain.entities.ButtonComponent
import com.afoxplus.bdui.domain.entities.CardComponent
import com.afoxplus.bdui.domain.entities.Component
import com.afoxplus.bdui.domain.entities.GridComponent
import com.afoxplus.bdui.domain.entities.TextComponent
import com.afoxplus.uikit.designsystem.atoms.UIKitText

@Composable
fun FactoryEstablishmentDetail(
    component: Component,
    onClick: (deeplink: String) -> Unit
) {
    when (component.name) {
        "SECTION" -> BDUISectionTitle(cardComponent = component as CardComponent)
        "ROW_CARD_MENU" -> RowCardMenuHandler(
            gridComponent = component as GridComponent,
            onClick = onClick
        )

        "SEE_MORE_BUTTON" -> BDUIButton(
            buttonComponent = component as ButtonComponent,
            onClick = onClick
        )

        "EXPANDABLE_TEXT", "TEXT" -> BDUIExpandableText(textComponent = component as TextComponent)
        "GRID_PHOTOS" -> BDUIGridPhotos(gridComponent = component as GridComponent)
        "ROW_ICON_TEXT" -> RowIconTextHandler(gridComponent = component as GridComponent)
        else -> UIKitText(text = component.name)
    }
}

@Composable
fun FactoryTopBar(component: Component, onBack: () -> Unit) {
    when (component.name) {
        "TOP_ESTABLISHMENT_DETAIL" -> TopEstablishmentHandler(
            cardComponent = component as CardComponent,
            onBack = onBack
        )

        else -> UIKitText(text = component.name)
    }
}