package tech.laosiji.mvpbykotlin.http.service

import io.reactivex.Flowable
import retrofit2.http.GET
import tech.laosiji.mvpbykotlin.bean.MainBean
import tech.laosiji.mvpbykotlin.http.url.latest

/**
 * Created by whyte on 2017/7/13.
 */
interface ApiService {

    @GET(latest)
    fun getWorkList(): Flowable<MainBean>
}