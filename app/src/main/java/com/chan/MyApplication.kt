package com.chan

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MyApplication: Application() {

    @Inject
    lateinit var androidLogAdapter: AndroidLogAdapter

    override fun onCreate() {
        super.onCreate()
        Logger.addLogAdapter(androidLogAdapter)
    }
}