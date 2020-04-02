package com.example.practice.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practice.R
import com.example.practice.utils.launchActivity
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit

class Splash : AppCompatActivity() {


    companion object{
        const val SECONDS_DELAY = 3L
    }

    private var disposable : Disposable? =   null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        proceed()

    }

    private fun proceed(){
       Single.timer(SECONDS_DELAY,TimeUnit.SECONDS).subscribe(object : SingleObserver<Long>{
            override fun onSuccess(t: Long) {
                launchActivity<MainActivity>()
                finish()
            }
            override fun onSubscribe(d: Disposable) {
                disposable = d
            }

            override fun onError(e: Throwable) {

            }

        })
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }
}
