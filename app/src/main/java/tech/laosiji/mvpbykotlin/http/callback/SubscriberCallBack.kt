package tech.laosiji.mvpbykotlin.http.callback

import io.reactivex.subscribers.DefaultSubscriber
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Created by whyte on 2017/7/10.
 */
open class SubscriberCallBack<T>(val apiCallback: ApiCallback<T>) : DefaultSubscriber<T>() {

    override fun onError(e: Throwable?) {
        var msg = "服务器开了点小差，请稍后再试"
        var code = 0
        try {
            if (e != null) {
                if (e is HttpException) {
                    val httpException = e as HttpException?
                    code = httpException!!.code()
                    when (code) {
                        504 -> msg = "网络不给力，请稍后再试"
                        408 -> msg = "服务器开了点小差，请稍后再试"
                        413 -> msg = "不好意思,请求实体太大"
                        502 -> msg = "正在维护服务器，请稍后再试"
                        else -> msg = "请求失败"
                    }
                } else if (e is SocketTimeoutException) {
                    msg = "请求超时，请稍后再试"
                } else if (e is SocketException) {
                    msg = "请求超时，请稍后再试"
                } else if (e is UnknownHostException) {
                    msg = "网络未连接，请连接后再试"
                    code = -1
                } else if (e is IOException) {
                    msg = "请求失败"
                } else {
                    e!!.printStackTrace()
                    msg = "未知错误"
                }
            }
        } catch (throwable: Throwable) {
            msg = "请求超时，请稍后再试"
        }

        apiCallback.onFailure(code, msg)
    }

    override fun onComplete() {
        apiCallback.onCompleted()
    }

    override fun onNext(t: T) {
        apiCallback.onSuccess(t)
    }
}