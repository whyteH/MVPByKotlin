package tech.laosiji.mvpbykotlin

import android.os.Bundle
import tech.laosiji.mvpbykotlin.base.MvpActivity
import tech.laosiji.mvpbykotlin.presenter.MainContract
import tech.laosiji.mvpbykotlin.presenter.MainPresenter

class MainActivity : MvpActivity<MainPresenter>(), MainContract.View {


    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onMainDataSuccess(data: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showMsg(msg: String) {
    }

    override fun createPresenter(): MainPresenter = MainPresenter(this, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mvpPresenter.getLatest()

//        val defaultSub = object : DisposableSubscriber<String>() {
//            override fun onNext(s: String) {
//                println(s)
//            }
//
//            override fun onError(t: Throwable) {
//
//            }
//
//            override fun onComplete() {
//                println("Done")
//            }
//        }
//        Flowable.just("hello world")
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(defaultSub)
    }

}
