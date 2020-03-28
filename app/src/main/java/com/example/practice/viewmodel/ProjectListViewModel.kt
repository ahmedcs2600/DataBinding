package com.example.practice.viewmodel

import androidx.lifecycle.LiveData
import com.example.practice.models.NetworkState
import com.example.practice.models.Project
import com.example.practice.repository.AppRepository

class ProjectListViewModel : BaseViewModel(){


    private val mAppRepository by lazy {
        AppRepository.getInstance()
    }

    fun getProjectList(): LiveData<List<Project>?> {
        mLoadingState.value = NetworkState.LOADING

       return  mAppRepository.getProjectList("Google")
    }
}