package com.example.practice.repository

import com.example.practice.models.Project
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class AppRepository private constructor() : BaseRepository(){




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

    fun getProjectList(mUserId: String): Single<List<Project>> = callRequest(service.getProjectList(mUserId))



    fun getProjectDetails(userId: String, projectName: String?): Single<Project> = callRequest(service.getProjectDetails(userId,projectName))


}