package com.example.examenvidejuegos.servicies;

import com.example.examenvidejuegos.entities.Entrenador;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface EntrenadorService {
    @GET("entrenador/N00017665")
    Call<Entrenador> getEntrenador();

    @POST("entrenador/N00017665")
    Call<Entrenador> postEntrenador(@Body Entrenador entrenador);
}
