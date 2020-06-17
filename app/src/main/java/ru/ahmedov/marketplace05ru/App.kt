package ru.ahmedov.marketplace05ru

import android.app.Application
import moxy.MvpFacade
import ru.ahmedov.marketplace05ru.di.global.AppComponent
import ru.diitcenter.gooddeeds.di.global.DaggerAppComponent


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        MvpFacade.init()
        appComponent = buildAppComponent()

    }

    private fun buildAppComponent(): AppComponent =
        DaggerAppComponent.builder()
            .bindsInstanceContext(this)
            .build()

    companion object {
        lateinit var appComponent: AppComponent
    }
}