package ru.ahmedov.marketplace05ru.di.global.modules

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.ahmedov.marketplace05ru.BuildConfig
import ru.ahmedov.marketplace05ru.data.global.TokenInterceptor
import ru.diitcenter.gooddeeds.data.network.Api
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.BASIC
            }
        }

//    @Provides
//    @Singleton
//    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor, tokenInterceptor: TokenInterceptor): OkHttpClient =
//        OkHttpClient.Builder()
//            .addInterceptor(loggingInterceptor)
//            .addInterceptor(tokenInterceptor)
//            .build()

        @Provides
    @Singleton
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor, tokenInterceptor: TokenInterceptor): OkHttpClient =
            OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(tokenInterceptor)
                .build()


    @Provides
    @Singleton
    @Named("MAIN_RETROFIT")
    fun provideMainRetrofit(client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_API_05_RU)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    @Named("BASE_API_URL_05_RU")
    fun provideBaseUrlGoodDeeds() = BASE_API_05_RU



    @Provides
    @Singleton
    fun provideRxJavaAdapter(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Provides
    @Singleton
    @Named("API_05_RU")
    fun provideGoodDeedsApi(@Named("MAIN_RETROFIT") retrofit: Retrofit) =
        retrofit.create(Api::class.java)

    companion object {

        private const val BASE_API_05_RU= "https://test.05.ru"


    }
}