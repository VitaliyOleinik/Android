package com.ankit.trendinggit.di

import com.ankit.trendinggit.model.RepoRepository
import com.ankit.trendinggit.model.api.ApiService
import com.ankit.trendinggit.view.ui.myRepoList.MyRepoListViewModel
import com.ankit.trendinggit.view.ui.repolist.RepoListViewModel
import com.ankit.trendinggit.view.utils.Constants
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val viewModelModule = module {
    viewModel {
        RepoListViewModel(get())
    }
    viewModel {
        MyRepoListViewModel(get())
    }
}

val repositoryModule = module {
    single {
        RepoRepository(get())
    }
}

val apiModule = module {
    fun provideUseApi(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
    single { provideUseApi(get()) }
}

val retrofitModule = module {

    fun provideGson(): Gson {
        return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create()
    }

    fun provideHttpClient(): OkHttpClient {

        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(Constants.REQUEST_TIMEOUT_DURATION.toLong(), TimeUnit.SECONDS)
            .readTimeout(Constants.REQUEST_TIMEOUT_DURATION.toLong(), TimeUnit.SECONDS)
            .writeTimeout(Constants.REQUEST_TIMEOUT_DURATION.toLong(), TimeUnit.SECONDS)
            .build()
    }

    fun provideRetrofit(factory: Gson, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create(factory))
            .client(client)
            .build()
    }

    single { provideGson() }
    single { provideHttpClient() }
    single { provideRetrofit(get(), get()) }
}