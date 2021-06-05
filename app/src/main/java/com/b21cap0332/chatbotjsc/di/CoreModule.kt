package com.b21cap0332.chatbotjsc.di

import com.b21cap0332.chatbotjsc.data.MessageRepository
import com.b21cap0332.chatbotjsc.data.source.remote.ApiService
import com.b21cap0332.chatbotjsc.data.source.remote.RemoteDataSource
import com.b21cap0332.chatbotjsc.domain.repository.IMessageRepository
import com.b21cap0332.chatbotjsc.domain.usecase.MessageInteractor
import com.b21cap0332.chatbotjsc.domain.usecase.MessageUseCase
import com.b21cap0332.chatbotjsc.ui.MainViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val useCaseModule = module {
    factory<MessageUseCase> { MessageInteractor(get()) }
}

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }

    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://35.219.51.72/api/v1/") //sample target api
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { RemoteDataSource(get()) }
    single<IMessageRepository> { MessageRepository(get()) }
}