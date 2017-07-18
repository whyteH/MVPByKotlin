package tech.laosiji.mvpbykotlin.http

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import tech.laosiji.mvpbykotlin.BuildConfig
import tech.laosiji.mvpbykotlin.http.service.MainService
import tech.laosiji.mvpbykotlin.utils.LogUtil
import java.util.concurrent.TimeUnit

/**
 * http交互处理类
 * Created by whyte on 2016/7/18 0018.
 */
object HttpManager {

    var mainService: MainService

    init {
        val DEFAULT_TIMEOUT = 10
        val CACHE_STALE_LONG = 60 * 60 * 24 * 7
        val cacheMaxSize = (10 * 1024 * 1024).toLong()
        val builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor { message -> LogUtil.i("okHttp", message) }
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            //设置 Debug Log 模式
            builder.addInterceptor(interceptor)
        }

        builder.retryOnConnectionFailure(true)
                //                .addNetworkInterceptor(mReceivedCookiesInterceptor)
                //                .addNetworkInterceptor(mAddCookiesInterceptor)
                .connectTimeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)

        val retrofit = Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("http://gank.io/api/")
                .build()

        mainService = retrofit.create(MainService::class.java)
    }


//    /**
//     * 处理http请求
//     */
//    fun  doHttp(flowAble: Flowable, subscriber: Subscriber) {
//        flowAble
//                .subscribeOn(Schedulers.newThread())//子线程访问网络
//                //                .map(new HttpResultFunc<>())
//                .observeOn(AndroidSchedulers.mainThread())//回调回主线程
//                .subscribe(subscriber)
//    }

    //
    //    /**
    //     * 云端响应头拦截器，用来配置缓存策略
    //     * Dangerous interceptor that rewrites the server's cache-control header.
    //     */
    //    private final Interceptor mRewriteCacheInterceptor = chain -> {
    //        Request request = chain.request();
    //        if (!NetUtil.isNetworkConnected()) {
    //            request = request.newBuilder()
    //                    .cacheControl(CacheControl.FORCE_CACHE)
    //                    .build();
    //            LogUtil.i("interceptor", "no network");
    //        }
    //        Response originalResponse = chain.proceed(request);
    //        if (NetUtil.isNetworkConnected()) {
    //            //有网的时候读接口上的@Headers里的配置，你可以在这里进行统一的设置
    //            String cacheControl = request.cacheControl().toString();
    //            return originalResponse.newBuilder()
    //                    .header("Cache-Control", cacheControl)
    //                    .removeHeader("Pragma")
    //                    .build();
    //        } else {
    //            return originalResponse.newBuilder()
    //                    .header("Cache-Control", "public, only-if-cached, max-stale=2419200")
    //                    .removeHeader("Pragma")
    //                    .build();
    //        }
    //    };
    //
    //    @NonNull
    //    private Interceptor mReceivedCookiesInterceptor = chain -> {
    //        Request.Builder builder = chain.request().newBuilder();
    //        Observable.just(HttpConstant.getCookie() == null ? "[]" : HttpConstant.getCookie())
    //                .subscribe(cookie -> builder.addHeader("Cookie", cookie));
    //
    //        Response originalResponse = chain.proceed(chain.request());
    //        //这里获取请求返回的cookie
    //        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
    //            final StringBuffer cookieBuffer = new StringBuffer();
    //            Observable.from(originalResponse.headers("Set-Cookie"))
    //                    .map(f -> f.split(";")[0])
    //                    .subscribe(cookie -> cookieBuffer.append(cookie).append(";"));
    //            HttpConstant.setCookie(cookieBuffer.toString());
    //        }
    //        return originalResponse;
    //    };
    //
    //    @NonNull
    //    private Interceptor mAddCookiesInterceptor = chain -> {
    //        Request.Builder builder = chain.request().newBuilder();
    //        Observable.just(HttpConstant.getCookie() == null ? "[]" : HttpConstant.getCookie())
    //                .subscribe(cookie -> builder.addHeader("Cookie", cookie));
    //        return chain.proceed(builder.build());
    //    };
    //
    //    //获取单例
    //    public static HttpManager getInstance() {
    //        if (INSTANCE == null) {
    //            synchronized (HttpManager.class) {
    //                if (INSTANCE == null) {
    //                    INSTANCE = new HttpManager();
    //                }
    //            }
    //        }
    //        return INSTANCE;
    //    }
    //
    //
    //


    //
    //    /**
    //     * 下载文件
    //     */
    //    public <T> void downLoadFile(@NonNull Observable<T> observable, @NonNull Subscriber<T> subscriber) {
    //        if (mCompositeSubscription == null) {
    //            mCompositeSubscription = new CompositeSubscription();
    //        }
    //        mCompositeSubscription.add(observable
    //                .subscribeOn(Schedulers.io())//子线程访问网络
    //                .observeOn(AndroidSchedulers.mainThread())//回调回主线程
    //                .subscribe(subscriber));
    //    }
    //
    //    /**
    //     * 取消注册
    //     */
    //    public void onUnSubscribe() {
    //        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
    //            mCompositeSubscription.clear();
    //        }
    //    }

    //    private final static class HttpResultFunc<T> implements Func1<BaseResult<T>, BaseResult<T>> {
    //
    //        @NonNull
    //        @Override
    //        public BaseResult<T> call(@NonNull BaseResult<T> baseResult) {
    //            if (baseResult.getCode() == 2) {
    //                // 登录过期
    //                String loginStr = "登录身份已过期，请您重新登录";
    //                ChatHelper.getInstance().logout();
    //                // 打开登录界面
    //                Bundle bundle = new Bundle();
    //                bundle.putString("username", UserConstant.getUserInfo().getMobile());
    //                bundle.putString("dialogMsg", loginStr);
    //                UserConstant.clearLoginData();
    //                Intent intent = new Intent(App.getContext(), UserLoginActivity.class);
    //                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    //                intent.putExtras(bundle);
    //                App.getContext().startActivity(intent);
    //            } else if (baseResult.getCode() == 0) {
    //
    //            } else {
    //                //do something... toast error message
    //                Observable.just(baseResult.getMessage()).subscribeOn(Schedulers.newThread())
    //                        .observeOn(AndroidSchedulers.mainThread())
    //                        .subscribe(ToastUtils::showShortToast);
    //            }
    //            return baseResult;
    //        }
    //    }
}
