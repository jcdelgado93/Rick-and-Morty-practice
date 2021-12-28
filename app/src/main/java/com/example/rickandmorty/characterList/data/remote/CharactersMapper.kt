package com.example.rickandmorty.characterList.data.remote

import com.example.rickandmorty.characterList.domain.model.Characters
import com.example.rickandmorty.characterList.domain.model.CharactersDetails

class CharactersMapper {

    fun mapToEntityCharacters(charactersModel: CharactersModel): Characters {
        charactersModel.apply {
            val charactersList: MutableList<CharactersDetails> = ArrayList()
            return Characters(charactersList)
        }
    }
}