package com.veg.kotlincase.adapter

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.veg.kotlincase.R
import com.veg.kotlincase.model.CharacterModel
import com.veg.kotlincase.viewmodel.CharacterApiStatus


//1
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView:RecyclerView ,data:List<CharacterModel>?){
    val adapter=recyclerView.adapter as CharacterAdapter
    adapter.submitList(data)
}

//2
@BindingAdapter("characterApiStatus")
fun bindStatus(statusImageView:ImageView,status: CharacterApiStatus?){
    when(status){
        CharacterApiStatus.LOADING->{
            statusImageView.visibility= View.GONE
            statusImageView.setImageResource(R.drawable.animation)
        }
        CharacterApiStatus.DONE->{
            statusImageView.visibility=View.GONE
        }
        else->{
            statusImageView.visibility=View.GONE
            statusImageView.setImageResource(R.drawable.animation)
        }
    }
}

