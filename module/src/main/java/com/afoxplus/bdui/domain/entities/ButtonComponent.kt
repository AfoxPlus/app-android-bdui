package com.afoxplus.bdui.domain.entities


data class ButtonComponent(
    val style: String,
    val borderStroke: BorderStroke? = null,
    val shape: String? = null,
    val paddingValues: PaddingValues? = null,
    val state: String? = null,
    val action: String? = null,
    override val id: String,
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
    id,
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