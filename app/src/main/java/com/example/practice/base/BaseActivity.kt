package com.example.practice.base

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit

abstract class BaseActivity : AppCompatActivity() {
    private val mSupportFragmentManager
        get() = supportFragmentManager

    abstract val mFragmentContainerId : Int?


    fun changeFragment(mFragment: Fragment,tag : String?) {
        mFragmentContainerId?.let {
            mSupportFragmentManager.commit {
                replace(it, mFragment)
                addToBackStack(tag)
            }
        }
    }
}