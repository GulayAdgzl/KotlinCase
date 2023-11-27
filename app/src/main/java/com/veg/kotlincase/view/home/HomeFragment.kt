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
    private val characterList= arrayListOf<CharacterModel>()

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

        //ekledim
        if (checkNetwork(requireContext())){
           observeLiveData()
        }else  Toast.makeText(context,"No connect", Toast.LENGTH_LONG).show()


        binding.swipeRefresh.setOnRefreshListener {
            if (checkNetwork(requireContext())){
                binding.swipeRefresh.isRefreshing = false
               observeLiveData()
            }else Toast.makeText(context,"No connect", Toast.LENGTH_LONG).show()
            binding.swipeRefresh.isRefreshing = false


        }


        recyclerCharacterAdapter.onClick = {
            viewmodel.displayCharacterDetail(it)

        }

        viewmodel.navigateToSelectedCharacter.observe(viewLifecycleOwner) { character ->
            character?.let {
                this.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(it))
                viewmodel.displayCharacterDetailComplete()
            }
        }
        binding.SearchView.setOnQueryTextListener(object  : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(msg: String): Boolean {
                filter(msg)
                return false
            }
        })
        binding.SearchView.setOnCloseListener(object : SearchView.OnCloseListener {
            override fun onClose(): Boolean {
                characterList.clear()
                //
                characterList.addAll(viewmodel.character.value ?: emptyList())
                recyclerCharacterAdapter.differ.submitList(characterList)
                if (checkNetwork(requireContext())){
                   observeLiveData()
                }else Toast.makeText(context,"No connect", Toast.LENGTH_LONG).show()
                return false
            }
        })

     //   observeLiveData()

    }


   fun observeLiveData() {
       viewmodel.character.observe(viewLifecycleOwner, Observer { characterList ->
           characterList?.let {
               // ViewModel'den gelen veriyle characterList'i doldur
               this.characterList.clear()
               this.characterList.addAll(it)

               binding.characterListRecycler.visibility = View.VISIBLE
               recyclerCharacterAdapter.differ.submitList(characterList)
           }
       })
   }
    private fun filter(text: String?){
        val filteredList: ArrayList<CharacterModel> = ArrayList()
        if (!text.isNullOrEmpty()) {
            for (item in characterList) {
                when {
                    item.name?.lowercase()?.contains(text.lowercase()) == true -> filteredList.add(item)
                   // item.username?.lowercase()?.contains(text.lowercase()) == true -> filteredList.add(item)
                   // item.email?.lowercase()?.contains(text.lowercase()) == true -> filteredList.add(item)
                }
            }
            if (!filteredList.isEmpty()){
                recyclerCharacterAdapter.differ.submitList(filteredList)
            }
        }
    }
    private fun checkNetwork(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                return true
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                return true
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                return true
            }
        }else{
            Toast.makeText(context,"Internet connection is not available.", Toast.LENGTH_LONG).show()
        }
        return false
    }
}


