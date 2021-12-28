package com.example.rickandmorty.util

import android.os.Bundle
import com.example.rickandmorty.characterList.domain.model.CharactersDetails

const val NAME = "name"
const val STATUS = "status"
const val SPECIES = "species"
const val TYPE = "type"
const val GENDER = "gender"
const val IMAGE = "image"
const val URL = "url"
const val CREATED = "created"

fun charactersDeatilsBundle(charactersDetails: CharactersDetails): Bundle {
    val bundle = Bundle()
    bundle.putString(NAME, charactersDetails.name)
    bundle.putString(STATUS, charactersDetails.status)
    bundle.putString(SPECIES, charactersDetails.species)
    bundle.putString(TYPE, charactersDetails.type)
    bundle.putString(GENDER, charactersDetails.gender)
    bundle.putString(IMAGE, charactersDetails.image)
    bundle.putString(URL, charactersDetails.url)
    bundle.putString(CREATED, charactersDetails.created)
    return bundle
}

fun characterDeatilBundle(bundle: Bundle): CharactersDetails {
    val name = bundle.getString(NAME)
    val status = bundle.getString(STATUS)
    val species = bundle.getString(SPECIES)
    val type = bundle.getString(TYPE)
    val gender = bundle.getString(GENDER)
    val image = bundle.getString(IMAGE)
    val url = bundle.getString(URL)
    val created = bundle.getString(CREATED)
    return CharactersDetails(name, status, species, type, gender, image, url, created)
}