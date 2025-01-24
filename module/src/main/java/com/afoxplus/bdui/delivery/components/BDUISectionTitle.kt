package com.afoxplus.bdui.delivery.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.afoxplus.bdui.domain.entities.CardComponent
import com.afoxplus.bdui.domain.entities.IconComponent
import com.afoxplus.uikit.designsystem.businesscomponents.UIKitSectionTitle

@Composable
internal fun BDUISectionTitle(modifier: Modifier = Modifier, cardComponent: CardComponent) {
    cardComponent.children?.let {
        val iconComponent: IconComponent = it.first() as IconComponent
        val title = cardComponent.content?.get("title").toString()
        val backGroundToken = cardComponent.backgroundToken ?: ""
        val contentColorToken = cardComponent.colorToken ?: ""
        UIKitSectionTitle(
            modifier = modifier.fillMaxWidth(),
            title = title,
            iconToken = iconComponent.iconToken,
            backgroundToken = backGroundToken,
            contentColorToken = contentColorToken
        )
    }
}