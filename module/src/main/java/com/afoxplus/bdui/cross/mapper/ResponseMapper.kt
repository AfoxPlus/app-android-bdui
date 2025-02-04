package com.afoxplus.bdui.cross.mapper

import com.afoxplus.bdui.data.sources.remote.model.response.ComponentResponse
import com.afoxplus.bdui.domain.entities.BorderStroke
import com.afoxplus.bdui.domain.entities.ButtonComponent
import com.afoxplus.bdui.domain.entities.CardComponent
import com.afoxplus.bdui.domain.entities.Component
import com.afoxplus.bdui.domain.entities.ComponentGridType
import com.afoxplus.bdui.domain.entities.ComponentType
import com.afoxplus.bdui.domain.entities.EmptyComponent
import com.afoxplus.bdui.domain.entities.GridComponent
import com.afoxplus.bdui.domain.entities.IconComponent
import com.afoxplus.bdui.domain.entities.PaddingValues
import com.afoxplus.bdui.domain.entities.TextComponent


internal fun ComponentResponse.toTextComponent(): TextComponent {
    return TextComponent(
        colorExpandableText = this.colorExpandableText,
        typographyTokenExpandableText = this.typographyTokenExpandableText,
        maxLines = this.maxLines,
        textAlign = this.textAlign,
        type = ComponentType.TEXT,
        id = this.id,
        name = this.name,
        spacingHorizontal = this.spacingHorizontal,
        spacingVertical = this.spacingVertical,
        backgroundToken = this.backgroundToken,
        colorToken = this.colorToken,
        typographyToken = this.typographyToken,
        content = this.content
    )
}

internal fun ComponentResponse.toButtonComponent(): ButtonComponent {
    return ButtonComponent(
        style = this.style.orEmpty(),
        borderStroke = BorderStroke(
            with = this.borderStroke?.with,
            color = this.borderStroke?.color
        ),
        shape = this.shape,
        paddingValues = PaddingValues(
            horizontal = this.paddingValues?.horizontal,
            vertical = this.paddingValues?.vertical
        ),
        state = this.state,
        type = ComponentType.BUTTON,
        id = this.id,
        name = this.name,
        spacingHorizontal = this.spacingHorizontal,
        spacingVertical = this.spacingVertical,
        backgroundToken = this.backgroundToken,
        colorToken = this.colorToken,
        typographyToken = this.typographyToken,
        content = this.content,
        deeplink = this.deeplink.orEmpty(),
        children = this.children?.map { it.toComponent() }
    )
}

internal fun ComponentResponse.toIconComponent(): IconComponent {
    return IconComponent(
        id = this.id,
        name = this.name,
        iconToken = this.iconToken.orEmpty(),
        size = this.size.orEmpty(),
        hintToken = this.hintToken.orEmpty(),
        type = ComponentType.ICON,
        spacingHorizontal = this.spacingHorizontal,
        spacingVertical = this.spacingVertical,
        backgroundToken = this.backgroundToken,
        colorToken = this.colorToken,
        typographyToken = this.typographyToken,
        content = this.content,
        children = this.children?.map { it.toComponent() }
    )
}

internal fun ComponentResponse.toCardComponent(): CardComponent {
    return CardComponent(
        elevation = this.elevation.orEmpty(),
        border = this.border.orEmpty(),
        stroke = this.stroke.orEmpty(),
        type = ComponentType.CARD,
        id = this.id,
        name = this.name,
        spacingHorizontal = this.spacingHorizontal,
        spacingVertical = this.spacingVertical,
        backgroundToken = this.backgroundToken,
        colorToken = this.colorToken,
        typographyToken = this.typographyToken,
        content = this.content,
        deeplink = this.deeplink.orEmpty(),
        children = this.children?.map { it.toComponent() }
    )
}

internal fun ComponentResponse.toGridComponent(): GridComponent {
    return GridComponent(
        spacingBetweenComponents = this.spacingBetweenComponents,
        gridType = this.gridType?.let { ComponentGridType.valueOf(it) } ?: ComponentGridType.COLUMN,
        gridSize = this.gridSize ?: 1,
        items = this.items?.map { item -> item.toCardComponent() } ?: emptyList(),
        id = this.id,
        name = this.name,
        type = ComponentType.GRID,
        spacingHorizontal = this.spacingHorizontal,
        spacingVertical = this.spacingVertical,
        backgroundToken = this.backgroundToken,
        colorToken = this.colorToken,
        typographyToken = this.typographyToken,
        content = this.content,
        children = this.children?.map { it.toComponent() }
    )
}

internal fun ComponentResponse.toComponent(): Component {
    return when (this.type) {
        ComponentType.ICON.name -> this.toIconComponent()
        ComponentType.GRID.name -> this.toGridComponent()
        ComponentType.CARD.name -> this.toCardComponent()
        ComponentType.BUTTON.name -> this.toButtonComponent()
        ComponentType.TEXT.name -> this.toTextComponent()
        else -> EmptyComponent(
            id = this.id,
            name = this.name,
            type = ComponentType.EMPTY,
            spacingHorizontal = this.spacingHorizontal,
            spacingVertical = this.spacingVertical,
            backgroundToken = this.backgroundToken,
            colorToken = this.colorToken,
            typographyToken = this.typographyToken,
            content = this.content
        )
    }
}