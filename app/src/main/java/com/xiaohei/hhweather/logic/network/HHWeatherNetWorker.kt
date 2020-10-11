package com.xiaohei.hhweather.logic.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/***
 * @author 栾桂明
 * @date 2020年10月11日
 * 该app的网络请求的同意封装
 */
object HHWeatherNetWorker {
    //获取地址的service
    private val placeService = ServiceCreator.create(PlaceService::class.java)

    //具体的获取地址的网络请求
    suspend fun searchPlaces(query: String) = placeService.searchPlaces(query).await()

    /***
     * 对网络请求的结果的处理
     */
    private suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }

                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) {
                        continuation.resume(body)
                    } else {
                        RuntimeException("response body is null")
                    }
                }

            })
        }
    }
}