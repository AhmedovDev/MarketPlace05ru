package ru.ahmedov.marketplace05ru.di.screens.home

import dagger.Subcomponent
import ru.ahmedov.marketplace05ru.ui.screens.home.ui.HomeFragment

@HomeSccope
@Subcomponent(modules = [HomeModule::class])
interface HomeComponent {

    fun inject(homeFragment: HomeFragment)

    @Subcomponent.Builder
    interface Builder {
        fun build(): HomeComponent
    }
}