package tech.laosiji.mvpbykotlin.presenter

import android.content.Context
import tech.laosiji.mvpbykotlin.base.BasePresenter
import tech.laosiji.mvpbykotlin.base.BaseView

/**
 * Created by whyte on 2017/7/13.
 */
interface MainContract {
    interface View : BaseView<Any> {

    }

    abstract class Presenter(Context: Context, mvpView: View?) : BasePresenter<View>(Context, mvpView) {

    }
}