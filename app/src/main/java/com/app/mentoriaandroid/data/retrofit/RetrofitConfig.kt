package com.app.mentoriaandroid.data.retrofit

import com.app.mentoriaandroid.BuildConfig
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

fun getInstance(): Retrofit {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = (HttpLoggingInterceptor.Level.BODY)
    val client: OkHttpClient = OkHttpClient().newBuilder()
        .addInterceptor(interceptor)
        .callTimeout(1, TimeUnit.MINUTES)
        .connectTimeout(1, TimeUnit.MINUTES)
        .readTimeout(1, TimeUnit.MINUTES)
        .writeTimeout(1, TimeUnit.MINUTES)
        .build()
    return Retrofit.Builder()
        .client(client)
        .baseUrl(BuildConfig.BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}