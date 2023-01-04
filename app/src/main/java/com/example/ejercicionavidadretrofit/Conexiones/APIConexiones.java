package com.example.ejercicionavidadretrofit.Conexiones;

import com.example.ejercicionavidadretrofit.Modelos.Response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIConexiones {

    @GET("/characters")
    Call<Response> getResponse();

   @GET("/characters/{id}")
    Call<Response> getCharacter(@Path("id")int id);
}
