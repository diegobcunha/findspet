package com.diegocunha.datasource.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class AccessTokenInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val newRequest = originalRequest.newBuilder()
            .header(
                "Authorization",
                "Bearer bae99fe10135d850f4a9359880696a1cc8207406ee99c6b1aa2449e46f769da34942623c3e85db20df9f5be8475c38a41021bab9df0b4d90873088c7be17ffc5df8fc8c6fad4f9528cf21725c9602693c5f09fca86e9952c7f66f833fb0a6ddea46b4e22472f4811e2210a024bb51f134d19b304a8bd552a79ceba4199db3f16"
            )
            .build()
        return chain.proceed(newRequest)
    }
}