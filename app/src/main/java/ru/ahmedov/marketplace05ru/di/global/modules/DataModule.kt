package ru.ahmedov.marketplace05ru.di.global.modules

import dagger.Binds
import dagger.Module
import ru.ahmedov.marketplace05ru.data.global.DataManager
import ru.ahmedov.marketplace05ru.data.global.DataManagerlmpl
import javax.inject.Singleton

@Module
interface DataModule {
    @Binds
    @Singleton
    fun provideDataManager(dataManager: DataManagerlmpl) : DataManager
}