package com.example.practice.repository

import com.example.practice.models.Project
import com.example.practice.network.RetrofitClient
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class AppRepository private constructor() {


    private val service by lazy {
        RetrofitClient.getInstance()
    }


    companion object {
        @Volatile
        private lateinit var INSTANCE: AppRepository

        fun getInstance(): AppRepository {
            if (!(::INSTANCE.isInitialized)) {
                synchronized(this) {
                    INSTANCE = AppRepository()
                }
            }
            return INSTANCE
        }
    }

    fun getProjectList(mUserId: String): Single<List<Project>> =
         service.getProjectList(mUserId).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())


    fun getProjectDetails(userId: String?, projectName: String): Single<Project?> =
         service.getProjectDetails(userId,projectName).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())


}