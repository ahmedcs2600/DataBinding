package com.example.practice.utils

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("visibleGone")
fun showHide(view : View,show : Boolean){
    if(show)
        view.show()
    else
        view.hide()
}