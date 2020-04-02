package com.example.practice.network

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {
        @Volatile
        private lateinit var mGithubService: WebService

        fun getInstance(): WebService {
            if (!(::mGithubService.isInitialized)) {
                synchronized(this) {
                    mGithubService = getWebService()
                }
            }
            return mGithubService
        }

        private fun getWebService() : WebService {
            return Retrofit.Builder()
                .baseUrl(WebService.HTTPS_API_GITHUB_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().run {
                    create(WebService::class.java)
                }
        }
    }
}