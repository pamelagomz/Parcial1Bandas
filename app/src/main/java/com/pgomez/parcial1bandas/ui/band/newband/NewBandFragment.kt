package com.pgomez.parcial1bandas.ui.band.newband

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.pgomez.parcial1bandas.R
import com.pgomez.parcial1bandas.databinding.FragmentBandBinding
import com.pgomez.parcial1bandas.databinding.FragmentNewBandBinding
import com.pgomez.parcial1bandas.ui.band.viewmodel.BandViewModel


class NewBandFragment : Fragment() {

    private val bandViewModel: BandViewModel by activityViewModels {
        BandViewModel.Factory
    }

    private lateinit var binding: FragmentNewBandBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewBandBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        setObserver()
    }

    private fun setViewModel(){

        binding.viewmodel = bandViewModel


    }

    private fun setObserver() {
        bandViewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(BandViewModel.WRONG_INFORMATION) -> {
                    bandViewModel.clearStatus()
                }
                status.equals(BandViewModel.BAND_CREATED) -> {
                    bandViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }


}
