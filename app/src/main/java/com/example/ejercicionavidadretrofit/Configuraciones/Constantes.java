package com.example.ejercicionavidadretrofit.Configuraciones;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Constantes {

    public static final String BASE_URL = "https://api.disneyapi.dev/";

    public static Retrofit getConnection() {
        return new Retrofit.Builder() .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
