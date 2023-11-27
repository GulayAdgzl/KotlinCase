package com.veg.kotlincase.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.veg.kotlincase.databinding.CharacterItemDesignBinding
import com.veg.kotlincase.model.CharacterModel

class CharacterAdapter:RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>()
   // ListAdapter<CharacterModel, CharacterAdapter.CharacterViewHolder>()
{
    private val differCallback = object : DiffUtil.ItemCallback<CharacterModel>() {
        override fun areItemsTheSame(oldItem: CharacterModel, newItem: CharacterModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: CharacterModel, newItem: CharacterModel): Boolean {
            return oldItem == newItem
        }
    }
   var onClick:(CharacterModel)->Unit={}

    override fun onCreateViewHolder(
        parent:ViewGroup,
        viewType:Int
    ) :CharacterAdapter.CharacterViewHolder{
        //4
        return CharacterViewHolder( CharacterItemDesignBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false
        )
        )
    }
    val differ=AsyncListDiffer(this,differCallback)
    override fun onBindViewHolder(holder:CharacterAdapter.CharacterViewHolder,position:Int){
        //5
        val character=differ.currentList[position]
            //getItem(position)
        holder.bind(character,onClick)
    }
    class CharacterViewHolder(private val binding:CharacterItemDesignBinding):RecyclerView.ViewHolder(binding.root){
        //2
        fun bind(characters:CharacterModel,
        onClick:(CharacterModel)->Unit={}){
            binding.characterModel=characters
            binding.executePendingBindings()

            binding.imageNext.setOnClickListener {
                onClick(characters)
            }
        }

    }

    override fun getItemCount(): Int =differ.currentList.size


}




