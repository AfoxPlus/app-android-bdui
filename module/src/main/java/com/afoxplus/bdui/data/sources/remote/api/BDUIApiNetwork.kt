package com.afoxplus.bdui.data.sources.remote.api

import com.afoxplus.bdui.data.sources.remote.model.response.ComponentResponse
import com.afoxplus.network.annotations.ServiceClient
import com.afoxplus.network.api.UrlProvider
import com.afoxplus.network.response.BaseResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

@ServiceClient(type = UrlProvider.Type.AWS_BACKEND_DRIVEN_UI)
internal interface BDUIApiNetwork {

    companion object {
        const val PATH_BDUI = "bdui"
        const val PATH_ESTABLISHMENT_DETAIL = "establishment"
    }

    @GET("$PATH_BDUI/$PATH_ESTABLISHMENT_DETAIL/{code}")
    suspend fun getEstablishmentDetail(@Path("code") establishmentCode: String): Response<BaseResponse<List<ComponentResponse>>>
}