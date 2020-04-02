package com.example.practice.base

import androidx.appcompat.app.AppCompatActivity
import com.example.practice.App
import com.example.practice.models.NetworkState

abstract class BaseActivity : AppCompatActivity() {

    private val mBackStackEntry: Int
        get() = supportFragmentManager.backStackEntryCount

    abstract val mFragmentContainerId: Int


    val app : App
    get() = application as App


    override fun onBackPressed() {
        if (mBackStackEntry > 1)
            super.onBackPressed()
        else
            finish()
    }


    fun setLoadingState(state: NetworkState) {
        when (state) {
            NetworkState.LOADED, NetworkState.FAILED -> onRequestComplete()
            NetworkState.LOADING -> onLoading()
        }
    }

    abstract fun onLoading()

    abstract fun onRequestComplete()
}