package com.santimattius.android.skeleton.di

import com.santimattius.android.skeleton.core.network.ServiceCreator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideServiceCreator() = ServiceCreator(baseUrl = "https://www.freetogame.com/api/")
}