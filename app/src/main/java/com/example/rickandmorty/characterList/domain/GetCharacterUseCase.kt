package com.example.rickandmorty.characterList.domain

import com.example.rickandmorty.characterList.domain.model.Characters

class GetCharacterUseCase(
    private val charactersRepository: CharactersRepository
) {
    suspend fun execute() : Characters = charactersRepository.getCharactersApi()
}