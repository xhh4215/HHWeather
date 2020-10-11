package com.xiaohei.hhweather.logic.network

import com.xiaohei.hhweather.HHWeatherApplication
import com.xiaohei.hhweather.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/***
 * @author 栾桂明
 * @date 2020 年 10月 11 日
 * @use 位置信息获取的网络接口
 */
interface PlaceService {
    // 查询地址
    @GET("v2/place?token=${HHWeatherApplication.TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query") query: String): Call<PlaceResponse>
}