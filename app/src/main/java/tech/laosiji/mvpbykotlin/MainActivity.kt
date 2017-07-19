package tech.laosiji.mvpbykotlin

import android.os.Bundle
import tech.laosiji.mvpbykotlin.base.MvpActivity
import tech.laosiji.mvpbykotlin.bean.MainBean
import tech.laosiji.mvpbykotlin.presenter.MainContract
import tech.laosiji.mvpbykotlin.presenter.MainPresenter

class MainActivity : MvpActivity<MainPresenter>(), MainContract.View {

    override fun onMainDataSuccess(data: MainBean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showMsg(msg: String) {
    }

    override fun createPresenter(): MainPresenter = MainPresenter(this, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mvpPresenter.getList()
    }

}
