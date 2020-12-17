package com.example.topmusicspotfy.repository.retrofit

import com.example.topmusicspotfy.service.MusicsService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {
    private fun initRetrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = (HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient().newBuilder().addInterceptor(interceptor).build()
        return Retrofit.Builder()
            .client(client)
            .baseUrl("https://private-25f4da-apistudent.apiary-mock.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val musicsService = initRetrofit().create(MusicsService::class.java)
}