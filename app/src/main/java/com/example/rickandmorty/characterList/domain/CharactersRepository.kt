package com.example.rickandmorty.characterList.domain

import com.example.rickandmorty.characterList.domain.model.Characters

interface CharactersRepository {
    suspend fun getCharactersApi(): Characters
}