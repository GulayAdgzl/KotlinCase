package com.veg.kotlincase.view.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.veg.kotlincase.model.CharacterModel
import com.veg.kotlincase.viewmodel.DetailViewModel

class DetailViewModelFactory(private val characterModel:CharacterModel,private val application: Application):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DetailViewModel::class.java)){
            return DetailViewModel(characterModel,application) as T
        }
        throw  IllegalArgumentException("Umknown ViewModel class")
    }
}