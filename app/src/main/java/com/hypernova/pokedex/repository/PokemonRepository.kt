package com.hypernova.pokedex.repository

import com.hypernova.pokedex.data.remote.PokeApi
import com.hypernova.pokedex.data.remote.response.Pokemon
import com.hypernova.pokedex.data.remote.response.PokemonList
import com.hypernova.pokedex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(private val apiInstance: PokeApi) {
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val res = try {
            apiInstance.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error(message = "An error occurred")
        }
        return Resource.Success(res)
    }

    suspend fun getPokemonInfo(name: String): Resource<Pokemon> {
        val res = try {
            apiInstance.getPokemonInfo(name)
        } catch (e: Exception) {
            return Resource.Error(message = "An error occurred")
        }
        return Resource.Success(res)
    }
}