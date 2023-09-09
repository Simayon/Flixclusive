package com.flixclusive.di

import android.content.Context
import androidx.datastore.core.DataStore
import com.flixclusive.appSettingsDataStore
import com.flixclusive.data.api.GithubConfigService
import com.flixclusive.data.config.ConfigurationProviderImpl
import com.flixclusive.domain.config.ConfigurationProvider
import com.flixclusive.domain.preferences.AppSettings
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppSettingsModule {

    @Provides
    @Singleton
    fun provideDataStore(
        @ApplicationContext context: Context
    ): DataStore<AppSettings> =
        context.appSettingsDataStore


    @Provides
    @Singleton
    fun providesConfigurationProvider(
        githubConfigService: GithubConfigService,
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): ConfigurationProvider = ConfigurationProviderImpl(
        githubConfigService = githubConfigService,
        ioScope = CoroutineScope(ioDispatcher)
    )
}