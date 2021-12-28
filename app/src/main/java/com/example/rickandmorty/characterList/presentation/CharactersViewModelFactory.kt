package com.example.rickandmorty.characterList.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rickandmorty.characterList.domain.GetCharacterUseCase

class CharactersViewModelFactory(
    private val getApiUseCase : GetCharacterUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(GetCharacterUseCase::class.java)
            .newInstance(getApiUseCase)
    }
}