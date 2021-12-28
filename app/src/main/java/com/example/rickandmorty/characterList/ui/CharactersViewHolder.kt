package com.example.rickandmorty.characterList.ui

import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.characterList.domain.model.CharactersDetails
import com.example.rickandmorty.databinding.ItemCharacterBinding
import com.squareup.picasso.Picasso

class CharactersViewHolder(
    private val binding: ItemCharacterBinding,
    private val listener: ItemLister
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(character : CharactersDetails) {
        binding.apply {
            tvName.text = character.name
            tvStatus.text = character.status
            tvCreateDate.text = character.created
            Picasso.get().load(character.image).into(ivAvatar)
        }
    }
}