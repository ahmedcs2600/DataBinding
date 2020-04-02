package com.example.practice.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.example.practice.base.BaseActivity



const val POP_INCLUSIVE = FragmentManager.POP_BACK_STACK_INCLUSIVE
const val POP_EXCLISIVE = 0

fun BaseActivity.popEntryTill(index: Int, popFlag: Int = POP_INCLUSIVE) {
    with(supportFragmentManager){
        if (index <= backStackEntryCount) return

        getBackStackEntryAt(index).let {
            popBackStack(it.id, popFlag)
        }
    }
}
fun BaseActivity.replaceFragment(
    mFragment: Fragment,
    tag: String?
) {
    supportFragmentManager.addOrReplaceFragment(mFragmentContainerId,mFragment,tag)
}

fun BaseActivity.addFragment(mFragment: Fragment,
                             tag: String?){
    supportFragmentManager.addOrReplaceFragment(mFragmentContainerId,mFragment,tag,true)
}


private fun FragmentManager.addOrReplaceFragment(mFragmentContainerId : Int,mFragment : Fragment,tag : String?,shouldAdd : Boolean = false){
    commit {
        if (shouldAdd)
            add(mFragmentContainerId, mFragment)
        else
            replace(mFragmentContainerId, mFragment)
        addToBackStack(tag)
    }
}

fun BaseActivity.emptyStack(){
    with(supportFragmentManager){
        for(i in 0..backStackEntryCount){
            getBackStackEntryAt(i).let {
                popBackStack(it.id, POP_INCLUSIVE)
            }
        }
    }
}