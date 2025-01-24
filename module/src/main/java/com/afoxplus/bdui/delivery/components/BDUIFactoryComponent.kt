package com.afoxplus.bdui.delivery.components

import androidx.compose.runtime.Composable
import com.afoxplus.bdui.domain.entities.ButtonComponent
import com.afoxplus.bdui.domain.entities.CardComponent
import com.afoxplus.bdui.domain.entities.Component
import com.afoxplus.bdui.domain.entities.GridComponent
import com.afoxplus.uikit.designsystem.atoms.UIKitText

@Composable
fun BDUIFactoryComponent(component: Component) {
    when (component.name) {
        "SECTION" -> BDUISectionTitle(cardComponent = component as CardComponent)
        "ROW_CARD_MENU" -> BDUIRowCardMenu(gridComponent = component as GridComponent)
        "BUTTON_SEE_MENU" -> BDUIButton(buttonComponent = component as ButtonComponent)
        else -> UIKitText(text = component.name)
    }
}