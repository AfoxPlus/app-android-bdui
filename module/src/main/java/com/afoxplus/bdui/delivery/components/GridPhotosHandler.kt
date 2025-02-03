package com.afoxplus.bdui.delivery.components

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.afoxplus.bdui.cross.extensions.getSpacingHorizontal
import com.afoxplus.bdui.cross.extensions.getSpacingVertical
import com.afoxplus.bdui.cross.extensions.toModel
import com.afoxplus.bdui.delivery.models.PhotoModel
import com.afoxplus.bdui.domain.entities.GridComponent
import com.afoxplus.uikit.designsystem.molecules.UIKitItemVerticalPhotoGrid

@Composable
fun BDUIGridPhotos(gridComponent: GridComponent) {
    val dataComponent: List<String> =
        gridComponent.items.mapNotNull { item -> item.content?.toModel(PhotoModel::class.java)?.name }

    UIKitItemVerticalPhotoGrid(
        modifier = Modifier.padding(
            horizontal = gridComponent.getSpacingHorizontal(),
            vertical = gridComponent.getSpacingVertical()
        ),
        photos = dataComponent, onPhotoClick = {})
}