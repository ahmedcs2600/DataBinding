package com.example.practice

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : Application(){

    override fun onCreate() {
        super.onCreate()
    }

  /*  override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

    }*/

}

