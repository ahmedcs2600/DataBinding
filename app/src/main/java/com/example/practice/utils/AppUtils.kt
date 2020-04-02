package com.example.practice.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.StringRes

fun Context.showToast(@StringRes message : Int){
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
}
inline fun <reified T : Any> Activity.launchActivity(requestCode: Int = -1, options: Bundle? = null, noinline init: Intent.() -> Unit = {}) {
    newIntent<T>(this).run{
        init()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
        {
            startActivityForResult(this, requestCode, options)
        } else {
            startActivityForResult(this, requestCode)
        }
    }

}

inline fun <reified T : Any> Context.launchActivity (options: Bundle? = null, noinline init: Intent.() -> Unit = {}) {
    newIntent<T>(this).run {
        init()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
        {
            startActivity(this, options)
        } else {
            startActivity(this)
        }
    }
}

inline fun <reified T : Any> newIntent(context: Context): Intent = Intent(context, T::class.java)