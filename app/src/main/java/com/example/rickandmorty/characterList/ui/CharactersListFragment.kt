package com.example.rickandmorty.characterList.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmorty.R
import com.example.rickandmorty.characterList.data.remote.CharactersMapper
import com.example.rickandmorty.characterList.data.remote.RemoteCharactersRepository
import com.example.rickandmorty.characterList.domain.GetCharacterUseCase
import com.example.rickandmorty.characterList.domain.model.Characters
import com.example.rickandmorty.characterList.domain.model.CharactersDetails
import com.example.rickandmorty.characterList.presentation.CharactersState
import com.example.rickandmorty.characterList.presentation.CharactersViewModel
import com.example.rickandmorty.characterList.presentation.CharactersViewModelFactory
import com.example.rickandmorty.databinding.FragmentCharactersListBinding
import com.example.rickandmorty.network.api.RetrofitHandler
import com.example.rickandmorty.util.extentions.alert

class CharactersListFragment : Fragment(R.layout.fragment_characters_list) {

    private lateinit var binding: FragmentCharactersListBinding
    private lateinit var charactersAdapter: CharactersAdapter
    private lateinit var charactersViewModel: CharactersViewModel
    private lateinit var charactersViewModelFactory: CharactersViewModelFactory

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBind(view)
        setupDependencies()
        setupLiveData()
        setupRecyclerView()
        getViewModel()
    }

        private fun setupBind(view: View) {
        binding = FragmentCharactersListBinding.bind(view)
    }

    private fun setupDependencies() {
        charactersViewModelFactory = CharactersViewModelFactory(
            GetCharacterUseCase(
                RemoteCharactersRepository(
                    RetrofitHandler.getCharacters(),
                    CharactersMapper()
                )
            )
        )
    }

    private fun setupLiveData() {
        charactersViewModel.getLiveData().observe(
            viewLifecycleOwner,
            { state -> handleState(state) }
        )
        charactersViewModel.getCharacters()
    }

    private fun handleState(state: CharactersState?) {
        when (state) {
            is CharactersState.LoadingCharactersState -> showLoadingAnimation()
            is CharactersState.GetCharacters -> state.charactersResult?.let { showCharacters(it) }
            is CharactersState.Error -> state.error?.let { showError(it) }
        }
    }

    private fun showLoadingAnimation() {
        alert("Cargando listado...")
    }

    private fun showCharacters(it: Characters) {
        charactersAdapter = CharactersAdapter(it.charactersList, object : ItemLister{
            override fun onItemClick(charactersDetails: CharactersDetails) {
                view?.let { safeView ->
                    Navigation.findNavController(safeView)
                        .navigate(
                            R.id.action_charactersListFragment_to_charactersDetailsFragment,
                            charactersDetailsBundle(charactersDetails)
                        )
                }
            }
        } )
        binding.rvCharactersList.adapter = charactersAdapter
    }

    private fun showError(it: Throwable) {
        alert("Error: ${it.message}")
    }

    private fun setupRecyclerView() {
        binding.apply {
            rvCharactersList.setHasFixedSize(true)
            rvCharactersList.layoutManager = LinearLayoutManager(requireContext())
            rvCharactersList.itemAnimator = DefaultItemAnimator()
        }
    }

    private fun getViewModel() {
        charactersViewModel.getCharacters()
    }
}