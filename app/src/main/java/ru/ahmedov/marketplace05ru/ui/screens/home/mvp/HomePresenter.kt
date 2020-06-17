package ru.ahmedov.marketplace05ru.ui.screens.home.mvp

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import ru.ahmedov.marketplace05ru.data.global.DataManager
import ru.ahmedov.marketplace05ru.ui.global.BasePresenter
import javax.inject.Inject

@InjectViewState
class HomePresenter
@Inject constructor(
    private val dataManager: DataManager
) : BasePresenter<HomeView>(dataManager) {


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        getHomeData()
    }


    fun getHomeData() {
        subscriptions += dataManager.getHome()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { viewState.showProgress(true) }
            .doAfterTerminate { viewState.showProgress(false) }
            .subscribe(
                { data ->
                    viewState.showHome(data.result!!)
                },
                {
                    viewState.showError(true)
                }
            )
    }


}