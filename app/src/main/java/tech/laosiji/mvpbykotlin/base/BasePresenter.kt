package tech.laosiji.mvpbykotlin.base

import android.content.Context


/**
 * Created by whyte on 2016/7/19 0019.
 */
open class BasePresenter<V>(val Context: Context, var mvpView: V) : Presenter {

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

    }

    override fun onUnSubscribe() {
        //        if (httpManager != null)
        //            httpManager.onUnSubscribe();
    }
}
