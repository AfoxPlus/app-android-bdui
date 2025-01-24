package com.afoxplus.bdui.delivery.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.afoxplus.bdui.domain.entities.ButtonComponent
import com.afoxplus.uikit.designsystem.atoms.UIKitButton
import com.afoxplus.uikit.designsystem.atoms.UIKitButtonType
import com.afoxplus.uikit.designsystem.extensions.getUIKitSpacing
import com.afoxplus.uikit.designsystem.foundations.UIKitTheme

@Composable
fun BDUIButton(buttonComponent: ButtonComponent) {
    val spacingHorizontal =
        buttonComponent.spacingHorizontal?.let { getUIKitSpacing(it) }
            ?: UIKitTheme.spacing.spacing12
    val spacingVertical =
        buttonComponent.spacingVertical?.let { getUIKitSpacing(it) } ?: UIKitTheme.spacing.spacing12
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
                horizontal = spacingHorizontal,
                vertical = spacingVertical
            ), type = uiKitButtonType, text = title
    ) { }
}