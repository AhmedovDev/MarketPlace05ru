package ru.ahmedov.marketplace05ru.di.global.modules

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import ru.diitcenter.gooddeeds.data.prefs.PrefsHelper
import javax.inject.Singleton

@Module
class PrefsModule {
    @Provides
    @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(context)

    @Provides
    @Singleton
    fun providePrefsHelper(sharedPrefs: SharedPreferences) =
        PrefsHelper(sharedPrefs)
}