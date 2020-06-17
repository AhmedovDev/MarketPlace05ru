package ru.ahmedov.marketplace05ru.ui.screens.home.mvp

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.ahmedov.marketplace05ru.data.global.models.home.HomeModel

@StateStrategyType(AddToEndSingleStrategy::class)
interface HomeView : MvpView {

    fun showHome(level: List<HomeModel>)
    fun showProgress(show: Boolean)
    fun showError(show: Boolean)

}