package com.afoxplus.bdui.delivery.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.afoxplus.bdui.cross.extensions.getColor
import com.afoxplus.bdui.cross.extensions.getColorExpandableText
import com.afoxplus.bdui.cross.extensions.getMaxLines
import com.afoxplus.bdui.cross.extensions.getSpacingHorizontal
import com.afoxplus.bdui.cross.extensions.getSpacingVertical
import com.afoxplus.bdui.cross.extensions.getTypography
import com.afoxplus.bdui.cross.extensions.getTypographyTokenExpandableText
import com.afoxplus.bdui.domain.entities.TextComponent
import com.afoxplus.uikit.designsystem.atoms.UIKitText

@Composable
fun BDUIExpandableText(modifier: Modifier = Modifier, textComponent: TextComponent) {
    val text = textComponent.content?.get("text").toString()
    UIKitText(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = textComponent.getSpacingHorizontal(),
                vertical = textComponent.getSpacingVertical()
            ),
        text = text,
        color = textComponent.getColor(),
        style = textComponent.getTypography(),
        colorExpandableText = textComponent.getColorExpandableText(),
        styleExpandableText = textComponent.getTypographyTokenExpandableText(),
        maxLines = textComponent.getMaxLines()
    )
}