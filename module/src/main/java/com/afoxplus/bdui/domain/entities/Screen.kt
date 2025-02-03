package com.afoxplus.bdui.domain.entities

data class Screen(
    val topBar: Component?,
    val content: List<Component>,
    val bottomBar: Component? = null
)