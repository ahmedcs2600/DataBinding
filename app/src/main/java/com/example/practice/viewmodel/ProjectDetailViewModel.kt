package com.example.practice.viewmodel

import androidx.annotation.MainThread
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import com.example.practice.models.NetworkState
import com.example.practice.models.Project
import com.example.practice.repository.AppRepository

class ProjectDetailViewModel(private val projectId: String) : BaseViewModel() {

    val project: ObservableField<Project> = ObservableField()


    private val mAppRepository by lazy {
        AppRepository.getInstance()
    }

    @MainThread
    fun getProjectByProjectId(): LiveData<Project?> {
        mLoadingState.value = NetworkState.LOADING
        return mAppRepository.getProjectDetails(projectId, "Google")
    }


    fun setProject(mProject: Project) {
        this.project.set(mProject)
    }

}