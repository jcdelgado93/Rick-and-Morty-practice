package com.example.rickandmorty.characterList.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.characterList.domain.model.CharactersDetails
import com.example.rickandmorty.databinding.ItemCharacterBinding

class CharactersAdapter(
    private val character: List<CharactersDetails>,
    private val listener: ItemLister
) : RecyclerView.Adapter<CharactersViewHolder>() {

    private lateinit var binding: ItemCharacterBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharactersViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        holder.bind(character[position])
    }

    override fun getItemCount(): Int {
        return character.size
    }
}