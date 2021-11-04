package com.example.examenvidejuegos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.examenvidejuegos.adapters.PokemonAdapter;
import com.example.examenvidejuegos.entities.Pokemon;
import com.example.examenvidejuegos.servicies.PokemonService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokemonCapturadoListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_capturado_list);

        String nombre1 = getIntent().getStringExtra("nombre");
        String tipo1 = getIntent().getStringExtra("tipo");
        String image1 = getIntent().getStringExtra("image");


        TextView tvnombrecapturar = findViewById(R.id.tvNombrePokemonCapturado);
        TextView tvtipoCapturar = findViewById(R.id.tvTipoPokemonCapturado);
        ImageView imgCapturar = findViewById(R.id.imgPokemonCapturado);

        tvnombrecapturar.setText(nombre1);
        tvtipoCapturar.setText(tipo1);
        Glide.with(getApplicationContext()).load(image1).override(300,300).into(imgCapturar);



    }
}