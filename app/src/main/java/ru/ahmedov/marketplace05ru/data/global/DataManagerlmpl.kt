package ru.ahmedov.marketplace05ru.data.global


import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import ru.ahmedov.marketplace05ru.data.global.models.global.SuccessModel
import ru.ahmedov.marketplace05ru.data.global.models.home.HomeModel
import ru.ahmedov.marketplace05ru.data.global.DataManager
import ru.diitcenter.gooddeeds.data.network.Api
import javax.inject.Inject
import javax.inject.Named

class DataManagerlmpl @Inject constructor(
    @Named("API_05_RU") val api: Api
) : DataManager {
    override fun getHome(): Single<SuccessModel<HomeModel>> =
            api.getHome()
                .subscribeOn(Schedulers.io())

}
