package tech.laosiji.mvpbykotlin.http.callback

/**
 * Created by whyte on 2017/7/9.
 */
interface ApiCallback<T> {
    fun onSuccess(data: T)

    fun onFailure(code: Int, msg: String)

    fun onCompleted()
}