package tech.laosiji.mvpbykotlin.base

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by whyte on 2017/7/13.
 */
abstract class MvpActivity<P : Presenter> : AppCompatActivity() {

    protected lateinit var mvpPresenter: P

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        mvpPresenter = createPresenter()
        super.onCreate(savedInstanceState, persistentState)
    }

    abstract fun createPresenter(): P
}