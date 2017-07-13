package tech.laosiji.mvpbykotlin.http.callback

import io.reactivex.subscribers.DefaultSubscriber

/**
 * Created by whyte on 2017/7/10.
 */
class SubscriberCallBack<T> : DefaultSubscriber<T>() {

    override fun onError(t: Throwable?) {

    }

    override fun onComplete() {

    }

    override fun onNext(t: T) {

    }
}