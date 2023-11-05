package com.veg.kotlincase.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.veg.kotlincase.model.CharacterModel

class DetailViewModel (character:CharacterModel,app:Application):AndroidViewModel(app){
    private val _selectedCharacter=MutableLiveData<CharacterModel>()
    val selectedCharacter:LiveData<CharacterModel>
       get() = _selectedCharacter

    init {
        _selectedCharacter.value=character
    }
}