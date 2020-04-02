package com.example.practice.utils

import android.content.Context
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

private typealias DialogBuilder = AlertDialog.Builder
private typealias DialogExtras = DialogBuilder.() -> Unit

fun Fragment.createDialog(@StringRes title: Int, @StringRes message: Int ,builder: DialogExtras = {}){
    context?.createDialog(title,message,builder)
}
fun Context.createDialog(@StringRes title: Int, @StringRes message: Int ,builder: DialogExtras = {}) {
    DialogBuilder(this).run {
        setTitle(title)
        setMessage(message)
        this
    }.apply(builder)
        .show()
    }


