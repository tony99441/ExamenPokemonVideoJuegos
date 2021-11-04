package com.example.examenvidejuegos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.examenvidejuegos.entities.Pokemon;
import com.example.examenvidejuegos.servicies.PokemonService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FormPokemonActivity extends AppCompatActivity {

    private ListView lista;
    List<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_pokemon);

        EditText edtNombre = findViewById(R.id.edtNombrePokemon);
        EditText edtTipo = findViewById(R.id.edtTipoPokemon);
        EditText edtImg = findViewById(R.id.edtUrlImagenPokemon);
        Button btnSubmitPokemon = findViewById(R.id.btnSubmitPokemonForm);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://upn.lumenes.tk/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PokemonService service = retrofit.create(PokemonService.class);

        btnSubmitPokemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre = edtNombre.getText().toString();
                String tipo = edtTipo.getText().toString();
                String image = edtImg.getText().toString();

             //  Pokemon pokemon = new Pokemon(nombre, tipo, image);

               // Call<Pokemon> pokemonCall = service.postPokemon(pokemon);
                // pokemonCall.enqueue(new Callback<Pokemon>() {
                //    @Override
                //  public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                        //codigo que recibe al haber esperado el call

                //  }

                //  @Override
                //  public void onFailure(Call<Pokemon> call, Throwable t) {

                //  }
                // });
                //Intent intent = new Intent(FormPokemonActivity.this, PokemonListActivity.class);
                //startActivity(intent);

            }
        });


    }
}