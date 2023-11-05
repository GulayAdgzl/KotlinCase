package com.veg.kotlincase.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.veg.kotlincase.databinding.CharacterItemDesignBinding
import com.veg.kotlincase.model.CharacterModel

class CharacterAdapter: ListAdapter<CharacterModel, CharacterAdapter.CharacterViewHolder>(DiffCallBack) {
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
    override fun onBindViewHolder(holder:CharacterAdapter.CharacterViewHolder,position:Int){
        //5
        val character=getItem(position)
        holder.bind(character,onClick)
    }
    class CharacterViewHolder(private val binding:CharacterItemDesignBinding):RecyclerView.ViewHolder(binding.root){
        //2
        fun bind(characters:CharacterModel,
        onClick:(CharacterModel)->Unit={}){
            binding.characterModel=characters
            binding.executePendingBindings()

            binding.root.setOnClickListener {
                onClick(characters)
            }


        }
    }
    companion object DiffCallBack: DiffUtil.ItemCallback<CharacterModel>(){

        override fun areItemsTheSame(oldItem: CharacterModel, newItem: CharacterModel): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(oldItem: CharacterModel, newItem: CharacterModel): Boolean {
            return oldItem==newItem
        }


    }


}




