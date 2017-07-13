package tech.laosiji.mvpbykotlin.base

import android.content.Context
import tech.laosiji.mvpbykotlin.http.HttpManager


/**
 * Created by whyte on 2016/7/19 0019.
 */
class BasePresenter<V>(val Context: Context, var mvpView: V?, val httpManager: HttpManager) : Presenter {

    init {

    }
    //    protected HttpManager httpManager;
    //
    //    public BasePresenter(@NonNull Context context, @NonNull V mvpView) {
    //        this.mContext = context;
    //        this.mvpView = mvpView;
    //        httpManager = HttpManager.getInstance();
    //    }

    override fun onDetachView() {
        if (mvpView != null)
            this.mvpView = null
    }

    override fun onUnSubscribe() {
        //        if (httpManager != null)
        //            httpManager.onUnSubscribe();
    }
}
