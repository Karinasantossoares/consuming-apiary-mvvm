package com.example.topmusicspotfy.service

import com.example.topmusicspotfy.repository.dto.MusicDTO
import retrofit2.Call
import retrofit2.http.GET

interface MusicsService {
    @GET("musics")
    fun listMusics():Call<List<MusicDTO>>
}