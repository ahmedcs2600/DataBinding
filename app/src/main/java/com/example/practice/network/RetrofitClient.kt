package com.example.practice.network

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {
        @Volatile
        private lateinit var mGithubService: GithubService

        fun getInstance(): GithubService {
            if (!(::mGithubService.isInitialized)) {
                synchronized(this) {
                    mGithubService = getGithubService()
                }
            }
            return mGithubService
        }

        private fun getGithubService() : GithubService {
            return Retrofit.Builder()
                .baseUrl(GithubService.HTTPS_API_GITHUB_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().run {
                    create(GithubService::class.java)
                }
        }
    }
}