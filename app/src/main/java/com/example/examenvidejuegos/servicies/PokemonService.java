package com.example.examenvidejuegos.servicies;

import com.example.examenvidejuegos.entities.Entrenador;
import com.example.examenvidejuegos.entities.Pokemon;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PokemonService {
    @GET("pokemons/N00031931")
    retrofit2.Call<List<Pokemon>> getPokemons();

    @POST("pokemons/N00031931/crear")
    Call<Pokemon> postPokemon(@Body Pokemon pokemon);
}
