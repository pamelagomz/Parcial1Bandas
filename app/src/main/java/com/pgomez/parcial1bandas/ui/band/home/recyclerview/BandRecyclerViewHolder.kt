package com.pgomez.parcial1bandas.ui.band.home.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.pgomez.parcial1bandas.data.models.BandModel
import com.pgomez.parcial1bandas.databinding.BandItemBinding

class BandRecyclerViewHolder(private val binding: BandItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(band: BandModel, clickListener: (BandModel) -> Unit) {
        binding.textViewName.text = band.name
        binding.textViewGenre.text = band.genre


        binding.bandItemCard.setOnClickListener{
            clickListener(band)
        }
    }
}