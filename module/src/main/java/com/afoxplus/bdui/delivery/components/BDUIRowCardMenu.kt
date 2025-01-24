package com.afoxplus.bdui.delivery.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.afoxplus.bdui.cross.extensions.toProductModel
import com.afoxplus.bdui.domain.entities.GridComponent
import com.afoxplus.uikit.designsystem.businesscomponents.UIKitProductItem
import com.afoxplus.uikit.designsystem.extensions.getUIKitSpacing
import com.afoxplus.uikit.designsystem.foundations.UIKitTheme

@Composable
fun BDUIRowCardMenu(modifier: Modifier = Modifier, gridComponent: GridComponent) {
    val spacingHorizontal =
        gridComponent.spacingHorizontal?.let { getUIKitSpacing(it) } ?: UIKitTheme.spacing.spacing12
    val spacingVertical =
        gridComponent.spacingVertical?.let { getUIKitSpacing(it) } ?: UIKitTheme.spacing.spacing12
    val spacingBetweenComponents =
        gridComponent.spacingBetweenComponents?.let { getUIKitSpacing(it) }
            ?: UIKitTheme.spacing.spacing12

    val scrollState = rememberScrollState()
    val data = gridComponent.items

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = spacingVertical)
            .horizontalScroll(scrollState),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(spacingBetweenComponents)
    ) {
        Spacer(modifier = Modifier.width(spacingHorizontal))
        data.forEach { cardComponent ->
            cardComponent.content?.toProductModel()?.let { product ->
                UIKitProductItem(
                    imageUrl = product.imageUrl,
                    title = product.name,
                    description = product.description,
                    price = product.getPriceFormat(),
                    onClick = {}
                )
            }
        }
        Spacer(modifier = Modifier.width(spacingHorizontal))
    }
}