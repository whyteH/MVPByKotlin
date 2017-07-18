package tech.laosiji.mvpbykotlin.presenter

import android.content.Context
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import tech.laosiji.mvpbykotlin.bean.AndroidBean
import tech.laosiji.mvpbykotlin.bean.base.BaseResult
import tech.laosiji.mvpbykotlin.http.HttpManager
import tech.laosiji.mvpbykotlin.http.callback.ApiCallback
import tech.laosiji.mvpbykotlin.http.callback.SubscriberCallBack

/**
 * Created by whyte on 2017/7/13.
 */
open class MainPresenter(Context: Context, mvpView: MainContract.View) : MainContract.Presenter(Context, mvpView) {

    //    open fun getLatest() = HttpManager.doHttp(HttpManager.mainService.getWorkList(1),
//            object : SubscriberCallBack<BaseResult<List<AndroidBean>>>(object : ApiCallback<BaseResult<List<AndroidBean>>> {
//                override fun onCompleted() {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                }
//
//                override fun onFailure(code: Int, msg: String) {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                }
//
//                override fun onSuccess(data: BaseResult<List<AndroidBean>>) {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                }
//
//
//            }) {})
    open fun getList() = HttpManager.mainService.getWorkList(1)
            .subscribeOn(Schedulers.newThread())//子线程访问网络
            .observeOn(AndroidSchedulers.mainThread())//回调回主线程
            .subscribe(SubscriberCallBack(object : ApiCallback<BaseResult<List<AndroidBean>>> {
                override fun onSuccess(data: BaseResult<List<AndroidBean>>) {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onFailure(code: Int, msg: String) {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onCompleted() {
//                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            }))
}