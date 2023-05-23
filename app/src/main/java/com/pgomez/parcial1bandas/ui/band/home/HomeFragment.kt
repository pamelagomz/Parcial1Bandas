package com.pgomez.parcial1bandas.ui.band.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.pgomez.parcial1bandas.R
import com.pgomez.parcial1bandas.data.models.BandModel
import com.pgomez.parcial1bandas.databinding.FragmentHomeBinding
import com.pgomez.parcial1bandas.ui.band.home.recyclerview.BandRecyclerViewAdapter
import com.pgomez.parcial1bandas.ui.band.viewmodel.BandViewModel


class HomeFragment : Fragment() {

    private val bandViewModel: BandViewModel by activityViewModels {
        BandViewModel.Factory
    }

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: BandRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.floatingActionButton2.setOnClickListener {
            bandViewModel.clearData()
            it.findNavController().navigate(R.id.action_homeFragment_to_newBandFragment)
        }
    }

    private fun setRecyclerView(view: View){
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = BandRecyclerViewAdapter { selectedBand->
            showSelectedItem(selectedBand)

        }

        binding.recyclerView.adapter = adapter
        displayBands()

    }

    private fun displayBands() {
        adapter.setData(bandViewModel.getBands())
        adapter.notifyDataSetChanged()
    }

    private fun showSelectedItem(band: BandModel) {
        bandViewModel.setSelectedBand(band)
        findNavController().navigate(R.id.action_homeFragment_to_bandFragment)
    }


}