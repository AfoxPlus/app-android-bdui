package com.afoxplus.bdui.di

import com.afoxplus.bdui.data.repository.BDUIDataRepository
import com.afoxplus.bdui.domain.repository.BDUIRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface BDUIModule {
    @Binds
    fun bindBDUIRepository(bdUIDataRepository: BDUIDataRepository): BDUIRepository
}