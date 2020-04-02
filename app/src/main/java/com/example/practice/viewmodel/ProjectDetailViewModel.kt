package com.example.practice.viewmodel

import androidx.annotation.MainThread
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.practice.models.NetworkState
import com.example.practice.models.Project
import com.example.practice.repository.AppRepository
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver

class ProjectDetailViewModel : BaseViewModel() {

    val project: ObservableField<Project> = ObservableField()


    private val mAppRepository by lazy {
        AppRepository.getInstance()
    }

    val mProjectLiveData : LiveData<Project?>
    get() = mProject

    private val mProject = MutableLiveData<Project?>()

    private val compositeDisposable = CompositeDisposable()

    fun getProjectByProjectId(projectId: String?) {
        mLoadingState.value = NetworkState.LOADING

        mAppRepository.getProjectDetails( "Google",projectId).subscribeWith(object : DisposableSingleObserver<Project>(){
            override fun onSuccess(data: Project) {
                mProject.value = data
                mLoadingState.value = NetworkState.LOADED
            }
            override fun onError(e: Throwable) {
                mProject.value = null
                mLoadingState.value = NetworkState.FAILED
            }
        }).also {
            compositeDisposable.add(it)
        }
    }

    fun setProject(mProject: Project) {
        this.project.set(mProject)

    }

    override fun onCleared() {
        super.onCleared()
        with(compositeDisposable){
            clear()
        }
    }
}