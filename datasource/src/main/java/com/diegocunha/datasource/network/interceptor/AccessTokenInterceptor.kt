package com.diegocunha.datasource.network.interceptor

import com.diegocunha.datasource.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class AccessTokenInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val newRequest = originalRequest.newBuilder()
            .header(
                AUTHORIZATION_HEADER,
                BuildConfig.ACCESS_TOKEN
            )
            .build()
        return chain.proceed(newRequest)
    }

    companion object {
        private const val AUTHORIZATION_HEADER = "Authorization"
    }
}