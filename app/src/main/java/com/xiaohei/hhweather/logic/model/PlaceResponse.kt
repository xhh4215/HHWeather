package com.xiaohei.hhweather.logic.model

import com.google.gson.annotations.SerializedName

/****
 * 网络请求返回的状态信息和地址信息
 */
data class PlaceResponse(val status: String, val place: List<Place>)

/***
 * 地址信息
 * @param  name 名称
 * @param location 位置，
 * @param  address 地址
 */
data class Place(
    val name: String,
    val location: Location,
    @SerializedName("formatted_address") val address: String
)

/***
 * 位置信息
 * @param lng 经度
 * @param lat 纬度
 */
data class Location(val lng: String, val lat: String)