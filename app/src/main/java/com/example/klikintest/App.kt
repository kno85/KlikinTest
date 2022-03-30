package com.example.klikintest

import android.app.Application
import android.util.Log.ERROR
import com.example.klikintest.di.MainViewModelModule
import com.example.klikintest.di.NetworkModule
import com.example.klikintest.di.RepositoryModule
import com.example.klikintest.di.UseCasesModule

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import java.util.logging.Level

class App: Application() {


    override fun onCreate() {

        val appModules = listOf(NetworkModule,UseCasesModule, RepositoryModule, MainViewModelModule)
        super.onCreate()
        startKoin { androidLogger(org.koin.core.logger.Level.ERROR)

            androidContext(this@App)
            modules(appModules)
        }
    }
}