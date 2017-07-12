package tech.laosiji.mvpbykotlin.http.callback

import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

/**
 * Created by whyte on 2017/7/10.
 */
class SubscriberCallBack<T> : Subscriber<T> {
    override fun onError(t: Throwable?) {

    }

    override fun onComplete() {

    }

    override fun onNext(t: T) {

    }

    override fun onSubscribe(s: Subscription) {

    }

}