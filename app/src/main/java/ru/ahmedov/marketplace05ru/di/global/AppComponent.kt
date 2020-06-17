package ru.ahmedov.marketplace05ru.di.global

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.ahmedov.marketplace05ru.di.global.modules.DataModule
import ru.ahmedov.marketplace05ru.di.global.modules.NetworkModule
import ru.ahmedov.marketplace05ru.di.global.modules.PrefsModule
import ru.ahmedov.marketplace05ru.di.screens.home.HomeComponent

import javax.inject.Singleton

@Component(
    modules = [
        NetworkModule::class,
        PrefsModule::class,
        DataModule::class
    ]
)
@Singleton
interface AppComponent {

    fun homeComponentBuilder(): HomeComponent.Builder


    @Component.Builder
    interface Builder {

        fun build(): AppComponent

        @BindsInstance
        fun bindsInstanceContext(context: Context): Builder
    }
}