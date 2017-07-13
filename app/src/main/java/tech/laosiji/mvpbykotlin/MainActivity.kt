package tech.laosiji.mvpbykotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val defaultSub = object : DisposableSubscriber<String>() {
            override fun onNext(s: String) {
                println(s)
            }

            override fun onError(t: Throwable) {

            }

            override fun onComplete() {
                println("Done")
            }
        }
        Flowable.just("hello world")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(defaultSub)
    }

}
