package com.santimattius.android.skeleton.di

import com.santimattius.android.skeleton.core.network.ServiceCreator
import com.santimattius.android.skeleton.features.games.data.datasource.FreeToGameDataSource
import com.santimattius.android.skeleton.features.games.data.datasource.NetworkDataSource
import com.santimattius.android.skeleton.features.games.data.repositories.GameRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun provideNetworkDatasource(serviceCreator: ServiceCreator): NetworkDataSource {
        return FreeToGameDataSource(service = serviceCreator.create())
    }

    @Provides
    fun provideGameRepository(networkDataSource: NetworkDataSource) = GameRepository(
        networkDataSource = networkDataSource)
}