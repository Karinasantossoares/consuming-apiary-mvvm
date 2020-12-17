package com.example.topmusicspotfy.repository

import com.example.topmusicspotfy.repository.retrofit.RetrofitConfig
import com.example.topmusicspotfy.service.MusicsService

class MusicsRepository {
    private val retrofitConfig by lazy { RetrofitConfig() }
    private val service by lazy { retrofitConfig.musicsService }

    fun listMusics() = service.listMusics()
}