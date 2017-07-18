package tech.laosiji.mvpbykotlin.http.service

import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path
import tech.laosiji.mvpbykotlin.bean.AndroidBean
import tech.laosiji.mvpbykotlin.bean.base.BaseResult
import tech.laosiji.mvpbykotlin.http.url.data

/**
 * Created by whyte on 2017/7/13.
 */
interface MainService {

    @GET(data)
    fun getWorkList(@Path("page") page: Int): Flowable<BaseResult<List<AndroidBean>>>
}