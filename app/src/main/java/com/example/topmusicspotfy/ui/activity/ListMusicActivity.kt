package com.example.topmusicspotfy.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.topmusicspotfy.R
import com.example.topmusicspotfy.data.Musics
import com.example.topmusicspotfy.ui.adapter.MusicsAdapter
import com.example.topmusicspotfy.viewModel.MusicsViewModel
import kotlinx.android.synthetic.main.activity_music_list.*
import kotlinx.android.synthetic.main.item_music.*

class ListMusicActivity : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProvider(
            this, ViewModelProvider.AndroidViewModelFactory(application)
        ).get(MusicsViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_list)

        my_toolbar.title = "Albuns"
        setSupportActionBar(my_toolbar)

        viewModel.listMusics()

        viewModel.loadLiveData.observe(this, Observer {
            pb_load.isVisible = it
        })

        viewModel.loadMessageLiveData.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
        viewModel.loadSuccesLiveData.observe(this, Observer {
            val adapter = MusicsAdapter(it)
            recycler_view.adapter = adapter
        })

        tv_favorite.setOnClickListener {

        }
    }
}