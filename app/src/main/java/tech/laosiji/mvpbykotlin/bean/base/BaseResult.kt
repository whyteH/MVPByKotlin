package tech.laosiji.mvpbykotlin.bean.base

/**
 * 本项目返回实体基类 author: whyte
 */
data class BaseResult<T>(var code: Int = 0, var message: String? = null, var totalCount: Int = 0, var data: T? = null)



