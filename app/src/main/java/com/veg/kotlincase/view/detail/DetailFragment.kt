package com.veg.kotlincase.view.detail


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.veg.kotlincase.databinding.FragmentDetailBinding
import com.veg.kotlincase.view.home.HomeFragmentDirections
import com.veg.kotlincase.viewmodel.DetailViewModel


class DetailFragment : DialogFragment() {
    private lateinit var binding:FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner=this
        val selectedCharacter=DetailFragmentArgs.fromBundle(requireArguments()).selectedCharacter
        val viewModelFactory=DetailViewModelFactory(selectedCharacter,requireActivity().application)
        binding.detailViewModel=ViewModelProvider(this,viewModelFactory)[DetailViewModel::class.java]

        binding.imageBack.setOnClickListener {
            this.findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToHomeFragment())
            //(HomeFragmentDirections.actionHomeFragmentToDetailFragment())
        }
    }
}
