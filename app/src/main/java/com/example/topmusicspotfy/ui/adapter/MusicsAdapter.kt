package com.example.topmusicspotfy.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.topmusicspotfy.R
import com.example.topmusicspotfy.data.Musics

class MusicsAdapter(private val listaMusics: List<Musics>) :
    RecyclerView.Adapter<MusicsAdapter.MusicsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicsViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_music, parent, false)
        return MusicsViewHolder(itemView)
    }

    override fun getItemCount() = listaMusics.count()

    override fun onBindViewHolder(holder: MusicsViewHolder, position: Int) {
        holder.bindView(listaMusics[position])

    }

    class MusicsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val singleName = itemView.findViewById<TextView>(R.id.tv_nome_cantor)
        private val musicName = itemView.findViewById<TextView>(R.id.tv_nome_musica)
        private val musicYear = itemView.findViewById<TextView>(R.id.tv_ano_musica)
        private val favoriteSong = itemView.findViewById<TextView>(R.id.tv_favorite)

        fun bindView(musics: Musics) {
            singleName.text = musics.author
            musicName.text = musics.name
            musicYear.text = musics.year
            favoriteSong.isVisible = musics.like
        }
    }
}