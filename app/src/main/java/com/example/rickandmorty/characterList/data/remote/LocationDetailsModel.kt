package com.example.rickandmorty.characterList.data.remote

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LocationDetailsModel(
    val name: String,
    val url: String
)
