package com.afoxplus.bdui.domain.entities

sealed class Component(
    open val name: String,
    open val type: ComponentType,
    open val spacingHorizontal: String?,
    open val spacingVertical: String?,
    open val backgroundToken: String?,
    open val colorToken: String?,
    open val typographyToken: String?,
    open val content: Map<String, Any>?,
    open val children: List<Component>?
)