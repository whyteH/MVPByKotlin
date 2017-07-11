package tech.laosiji.mvpbykotlin.base

/**
 * Created by whyte on 2016/7/19 0019.
 */
interface Presenter {
    fun onDetachView()

    fun onUnSubscribe()
}
