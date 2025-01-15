package com.afoxplus.bdui.data.sources.remote

import com.afoxplus.bdui.cross.mapper.toComponent
import com.afoxplus.bdui.data.sources.remote.api.BDUIApiNetwork
import com.afoxplus.bdui.domain.entities.Component
import com.afoxplus.network.extensions.body
import com.afoxplus.uikit.common.ResultState
import javax.inject.Inject

internal class BDUINetworkDataSource @Inject constructor(private val bdUIApiNetwork: BDUIApiNetwork) {

    suspend fun getEstablishmentDetail(establishmentCode: String): ResultState<List<Component>> {
        val response = bdUIApiNetwork.getEstablishmentDetail(establishmentCode)
        val components = mutableListOf<Component>()
        var errorResult: ResultState<List<Component>>? = null
        response.body(onSuccess = { items ->
            val mapResult = items.payload.map { item -> item.toComponent() }
            components.addAll(mapResult)
        }, onFailed = {
            errorResult = ResultState.Error(Exception("Failed on get establishment detail"))
        })
        return errorResult ?: ResultState.Success(components)
    }
}