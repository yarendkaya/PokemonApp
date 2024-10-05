package com.yarendemirkaya.pokemonapp.data.repositories

import com.yarendemirkaya.pokemonapp.data.model.PokemonResponse
import retrofit2.Response

interface PokemonRepository {

    suspend fun getAllPokemons(limit: Int = 20, offset: Int = 0): Response<PokemonResponse>

}