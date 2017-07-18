package tech.laosiji.mvpbykotlin.bean.base

/**
 * 本项目返回实体基类 author: whyte
 */
data class BaseResult<T>(var error: Boolean,  var results: T)



