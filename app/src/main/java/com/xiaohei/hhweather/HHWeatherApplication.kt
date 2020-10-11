package com.xiaohei.hhweather

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class HHWeatherApplication : Application() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
        const val TOKEN = "ty2vxQ2GD7ODe1kP"

    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}