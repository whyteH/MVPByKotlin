package tech.laosiji.mvpbykotlin.http.service

import io.reactivex.Flowable
import retrofit2.http.GET
import tech.laosiji.mvpbykotlin.bean.base.MainBean
import tech.laosiji.mvpbykotlin.http.url.latest

/**
 * Created by whyte on 2017/7/13.
 */
abstract class MainService {

    @GET(latest)
    abstract fun getWorkList(): Flowable<MainBean>
}