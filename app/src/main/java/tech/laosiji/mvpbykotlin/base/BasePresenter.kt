package tech.laosiji.mvpbykotlin.base


/**
 * Created by whyte on 2016/7/19 0019.
 */
class BasePresenter<V> : Presenter {

    //    protected Context mContext;
    var mvpView: V? = null
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
