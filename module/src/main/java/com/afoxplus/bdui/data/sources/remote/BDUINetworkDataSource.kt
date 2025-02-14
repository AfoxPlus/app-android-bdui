package com.afoxplus.bdui.data.sources.remote

import com.afoxplus.bdui.cross.mapper.toComponent
import com.afoxplus.bdui.cross.mapper.toTextComponent
import com.afoxplus.bdui.data.sources.remote.api.BDUIApiNetwork
import com.afoxplus.bdui.domain.entities.Component
import com.afoxplus.bdui.domain.entities.Screen
import com.afoxplus.network.extensions.body
import com.afoxplus.uikit.common.ResultState
import javax.inject.Inject

internal class BDUINetworkDataSource @Inject constructor(private val bdUIApiNetwork: BDUIApiNetwork) {

    suspend fun getEstablishmentDetail(establishmentCode: String): ResultState<Screen> {
        val response = bdUIApiNetwork.getEstablishmentDetail(establishmentCode)
        val components = mutableListOf<Component>()
        var errorResult: ResultState<Screen>? = null
        var topBar: Component? = null
        var bottomBar: Component? = null

        response.body(onSuccess = { item ->
            topBar = item.payload.topBar?.toComponent()
            bottomBar = item.payload.bottomBar?.toTextComponent()
            val mapResult = item.payload.content.map { it.toComponent() }
            components.addAll(mapResult)
        }, onFailed = {
            errorResult = ResultState.Error(Exception("Failed on get establishment detail"))
        })
        return errorResult ?: ResultState.Success(
            Screen(
                topBar = topBar,
                bottomBar = bottomBar,
                content = components
            )
        )
    }
}