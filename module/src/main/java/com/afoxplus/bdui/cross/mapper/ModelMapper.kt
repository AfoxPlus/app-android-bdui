package com.afoxplus.bdui.cross.mapper

import com.afoxplus.bdui.data.sources.remote.model.response.ComponentResponse
import com.afoxplus.bdui.domain.entities.CardComponent
import com.afoxplus.bdui.domain.entities.Component
import com.afoxplus.bdui.domain.entities.ComponentGridType
import com.afoxplus.bdui.domain.entities.ComponentType
import com.afoxplus.bdui.domain.entities.EmptyComponent
import com.afoxplus.bdui.domain.entities.GridComponent
import com.afoxplus.bdui.domain.entities.IconComponent

internal fun ComponentResponse.toIconComponent(): IconComponent {
    return IconComponent(
        name = this.name,
        iconToken = this.iconToken ?: "",
        size = this.size ?: "",
        hintToken = this.hintToken ?: "",
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
        elevation = this.elevation ?: "",
        border = this.border ?: "",
        stroke = this.stroke ?: "",
        type = ComponentType.CARD,
        name = this.name,
        spacingHorizontal = this.spacingHorizontal,
        spacingVertical = this.spacingVertical,
        backgroundToken = this.backgroundToken,
        colorToken = this.colorToken,
        typographyToken = this.typographyToken,
        content = this.content,
        children = this.children?.map { it.toComponent() }
    )
}

internal fun ComponentResponse.toGridComponent(): GridComponent {
    return GridComponent(
        spacingBetweenComponents = this.spacingBetweenComponents,
        gridType = this.gridType?.let { ComponentGridType.valueOf(it) } ?: ComponentGridType.COLUMN,
        gridSize = this.gridSize ?: 1,
        items = this.items?.map { item -> item.toCardComponent() } ?: emptyList(),
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
        else -> EmptyComponent(
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