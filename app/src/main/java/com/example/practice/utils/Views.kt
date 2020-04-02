package com.example.practice.utils

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

typealias ViewOnClickListener = View.OnClickListener

fun View.show(){
    visibility = View.VISIBLE
}

fun View.hide(){
    visibility = View.GONE
}

fun View.invisible(){
    visibility = View.INVISIBLE
}


fun ImageView.loadImage(url : String){
    Glide.with(context).load(url).into(this)
}