package com.example.rickandmorty.characterList.data.remote

import com.example.rickandmorty.characterList.domain.CharactersRepository
import com.example.rickandmorty.characterList.domain.model.Characters

class RemoteCharactersRepository(
    private val apiRepository : RickAndMortyApi,
    private val charactersMapper: CharactersMapper
) : CharactersRepository {

    override suspend fun getCharactersApi(): Characters {
        val characters = apiRepository.getCharacters()
        return charactersMapper.mapToEntityCharacters(characters)
    }
}