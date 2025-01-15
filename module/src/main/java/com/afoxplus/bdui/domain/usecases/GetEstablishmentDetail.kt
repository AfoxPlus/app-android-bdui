package com.afoxplus.bdui.domain.usecases

import com.afoxplus.bdui.domain.entities.Component
import com.afoxplus.bdui.domain.repository.BDUIRepository
import com.afoxplus.uikit.common.ResultState
import javax.inject.Inject

internal class GetEstablishmentDetail @Inject constructor(private val bdUIRepository: BDUIRepository) {

    suspend operator fun invoke(establishmentCode: String): ResultState<List<Component>> =
        this.bdUIRepository.getEstablishmentDetail(establishmentCode)
}