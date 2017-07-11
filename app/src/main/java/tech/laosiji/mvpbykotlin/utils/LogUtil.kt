package tech.laosiji.mvpbykotlin.utils

import android.util.Log

import tech.laosiji.mvpbykotlin.BuildConfig

/**
 * 打印工具类
 * Created by whyte on 2016/7/18 0018.
 */
class LogUtil {

    companion object {
        private val DEBUG = BuildConfig.DEBUG


        fun d(tag: String, msg: String) {
            if (DEBUG) {
                Log.d(tag, msg)
            }
        }

        fun e(tag: String, msg: String) {
            if (DEBUG) {
                Log.e(tag, msg)
            }
        }

        fun i(tag: String, msg: String) {
            if (DEBUG) {
                Log.i(tag, msg)
            }
        }

        fun v(tag: String, msg: String) {
            if (DEBUG) {
                Log.v(tag, msg)
            }
        }

        fun w(tag: String, msg: String) {
            if (DEBUG) {
                Log.w(tag, msg)
            }
        }

        fun wtf(tag: String, msg: String) {
            if (DEBUG) {
                Log.wtf(tag, msg)
            }
        }
    }

}
