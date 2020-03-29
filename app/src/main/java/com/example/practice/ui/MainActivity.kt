package com.example.practice.ui

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.practice.R
import com.example.practice.base.BaseActivity
import com.example.practice.databinding.ActivityMainBinding
import com.example.practice.models.NetworkState
import com.example.practice.ui.fragments.ProjectListFragment

class MainActivity : BaseActivity() {

    override val mFragmentContainerId: Int
        get() = mActivityBinding.fragmentContainer.id

    private lateinit var mActivityBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)


        if (savedInstanceState == null) {
            changeFragment(ProjectListFragment.newInstance(), ProjectListFragment::class.java.simpleName)
        }
    }

    fun setLoadingState(state : NetworkState){
        when(state){
            NetworkState.LOADED, NetworkState.FAILED -> {
                mActivityBinding.isLoading = false
            }
            NetworkState.LOADING -> {
                mActivityBinding.isLoading = true
            }
        }

    }

}
