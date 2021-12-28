package com.example.rickandmorty.characterList.data.remote

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharactersModel(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: LocationDetailsModel,
    val location: LocationDetailsModel,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
)