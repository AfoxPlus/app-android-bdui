package com.afoxplus.bdui.domain.repository

import com.afoxplus.bdui.domain.entities.Screen
import com.afoxplus.uikit.common.ResultState

internal interface BDUIRepository {
    suspend fun getEstablishmentDetail(establishmentCode: String): ResultState<Screen>
}