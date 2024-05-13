package com.diegocunha.findpets.datasource

import com.diegocunha.findpets.BuildConfig
import com.diegocunha.findpets.data.network.FindsPetService
import com.diegocunha.findpets.data.network.adapter.CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {

    single { retrofit(get()).create(FindsPetService::class.java) }

    factory { okHttp3() }
}

private fun retrofit(okHttpClient: OkHttpClient) = Retrofit.Builder()
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