package com.example.practice.base

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit

abstract class BaseActivity : AppCompatActivity() {
    private val mSupportFragmentManager
        get() = supportFragmentManager

    private val mBackStackEntry : Int
    get() = mSupportFragmentManager.backStackEntryCount

    abstract val mFragmentContainerId : Int

    fun changeFragment(mFragment: Fragment, tag: String?) {
        mSupportFragmentManager.commit {
            replace(mFragmentContainerId, mFragment)
            addToBackStack(tag)
        }
    }

    override fun onBackPressed() {
        if(mBackStackEntry > 1)
            super.onBackPressed()
        else
            finish()
    }
}