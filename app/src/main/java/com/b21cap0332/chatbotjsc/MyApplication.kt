package com.b21cap0332.chatbotjsc

import android.app.Application
import com.b21cap0332.chatbotjsc.di.networkModule
import com.b21cap0332.chatbotjsc.di.repositoryModule
import com.b21cap0332.chatbotjsc.di.useCaseModule
import com.b21cap0332.chatbotjsc.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(level = Level.NONE)
            modules(
                listOf(
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule,
                )
            )
        }
    }
}