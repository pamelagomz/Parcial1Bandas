package com.pgomez.parcial1bandas.ui.band.home.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pgomez.parcial1bandas.data.models.BandModel
import com.pgomez.parcial1bandas.databinding.BandItemBinding

class BandRecyclerViewAdapter(private val clickListener: (BandModel) -> Unit):
RecyclerView.Adapter<BandRecyclerViewHolder>()
{
    private val bands = ArrayList<BandModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BandRecyclerViewHolder {
        val binding = BandItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return BandRecyclerViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return bands.size
    }

    override fun onBindViewHolder(holder: BandRecyclerViewHolder, position: Int) {
        val band = bands[position]
        holder.bind(band, clickListener)

    }

    fun setData(bandList: List<BandModel>) {
        bands.clear()
        bands.addAll(bandList)
    }


}









