package com.gospotcheck.android.gospotcheck.gscandroidinterview.api

import okhttp3.Interceptor
import okhttp3.Response


class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newUrl = request.url()
            .newBuilder()
            .addQueryParameter("api_key", "ihOZMoLML3yi5Sc7wBwZ74YIaQwCGM2yFfc9TqlH")
            .build()

        val newRequest = request.newBuilder().url(newUrl).build()
        return chain.proceed(newRequest)
    }
}
