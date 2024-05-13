package com.diegocunha.datasource

import com.diegocunha.network.adapter.CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {

    factory { okHttp3() }
}

fun retrofit(okHttpClient: OkHttpClient) = Retrofit.Builder()
    .baseUrl("")
    .client(okHttpClient)
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(CallAdapterFactory())
    .build()

private fun okHttp3(): OkHttpClient {
    val builder = OkHttpClient.Builder()
    builder.addInterceptor { chain ->
        val url = chain
            .request()
            .url
            .newBuilder()
            .build()
        chain.proceed(chain.request().newBuilder().url(url).build())
    }
    val level = if (BuildConfig.DEBUG) {
        HttpLoggingInterceptor.Level.BODY
    } else {
        HttpLoggingInterceptor.Level.NONE
    }

    val logger = HttpLoggingInterceptor()
    logger.level = level

    builder.interceptors().add(logger)
    return builder.build()
}