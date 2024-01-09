package com.example.mandiriapps.module

import android.content.Context
import android.content.SharedPreferences
import com.e.mandiriapps.helper.SharedPref
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlin.text.Typography.dagger

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferenceModule {

    private const val SHARED_PREF = "shared_pref"

    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context) =
        context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE)

    @Provides
    fun provideSharedPrefHelper(sharedPref: SharedPreferences) =
        SharedPref(sharedPref)
}