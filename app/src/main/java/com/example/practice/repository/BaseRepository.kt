package com.example.practice.repository

import com.example.practice.network.RetrofitClient
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


open class BaseRepository protected constructor(){

    protected val service
        get() = RetrofitClient.getInstance()


    protected fun <T> callRequest(call: Single<T>): Single<T> =
        call.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

}