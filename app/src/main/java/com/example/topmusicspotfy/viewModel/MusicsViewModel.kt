package com.example.topmusicspotfy.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.topmusicspotfy.data.Musics
import com.example.topmusicspotfy.repository.MusicsRepository
import com.example.topmusicspotfy.repository.dto.MusicDTO

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MusicsViewModel : ViewModel() {
    val repository by lazy { MusicsRepository() }
    val loadLiveData = MutableLiveData<Boolean>()
    val loadSuccesLiveData = MutableLiveData<List<Musics>>()
    val loadMessageLiveData = MutableLiveData<String>()

    fun listMusics() {
        loadLiveData.value = true
        repository.listMusics().enqueue(object : Callback<List<MusicDTO>> {

            override fun onResponse(call: Call<List<MusicDTO>>, response: Response<List<MusicDTO>>) {
                loadLiveData.value = false
                if (response.isSuccessful) {
                    loadSuccesLiveData.value = response.body()?.map {
                        Musics(it.name,it.author,it.year,it.like)
                    }
                }else{
                    loadMessageLiveData.value = response.message()
                }
            }

            override fun onFailure(call: Call<List<MusicDTO>>, t: Throwable) {
                loadLiveData.value = false
                loadMessageLiveData.value = t.message
            }






        })
    }

}