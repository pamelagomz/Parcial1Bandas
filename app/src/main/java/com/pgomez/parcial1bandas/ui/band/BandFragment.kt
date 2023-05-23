package com.pgomez.parcial1bandas.ui.band

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.pgomez.parcial1bandas.R
import com.pgomez.parcial1bandas.databinding.FragmentBandBinding
import com.pgomez.parcial1bandas.ui.band.viewmodel.BandViewModel


class BandFragment : Fragment() {

    private val bandViewModel: BandViewModel by activityViewModels {
        BandViewModel.Factory
    }

    private lateinit var binding: FragmentBandBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding = FragmentBandBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
    }

    private fun setViewModel(){
        binding.viewmodel = bandViewModel
    }


}