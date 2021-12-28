package com.example.rickandmorty.characterList.presentation

import com.example.rickandmorty.characterList.domain.model.Characters
import com.example.rickandmorty.characterList.domain.model.CharactersDetails

sealed class CharactersState(
    open val charactersResult: Characters? = null,
    open val charactersDetailsResult: CharactersDetails? = null,
    open val error: Throwable? = null
) {
    object LoadingCharactersState : CharactersState()
    data class GetCharacters(override val charactersResult: Characters?) : CharactersState(charactersResult = charactersResult)
    data class GetCharactersDetails(override val charactersDetailsResult : CharactersDetails?) : CharactersState(charactersDetailsResult = charactersDetailsResult)
    data class Error(override val error : Throwable?) : CharactersState(error = error)
}