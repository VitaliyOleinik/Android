package com.ankit.trendinggit

import android.app.Application
import com.ankit.trendinggit.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TrendingGitApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        startKoin{
            androidContext(this@TrendingGitApp)
            modules(
                listOf(repositoryModule, viewModelModule, retrofitModule, apiModule)
            )
        }
    }

    companion object {
        lateinit var instance: TrendingGitApp
    }
}