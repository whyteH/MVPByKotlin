package tech.laosiji.mvpbykotlin.presenter

import android.content.Context
import tech.laosiji.mvpbykotlin.bean.base.MainBean
import tech.laosiji.mvpbykotlin.http.HttpManager
import tech.laosiji.mvpbykotlin.http.callback.ApiCallback
import tech.laosiji.mvpbykotlin.http.callback.SubscriberCallBack

/**
 * Created by whyte on 2017/7/13.
 */
open class MainPresenter(Context: Context, mvpView: MainContract.View?) : MainContract.Presenter(Context, mvpView) {

    open fun getLatest() = HttpManager.doHttp(HttpManager.mainService.getWorkList(),
            object : SubscriberCallBack<MainBean>(object : ApiCallback<MainBean> {
                override fun onCompleted() {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onFailure(code: Int, msg: String) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onSuccess(data: MainBean) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            }){})
}