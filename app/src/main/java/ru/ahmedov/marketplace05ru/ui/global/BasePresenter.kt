package ru.ahmedov.marketplace05ru.ui.global

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import moxy.MvpPresenter
import moxy.MvpView
import ru.ahmedov.marketplace05ru.data.global.DataManager

open class BasePresenter<T : MvpView>( private val  dataManager: DataManager) : MvpPresenter<T>() {

    protected val subscriptions = CompositeDisposable()

    override fun onDestroy() {
        subscriptions.dispose()
        super.onDestroy()
    }

    protected fun Disposable.connect() = subscriptions.add(this)

}
