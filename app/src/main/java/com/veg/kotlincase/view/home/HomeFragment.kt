package com.veg.kotlincase.view.home

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.EditText
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.veg.kotlincase.R
import com.veg.kotlincase.adapter.CharacterAdapter
import com.veg.kotlincase.databinding.FragmentHomeBinding
import com.veg.kotlincase.model.CharacterModel
import com.veg.kotlincase.viewmodel.HomeViewModel


class HomeFragment : Fragment() {

    private val viewmodel: HomeViewModel by lazy {
        ViewModelProvider(this).get(HomeViewModel::class.java)
    }
    private val recyclerCharacterAdapter = CharacterAdapter()
    private lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        binding.viewmodel = viewmodel

        // RecyclerView ayarları
        binding.characterListRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.characterListRecycler.adapter = recyclerCharacterAdapter

        recyclerCharacterAdapter.onClick = {
            viewmodel.displayCharacterDetail(it)

        }

        viewmodel.navigateToSelectedCharacter.observe(viewLifecycleOwner) { character ->
            character?.let {
                this.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(it))
                viewmodel.displayCharacterDetailComplete()
            }
        }
        observeLiveData()

    }



    fun observeLiveData() {
        viewmodel.character.observe(viewLifecycleOwner, Observer { characterList ->
            characterList?.let {
                binding.characterListRecycler.visibility = View.VISIBLE
                recyclerCharacterAdapter.submitList(characterList)
            }
        })

    }




}



