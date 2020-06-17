package ru.ahmedov.marketplace05ru.data.global

import io.reactivex.Single
import ru.ahmedov.marketplace05ru.data.global.models.global.SuccessModel
import ru.ahmedov.marketplace05ru.data.global.models.home.HomeModel


interface DataManager {
    fun getHome() : Single<SuccessModel<HomeModel>>
}