package com.example.practice.ui

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.practice.R
import com.example.practice.base.BaseActivity
import com.example.practice.databinding.ActivityMainBinding
import com.example.practice.models.NetworkState
import com.example.practice.ui.fragments.ProjectListFragment

class MainActivity : BaseActivity() {

    override val mFragmentContainerId: Int?
        get() = mActivityBinding?.fragmentContainer?.id

    var mActivityBinding: ActivityMainBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityBinding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)


        if (savedInstanceState == null) {
            changeFragment(ProjectListFragment.newInstance(), ProjectListFragment::class.java.simpleName)
        }
    }

    fun setLoadingState(state : NetworkState){
        Log.e("Test",state.toString())
    }

}
