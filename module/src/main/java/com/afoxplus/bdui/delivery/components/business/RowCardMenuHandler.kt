package com.afoxplus.bdui.delivery.components.business

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
import com.afoxplus.bdui.cross.extensions.getSpacingBetweenComponents
import com.afoxplus.bdui.cross.extensions.getSpacingHorizontal
import com.afoxplus.bdui.cross.extensions.getSpacingVertical
import com.afoxplus.bdui.cross.extensions.toModel
import com.afoxplus.bdui.delivery.models.ProductModel
import com.afoxplus.bdui.domain.entities.GridComponent
import com.afoxplus.uikit.designsystem.businesscomponents.UIKitProductItem

@Composable
fun RowCardMenuHandler(modifier: Modifier = Modifier, gridComponent: GridComponent) {
    val scrollState = rememberScrollState()
    val data = gridComponent.items

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = gridComponent.getSpacingVertical())
            .horizontalScroll(scrollState),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(gridComponent.getSpacingBetweenComponents())
    ) {
        Spacer(modifier = Modifier.width(gridComponent.getSpacingHorizontal()))
        data.forEach { cardComponent ->
            cardComponent.content?.toModel(ProductModel::class.java)?.let { product ->
                UIKitProductItem(
                    imageUrl = product.imageUrl,
                    title = product.name,
                    description = product.description,
                    price = product.getPriceFormat(),
                    onClick = {}
                )
            }
        }
        Spacer(modifier = Modifier.width(gridComponent.getSpacingHorizontal()))
    }
}