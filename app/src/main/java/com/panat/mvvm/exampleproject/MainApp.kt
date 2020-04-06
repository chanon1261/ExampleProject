package com.panat.mvvm.exampleproject

import android.app.Application
import com.panat.mvvm.exampleproject.di.AppModule
import com.panat.mvvm.exampleproject.di.NetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MainApp)
            modules(listOf(AppModule, NetworkModule))
        }
    }
}
