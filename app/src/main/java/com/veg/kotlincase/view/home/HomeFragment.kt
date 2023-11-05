package com.veg.kotlincase.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.veg.kotlincase.adapter.CharacterAdapter
import com.veg.kotlincase.databinding.FragmentHomeBinding
import com.veg.kotlincase.viewmodel.HomeViewModel

/*class HomeFragment : Fragment() {

   // private lateinit var viewmodel: HomeViewModel
   //4
   private val viewmodel:HomeViewModel by lazy {HomeViewModel()}
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

        // ViewModel'i oluşturun ve bağlayın
        //viewmodel = ViewModelProvider(this).get(HomeViewModel::class.java)
        binding.viewmodel = viewmodel

        // RecyclerView ayarları
        binding.characterListRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.characterListRecycler.adapter = recyclerCharacterAdapter

        recyclerCharacterAdapter.onClick={
            viewmodel.displayCharacterDetail(it)
        }
        viewmodel.navigateToSelectedCharacter.observe(viewLifecycleOwner){
            if(it !=null){
                this.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(it))
                viewmodel.displayCharacterDetailComplete()
            }
        }

        observeLiveData()
    }
    fun observeLiveData(){
        viewmodel.character.observe(this,Observer{characterList->
            characterList?.let {
                binding.characterListRecycler.visibility=View.VISIBLE
                recyclerCharacterAdapter.submitList(characterList)
            }
        })


    }
}
*/
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
