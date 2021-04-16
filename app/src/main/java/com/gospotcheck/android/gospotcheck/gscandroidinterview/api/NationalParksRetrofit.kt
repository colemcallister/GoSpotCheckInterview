package com.gospotcheck.android.gospotcheck.gscandroidinterview.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


private val httpLoggingInterceptor = HttpLoggingInterceptor(ApiLogger()).apply {
    level = HttpLoggingInterceptor.Level.BASIC
}

private val apiKeyInterceptor =
    ApiKeyInterceptor()

val okHttpClient: OkHttpClient by lazy {
    OkHttpClient.Builder()
        .addNetworkInterceptor(httpLoggingInterceptor)
        .addNetworkInterceptor(apiKeyInterceptor)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()
}

val retrofit: Retrofit by lazy {
    Retrofit.Builder()
        .baseUrl("https://developer.nps.gov/api/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
}