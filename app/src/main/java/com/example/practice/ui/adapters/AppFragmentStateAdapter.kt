package com.example.practice.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class AppFragmentStateAdapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {


    private val mFragmentList = ArrayList<Fragment>()
    private val mFragmentTitleList = ArrayList<String>()


    fun addFragment(fragment: Fragment, title: String) {
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }

    override fun getCount(): Int = mFragmentList.size

    override fun getItem(position: Int) = mFragmentList[position]

    override fun getPageTitle(position: Int) = mFragmentTitleList[position]
}