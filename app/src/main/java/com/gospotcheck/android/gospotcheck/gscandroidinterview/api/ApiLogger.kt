package com.gospotcheck.android.gospotcheck.gscandroidinterview.api

import android.util.Log
import okhttp3.logging.HttpLoggingInterceptor


class ApiLogger : HttpLoggingInterceptor.Logger {

    companion object {
        private const val LOG_TAG = "HTTPS"
    }

    override fun log(message: String) {
        Log.d(LOG_TAG, message)
    }
}