package com.veg.kotlincase.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.veg.kotlincase.model.CharacterModel
import com.veg.kotlincase.servis.CharacterApi
import kotlinx.coroutines.launch
import java.lang.Exception

enum class CharacterApiStatus{LOADING,ERROR,DONE}
class HomeViewModel:ViewModel() {

    private val _status=MutableLiveData<CharacterApiStatus>()
    val status:LiveData<CharacterApiStatus>
        get() = _status

    private val _character=MutableLiveData<List<CharacterModel>>()
    val character:LiveData<List<CharacterModel>>
       get() = _character


    private val _navigateToSelectedCharacter=MutableLiveData<CharacterModel?>()
    val navigateToSelectedCharacter:LiveData<CharacterModel ?>
       get() = _navigateToSelectedCharacter






    init {
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch {
            _status.value = CharacterApiStatus.LOADING
            try {
                val characters = CharacterApi.retrofitService.getCharacter()
                _character.value = characters

                _status.value = CharacterApiStatus.DONE
            } catch (e: Exception) {
                _status.value = CharacterApiStatus.ERROR
                _character.value = ArrayList()
            }
        }
    }

    fun displayCharacterDetail(characterModel:CharacterModel){
        _navigateToSelectedCharacter.value=characterModel
    }

    fun displayCharacterDetailComplete() {
        _navigateToSelectedCharacter.value = null
    }









}

