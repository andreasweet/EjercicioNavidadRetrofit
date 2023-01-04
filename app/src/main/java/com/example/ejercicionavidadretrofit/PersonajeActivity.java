package com.example.ejercicionavidadretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.ejercicionavidadretrofit.Modelos.DataItem;
import com.example.ejercicionavidadretrofit.databinding.ActivityPersonajeBinding;
import com.squareup.picasso.Picasso;

public class PersonajeActivity extends AppCompatActivity {

    private ActivityPersonajeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personaje);

        binding = ActivityPersonajeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        inicializarVistas();

    }

    private void inicializarVistas() {
        Bundle bundle = getIntent().getBundleExtra("BUNDLE");
        DataItem personaje = (DataItem) bundle.getSerializable("PERSONAJE");
        int p = bundle.getInt("POSICION");
        binding.lblIdPersonajeActivity.setText(String.valueOf(personaje.getId()));
        binding.lblNombrePersonajeActivity.setText(personaje.getName());
        binding.lblPeliculasPersonajeActivity.setText(personaje.getFilms().toString());
        binding.lblShortFilmsPersonajeActivity.setText(personaje.getShortFilms().toString());
        binding.lblTvShowsPersonajeActivity.setText(personaje.getTvShows().toString());
        binding.lblEnemiesPersonajeActivity.setText(personaje.getEnemies().toString());
        binding.lblAlliensPersonajeActivity.setText(personaje.getAllies().toString());
        binding.lblVideoGamesPersonajeActivity.setText(personaje.getVideoGames().toString());
        binding.lblParkAtrattionsPersonajeActivity.setText(personaje.getParkAttractions().toString());
        Picasso.get()
                .load(personaje.getImageUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(binding.imgPersonajeActivity);
    }
}