package com.example.practice.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.practice.models.NetworkState
import com.example.practice.models.Project
import com.example.practice.repository.AppRepository
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver

class ProjectListViewModel : BaseViewModel(){


    private val mAppRepository by lazy {
        AppRepository.getInstance()
    }

    private val compositeDisposable = CompositeDisposable()

    val mProjectListLiveData : LiveData<List<Project>?>
    get() = mProjectList

    private val mProjectList = MutableLiveData<List<Project>?>()

    fun getProjectList() {

        mLoadingState.value = NetworkState.LOADING

        compositeDisposable.add(mAppRepository.getProjectList("Google").subscribeWith(object : DisposableSingleObserver<List<Project>>(){
            override fun onSuccess(data: List<Project>) {
                mLoadingState.value = NetworkState.LOADED
                mProjectList.value = data
            }

            override fun onError(e: Throwable) {
                mLoadingState.value = NetworkState.FAILED
                mProjectList.value = null
            }
        }))
    }

    override fun onCleared() {
        super.onCleared()
        with(compositeDisposable) {
            clear()
        }
    }
}