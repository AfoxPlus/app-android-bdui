package com.afoxplus.bdui.di

import com.afoxplus.bdui.data.sources.remote.api.BDUIApiNetwork
import com.afoxplus.network.api.RetrofitGenerator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object BDUIApiNetworkModule {
    @Provides
    fun providerBDUIService(
        retrofitGenerator: RetrofitGenerator
    ): BDUIApiNetwork = retrofitGenerator.createRetrofit(BDUIApiNetwork::class.java)
}