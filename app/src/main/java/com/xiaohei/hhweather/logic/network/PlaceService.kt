package com.xiaohei.hhweather.logic.network

import com.xiaohei.hhweather.HHWeatherApplication
import com.xiaohei.hhweather.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceService {
    @GET("v2/place?token=${HHWeatherApplication.TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query") query: String): Call<PlaceResponse>
}