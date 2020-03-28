package com.example.practice.repository

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.practice.models.Project
import com.example.practice.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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


    @MainThread
    fun getProjectList(mUserId: String): LiveData<List<Project>?> =
        MutableLiveData<List<Project>?>().also {
            service.getProjectList(mUserId).enqueue(object : Callback<List<Project>> {
                override fun onFailure(call: Call<List<Project>>, t: Throwable) {
                    it.value = null
                }

                override fun onResponse(
                    call: Call<List<Project>>,
                    response: Response<List<Project>>
                ) {
                    response.body()?.let { data ->
                        it.value = data
                    }
                }
            })
        }

    @MainThread
    fun getProjectDetails(userId: String, projectName: String): LiveData<Project?> =
        MutableLiveData<Project?>().also {
            service.getProjectDetails(userId, projectName).enqueue(object : Callback<Project> {
                override fun onFailure(call: Call<Project>, t: Throwable) {
                    it.value = null
                }

                override fun onResponse(call: Call<Project>, response: Response<Project>) {
                    response.body()?.let { data -> it.value = data }
                }
            })
        }
}