package com.afoxplus.bdui.domain.repository

import com.afoxplus.bdui.domain.entities.Component
import com.afoxplus.uikit.common.ResultState

internal interface BDUIRepository {
    suspend fun getEstablishmentDetail(establishmentCode: String): ResultState<List<Component>>
}