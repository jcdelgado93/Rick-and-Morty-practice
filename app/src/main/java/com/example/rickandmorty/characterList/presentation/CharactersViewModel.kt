package com.example.rickandmorty.characterList.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.characterList.domain.GetCharacterUseCase
import com.example.rickandmorty.characterList.domain.model.Characters
import kotlinx.coroutines.launch
import java.lang.Exception

class CharactersViewModel(
    private val getCharactersUseCase: GetCharacterUseCase
) : ViewModel() {

    private val liveData = MutableLiveData<CharactersState>()

    fun getLiveData() = liveData

    fun getCharacters() {
        liveData.postValue(CharactersState.LoadingCharactersState)
        viewModelScope.launch {
            try {
                val result = getCharactersUseCase.execute()
                handleResult(result)
            } catch (exception: Exception) {
                handleError(exception)
            }
        }
    }

    private fun handleResult(result: Characters) {
        liveData.postValue(CharactersState.GetCharacters(result))
    }

    private fun handleError(exception: Exception) {
        liveData.postValue(CharactersState.Error(exception))
    }}