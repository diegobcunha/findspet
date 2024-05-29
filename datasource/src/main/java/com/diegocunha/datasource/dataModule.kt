package com.diegocunha.datasource

import com.diegocunha.datasource.network.adapter.CallAdapterFactory
import com.diegocunha.datasource.network.interceptor.AccessTokenInterceptor
import com.diegocunha.datasource.network.network.DiscoveryPetService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://cms.petsrs.com.br/api/"
val dataModule = module {

    factory { okHttp3() }

    single { retrofit(get()).create(DiscoveryPetService::class.java) }
}

private fun retrofit(okHttpClient: OkHttpClient) = Retrofit.Builder()
    .baseUrl(BASE_URL)
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

    builder.addInterceptor(logger)
    builder.addInterceptor(AccessTokenInterceptor())
    return builder.build()
}