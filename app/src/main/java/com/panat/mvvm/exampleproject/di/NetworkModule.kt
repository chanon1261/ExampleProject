package com.panat.mvvm.exampleproject.di

import com.panat.mvvm.exampleproject.service.GithubService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val NetworkModule = module {

    factory { provideRetrofit() }
    factory { provideGithubService(get()) }

}

fun provideRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
}

fun provideGithubService(retrofit: Retrofit): GithubService =
    retrofit.create(GithubService::class.java)
