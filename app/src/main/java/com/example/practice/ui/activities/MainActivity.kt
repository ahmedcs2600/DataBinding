package com.example.practice.ui.activities

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.practice.R
import com.example.practice.base.BaseActivity
import com.example.practice.databinding.ActivityMainBinding
import com.example.practice.ui.fragments.ProjectListFragment
import com.example.practice.utils.replaceFragment

class MainActivity : BaseActivity() {

    override val mFragmentContainerId: Int
        get() = mActivityBinding.fragmentContainer.id

    private lateinit var mActivityBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)


        if (savedInstanceState == null) {
            replaceFragment(
                ProjectListFragment.newInstance(),
                ProjectListFragment::class.java.simpleName
            )
        }
    }

    override fun onLoading() {
        mActivityBinding.isLoading = true
    }

    override fun onRequestComplete() {
        mActivityBinding.isLoading = false
    }
}
