package com.example.practice.utils

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.fragment.app.Fragment

const val PREF_FILE_NAME = "app_preferences"
const val LOGIN_KEY = "KEY_LOGIN"
const val FIREBASE_TOKEN = "KEY_FIREBASE_TOKEN"

private typealias Editor =  SharedPreferences.Editor

fun Context.setLogin(isLogin : Boolean){
    writePref {
        putBoolean(LOGIN_KEY,isLogin)
    }
}
fun Fragment.setLogin(isLogin : Boolean){
    context?.setLogin(isLogin)
}

val Context.isLogin
get() = getPref.getBoolean(LOGIN_KEY,false)

val Fragment.isLogin
get() = context?.isLogin


private fun Context.writePref(action: Editor.() -> Unit) {
    getPref.edit(true,action)
}

private val Context.getPref
get() = getSharedPreferences(PREF_FILE_NAME, Activity.MODE_PRIVATE)