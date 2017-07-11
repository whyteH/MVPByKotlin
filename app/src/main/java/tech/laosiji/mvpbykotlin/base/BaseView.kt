package tech.laosiji.mvpbykotlin.base

/**
 * Created by whyte on 2016/7/18 0018.
 */
interface BaseView<T> {
    fun showMsg(msg: String)

    fun onMainDataSuccess(data: T)

    fun showLoading()

    fun hideLoading()
}
