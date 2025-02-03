package com.afoxplus.bdui.domain.usecases

import com.afoxplus.bdui.domain.entities.Screen
import com.afoxplus.bdui.domain.repository.BDUIRepository
import com.afoxplus.uikit.common.ResultState
import javax.inject.Inject

internal class GetEstablishmentDetail @Inject constructor(private val bdUIRepository: BDUIRepository) {

    suspend operator fun invoke(establishmentCode: String): ResultState<Screen> =
        this.bdUIRepository.getEstablishmentDetail(establishmentCode)
}