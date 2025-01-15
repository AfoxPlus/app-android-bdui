package com.afoxplus.bdui.domain.entities

data class GridComponent(
    val spacingBetweenComponents: String?,
    val gridType: ComponentGridType,
    val gridSize: Number,
    val items: List<CardComponent>,
    override val name: String,
    override val type: ComponentType,
    override val spacingHorizontal: String? = null,
    override val spacingVertical: String? = null,
    override val backgroundToken: String? = null,
    override val colorToken: String? = null,
    override val typographyToken: String? = null,
    override val content: Map<String, Any>? = null,
    override val children: List<Component>? = null
) : Component(
    name,
    type,
    spacingHorizontal,
    spacingVertical,
    backgroundToken,
    colorToken,
    typographyToken,
    content,
    children
)