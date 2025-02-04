package com.afoxplus.bdui.delivery.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.afoxplus.bdui.cross.extensions.getSpacingHorizontal
import com.afoxplus.bdui.cross.extensions.getSpacingVertical
import com.afoxplus.bdui.domain.entities.ButtonComponent
import com.afoxplus.uikit.designsystem.atoms.UIKitButton
import com.afoxplus.uikit.designsystem.atoms.UIKitButtonType

@Composable
fun BDUIButton(buttonComponent: ButtonComponent, onClick: (deeplink: String) -> Unit) {
    val title = buttonComponent.content?.get("title").toString()
    val uiKitButtonType = when (buttonComponent.style) {
        "FilledLarge" -> UIKitButtonType.FilledLarge()
        "FilledSmall" -> UIKitButtonType.FilledSmall()
        "FilledMedium" -> UIKitButtonType.FilledMedium()
        "OutlineLarge" -> UIKitButtonType.OutlineLarge()
        "OutlineSmall" -> UIKitButtonType.OutlineSmall()
        "OutlineMedium" -> UIKitButtonType.OutlineMedium()
        else -> UIKitButtonType.OutlineLarge()
    }

    UIKitButton(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = buttonComponent.getSpacingHorizontal(),
                vertical = buttonComponent.getSpacingVertical()
            ), type = uiKitButtonType, text = title,
        onClick = { onClick(buttonComponent.deeplink.orEmpty()) }
    )
}