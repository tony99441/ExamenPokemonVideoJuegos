package com.example.examenvidejuegos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRegistrar = findViewById(R.id.btnRegistrarEntrenador);
        Button btnDetalle = findViewById(R.id.btnDetalleEntrenador);
        Button btnListarPokemons = findViewById(R.id.btnListarPokemons);
        Button btnPokemonCapturado = findViewById(R.id.btnPokemonsCapturados);
        Button btnCrearPokemon = findViewById(R.id.btnCrearPokemon);



        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FormEntrenadorActivity.class);
                startActivity(intent);
            }
        });

        btnDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetalleEntrenadorActivity.class);
                startActivity(intent);
            }
        });

        btnListarPokemons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PokemonListActivity.class);
                startActivity(intent);
            }
        });

        btnPokemonCapturado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PokemonCapturadoListActivity.class);
                startActivity(intent);
            }
        });

        btnCrearPokemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FormPokemonActivity.class);
                startActivity(intent);
            }
        });


    }
}