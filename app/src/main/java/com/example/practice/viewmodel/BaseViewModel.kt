package com.example.practice.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.practice.models.NetworkState

open class BaseViewModel : ViewModel(){
    protected val mLoadingState = MutableLiveData<NetworkState>()


    val mLoadingLiveData : LiveData<NetworkState>
        get() = mLoadingState
}