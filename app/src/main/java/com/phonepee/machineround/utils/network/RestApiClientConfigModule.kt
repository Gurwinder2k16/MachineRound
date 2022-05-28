package com.phonepee.machineround.utils.network

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class RestApiClientConfigModule {
    /**
     * Retrofit Api Implementation
     */
    @Provides
    fun getRetrofit(): Retrofit {
        return if (NetworkConstants.mUseDeveloperServer) {
            initializeRetrofitService(NetworkConstants.sDeveloperNETWORK_URL)
        } else {
            if (NetworkConstants.mUseLocalServer) {
                initializeRetrofitService(NetworkConstants.sBASE_URL)
            } else {
                initializeRetrofitService(NetworkConstants.sBASE_INTERNET_NETWORK_URL)
            }
        }
    }

    /**
     * Initialize Retrofit Api Service
     *
     * @param pBaseUrl - Url for Api
     *
     *
     * Build Connection or handshaking with url and Model
     */
    private fun initializeRetrofitService(pBaseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(pBaseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().apply {
                readTimeout(NetworkConstants.REQUEST_TIMEOUT, TimeUnit.SECONDS)
                connectTimeout(NetworkConstants.REQUEST_TIMEOUT, TimeUnit.SECONDS)
            }.build())
            .build()
    }
}