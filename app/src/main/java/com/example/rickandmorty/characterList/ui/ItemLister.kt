package com.example.rickandmorty.characterList.ui

import com.example.rickandmorty.characterList.domain.model.CharactersDetails

interface ItemLister {
    fun onItemClick(charactersDetails: CharactersDetails)
}