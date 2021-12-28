package com.example.rickandmorty.characterList.data.remote

import retrofit2.http.GET

interface RickAndMortyApi {

    @GET("character")
    suspend fun getCharacters() : CharactersModel
}