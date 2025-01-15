package com.afoxplus.bdui.data.repository

import com.afoxplus.bdui.data.sources.remote.BDUINetworkDataSource
import com.afoxplus.bdui.domain.entities.Component
import com.afoxplus.bdui.domain.repository.BDUIRepository
import com.afoxplus.uikit.common.ResultState
import javax.inject.Inject

internal class BDUIDataRepository @Inject constructor(private val bdUINetworkDataSource: BDUINetworkDataSource) :
    BDUIRepository {

    override suspend fun getEstablishmentDetail(establishmentCode: String): ResultState<List<Component>> =
        this.bdUINetworkDataSource.getEstablishmentDetail(establishmentCode)
}