package com.yarendemirkaya.pokemonapp.data.repositories

import com.yarendemirkaya.pokemonapp.data.model.PokemonResponse
import com.yarendemirkaya.pokemonapp.data.network.RetrofitClient
import retrofit2.Response

class PokemonRepositoryImpl:PokemonRepository {
    override suspend fun getAllPokemons(limit: Int, offset: Int): Response<PokemonResponse> {
        return RetrofitClient.instance.getAllPokemons(limit, offset)
    }
}