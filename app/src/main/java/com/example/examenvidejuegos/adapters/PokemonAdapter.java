package com.example.examenvidejuegos.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.example.examenvidejuegos.DetallePokemonActivity;
import com.example.examenvidejuegos.PokemonCapturadoListActivity;
import com.example.examenvidejuegos.R;
import com.example.examenvidejuegos.entities.Pokemon;

import java.util.List;


public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {
    List<Pokemon> pokemons;

    public PokemonAdapter(List<Pokemon> pokemons) {this.pokemons = pokemons;}

    @NonNull
    @Override
    public PokemonAdapter.PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);
        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonAdapter.PokemonViewHolder holder, int position) {

        View view = holder.itemView;
        Pokemon pokemon = pokemons.get(position);

        ImageView ivPokemon = view.findViewById(R.id.imgPokemon);
        TextView tvNombrePokemon = view.findViewById(R.id.tvNombrePokemon);
        TextView tvTipoPokemon = view.findViewById(R.id.tvTipoPokemon);

        Glide.with(view).asBitmap().load(pokemon.url_imagen).override(200,200).transform(new CircleCrop()).into(ivPokemon);
        tvNombrePokemon.setText(pokemon.nombre);
        tvTipoPokemon.setText(pokemon.tipo);

        Button btnDetailPokemon = view.findViewById(R.id.btnVerDetalle);

        btnDetailPokemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), DetallePokemonActivity.class);
                intent.putExtra("nombre", pokemon.nombre);
                intent.putExtra("tipo", pokemon.tipo);
                intent.putExtra("image", pokemon.url_imagen);
                view.getContext().startActivity(intent);
            }
        });

    //    Button buttoncaputar = view.findViewById(R.id.btnCapturar);
      //  buttoncaputar.setOnClickListener(new View.OnClickListener() {
        //    @Override
          //  public void onClick(View v) {


            //    Intent intent = new Intent(view.getContext(),PokemonCapturadoListActivity.class);
             //   view.getContext().startActivity(intent);


            //}
        //});




    }

    @Override
    public int getItemCount() {
        return pokemons.size();
    }
    public static class PokemonViewHolder extends RecyclerView.ViewHolder {public PokemonViewHolder(View itemView) {super(itemView);}}
}
