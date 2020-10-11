package com.xiaohei.hhweather.logic.repository

import androidx.lifecycle.liveData
import com.xiaohei.hhweather.logic.network.HHWeatherNetWorker
import com.xiaohei.hhweather.logic.model.Place
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import java.lang.RuntimeException

object Repository {
    //livedata() 是自动构建并返回一个LiveData对象 它提供了一个挂起函数的上下文
    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {
        val result:Result<List<Place>> = try {
            val placeResponse = HHWeatherNetWorker.searchPlaces(query)
            if (placeResponse.status == "ok") {
                val places = placeResponse.place
                Result.success(places)
            } else {
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        } catch (e: Exception) {
            Result.failure<List<Place>>(e)
        }

        //类似livedata的setValue方法
        emit(result)
    }
}