package com.example.examenvidejuegos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetallePokemonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pokemon);

        String nombre = getIntent().getStringExtra("nombre");
        String tipo = getIntent().getStringExtra("tipo");
        String image = getIntent().getStringExtra("image");

        TextView tvNombre = findViewById(R.id.tvNombreDetail);
        TextView tvTipo = findViewById(R.id.tvTipoDetail);
        ImageView ivPokemon = findViewById(R.id.imgPokemonDetail);

        tvNombre.setText(nombre);
        tvTipo.setText(tipo);
        Glide.with(getApplicationContext()).load(image).override(300,300).into(ivPokemon);

        Button butonCaputar = findViewById(R.id.btnCapturar);
        butonCaputar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(),PokemonCapturadoListActivity.class);
                startActivity(intent1);
            }
        });

        Button butonUbicacion = findViewById(R.id.btnUbicacion);
        butonUbicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),UbicacionPokemon.class);
                startActivity(intent);
            }
        });


    }
}