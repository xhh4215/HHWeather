package com.xiaohei.hhweather.logic.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/***
 * @author 栾桂明
 * @date 2020年10月11日
 * 获取retrofit的service对象
 */
object ServiceCreator {
    //base url
    private const val BASE_URL = "https://api.caiyunapp.com/"

    // 网络请求的retrofit对象
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // 通过动态代理获取对应的class的service对象
    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)
    // other way
    inline fun <reified T> create(): T = create(T::class.java)
}