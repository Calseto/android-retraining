package com.example.mandiriapps.module

import android.content.Context
import android.content.SharedPreferences
import com.e.mandiriapps.data.sharedpref.local.SharedPrefDataSource
import com.e.mandiriapps.data.sharedpref.local.impl.SharedPrefDataSourceImpl
import com.e.mandiriapps.data.sharedpref.repo.SharedPrefRepo
import com.e.mandiriapps.data.sharedpref.repo.impl.SharedPrefRepoImpl
import com.e.mandiriapps.data.sharedpref.usecase.GetTokenUseCase
import com.e.mandiriapps.data.sharedpref.usecase.SaveToken
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferenceModule {

    private const val SHARED_PREF = "TOKEN_KEY"

    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideSharedPrefDataSource(sharedPreferences: SharedPreferences): SharedPrefDataSource {
        return SharedPrefDataSourceImpl(sharedPreferences)
    }
    @Singleton
    @Provides
    fun provideMyRepository(sharedPrefDataSource: SharedPrefDataSource): SharedPrefRepo {
        return SharedPrefRepoImpl(sharedPrefDataSource)
    }

    @Singleton
    @Provides
    fun provideGetToken(sharedPrefRepo: SharedPrefRepo): GetTokenUseCase {
        return GetTokenUseCase(sharedPrefRepo)
    }
    @Singleton
    @Provides
    fun provideSaveToken(sharedPrefRepo: SharedPrefRepo): SaveToken {
        return SaveToken(sharedPrefRepo)
    }

}