package tech.laosiji.mvpbykotlin.presenter

import android.content.Context
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import tech.laosiji.mvpbykotlin.bean.MainBean
import tech.laosiji.mvpbykotlin.http.HttpManager
import tech.laosiji.mvpbykotlin.http.callback.ApiCallback
import tech.laosiji.mvpbykotlin.http.callback.SubscriberCallBack

/**
 * Created by whyte on 2017/7/13.
 */
open class MainPresenter(Context: Context, mvpView: MainContract.View) : MainContract.Presenter(Context, mvpView) {

    open fun getList() = HttpManager.apiService.getWorkList()
            .subscribeOn(Schedulers.newThread())//子线程访问网络
            .observeOn(AndroidSchedulers.mainThread())//回调回主线程
            .subscribe(SubscriberCallBack(object : ApiCallback<MainBean> {
                override fun onSuccess(data: MainBean) {
                }

                override fun onFailure(code: Int, msg: String) {
                }

                override fun onCompleted() {

                }

            }))
}