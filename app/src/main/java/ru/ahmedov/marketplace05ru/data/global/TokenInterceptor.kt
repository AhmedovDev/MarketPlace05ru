package ru.ahmedov.marketplace05ru.data.global

import ru.diitcenter.gooddeeds.data.prefs.PrefsHelper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TokenInterceptor @Inject constructor(
    private val prefsHelper: PrefsHelper
) : okhttp3.Interceptor {
    override fun intercept(chain: okhttp3.Interceptor.Chain): okhttp3.Response {

        var request = chain.request()
        /*
         * Добавляет header с токеном, только если нет другого Authorization (Basic)
         *
         * Возможна ситуация, когда токен сохранен, но юзер еще не зареган.
         * Например, юзер ввел корректный СМС-код, после чего сохраняется токен
         * и выполняется переход на экран регистрации юзера, но при этом регистрацию не прошел и вышел.
         */
//        if (request.headers()["Authorization"] == null) {
//            prefsHelper.getToken()?.let {
//                request = chain.request().newBuilder()
//                    .addHeader("Authorization", "Bearer d65b4424-ab11-11ea-ae11-b42e9981f624")
//                    .build()
//            }
//        }
        request = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer b14e20f9-afba-11ea-ae11-b42e9981f624")
                    .build()
        return chain.proceed(request)   }
}