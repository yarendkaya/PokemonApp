package com.yarendemirkaya.pokemonapp.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yarendemirkaya.pokemonapp.data.model.PokemonResponse
import com.yarendemirkaya.pokemonapp.data.repositories.PokemonRepository
import com.yarendemirkaya.pokemonapp.data.repositories.PokemonRepositoryImpl
import kotlinx.coroutines.launch
import retrofit2.Response

class PokemonViewModel : ViewModel() {
    private val _pokemonResponse = MutableLiveData<Response<PokemonResponse>>()
    val pokemonResponse: LiveData<Response<PokemonResponse>> = _pokemonResponse

    private val pokemonRepository: PokemonRepository = PokemonRepositoryImpl()
    fun getAllPokemons() {
        viewModelScope.launch {
            val response = pokemonRepository.getAllPokemons()
            if (response.isSuccessful) {
                val pokemonResponse = response.body()
                _pokemonResponse.postValue(response)

                Log.d("PokemonViewModel", "Pokemon Response: $pokemonResponse")
            } else {
                Log.e("PokemonViewModel", "Error: ${response.code()}")
            }
        }
    }
}