package com.example.networktest

import android.app.Application
import com.example.networktest.di.NetWorkModule
import com.example.networktest.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(appModule, NetWorkModule)
        }
    }
}