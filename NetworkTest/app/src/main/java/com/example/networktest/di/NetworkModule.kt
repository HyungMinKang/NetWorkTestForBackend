package com.example.networktest.di

import com.example.networktest.data.network.Api
import com.example.networktest.data.network.DataSource
import com.example.networktest.data.network.RemoteDataSource
import com.example.networktest.data.repository.RepositoryImpl
import com.example.networktest.domain.Repository


import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val NetWorkModule = module {

    single<OkHttpClient>(named("Normal")) {
        OkHttpClient.Builder()
            .addInterceptor(get<Interceptor>(named("Interceptor")))
            .build()
    }

    single<Interceptor>(named("Interceptor")) {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    single<Retrofit>(named("LoginRetrofit")) {
        Retrofit.Builder()
            .baseUrl("http://163.239.223.177:18787/")  //baseurl
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .client(get(named("Normal")))
            .build()
    }

    single<Api> {
        get<Retrofit>(named("LoginRetrofit")).create(Api::class.java)
    }
    single<DataSource> { RemoteDataSource(get()) }
    single<Repository> { RepositoryImpl(get()) }
}