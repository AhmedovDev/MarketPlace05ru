package ru.diitcenter.gooddeeds.data.network

import io.reactivex.Completable
import io.reactivex.Single
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*
import ru.ahmedov.marketplace05ru.data.global.models.global.SuccessModel
import ru.ahmedov.marketplace05ru.data.global.models.home.HomeModel

interface Api {

    @GET("/api/v1/snippets/main")
    fun getHome(
    ): Single<SuccessModel<HomeModel>>

}