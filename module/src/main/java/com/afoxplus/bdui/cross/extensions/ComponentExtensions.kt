package com.afoxplus.bdui.cross.extensions

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.afoxplus.bdui.domain.entities.Component
import com.afoxplus.bdui.domain.entities.GridComponent
import com.afoxplus.bdui.domain.entities.IconComponent
import com.afoxplus.bdui.domain.entities.TextComponent
import com.afoxplus.uikit.designsystem.extensions.getUIKitColor
import com.afoxplus.uikit.designsystem.extensions.getUIKitIcon
import com.afoxplus.uikit.designsystem.extensions.getUIKitSpacing
import com.afoxplus.uikit.designsystem.extensions.getUIKitTypography
import com.afoxplus.uikit.designsystem.foundations.IconTheme
import com.afoxplus.uikit.designsystem.foundations.UIKitColorTheme
import com.afoxplus.uikit.designsystem.foundations.UIKitTheme
import com.afoxplus.uikit.designsystem.foundations.UIKitTypographyTheme

@Composable
fun TextComponent.getColorExpandableText(): Color {
    return this.colorExpandableText?.let { getUIKitColor(it) } ?: UIKitColorTheme.primaryColor
}

@Composable
fun TextComponent.getTypographyTokenExpandableText(): TextStyle {
    return this.typographyTokenExpandableText?.let { getUIKitTypography(it) }
        ?: UIKitTypographyTheme.paragraph01
}

@Composable
fun Component.getColor(): Color {
    return this.colorToken?.let { getUIKitColor(it) } ?: UIKitColorTheme.secondaryColor
}

@Composable
fun IconComponent.getIcon(): IconTheme.Icon {
    return getUIKitIcon(this.iconToken)
}


@Composable
fun Component.getTypography(): TextStyle {
    return this.typographyToken?.let { getUIKitTypography(it) } ?: UIKitTypographyTheme.paragraph01
}

@Composable
fun Component.getSpacingHorizontal(): Dp {
    return this.spacingHorizontal?.let { getUIKitSpacing(it) }
        ?: UIKitTheme.spacing.spacing12
}

@Composable
fun Component.getSpacingVertical(): Dp {
    return this.spacingVertical?.let { getUIKitSpacing(it) } ?: UIKitTheme.spacing.spacing12
}

@Composable
fun GridComponent.getSpacingBetweenComponents(): Dp {
    return this.spacingBetweenComponents?.let { getUIKitSpacing(it) }
        ?: UIKitTheme.spacing.spacing12
}

fun Component.getBackGroundToken(): String = this.backgroundToken ?: "gray100"
fun Component.getContentColorToken(): String = this.colorToken ?: "gray700"
fun TextComponent.getMaxLines(): Int = (this.maxLines ?: 1).toInt()