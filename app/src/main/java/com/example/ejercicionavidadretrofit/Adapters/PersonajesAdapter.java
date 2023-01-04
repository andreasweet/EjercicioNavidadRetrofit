package com.example.ejercicionavidadretrofit.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejercicionavidadretrofit.Modelos.DataItem;
import com.example.ejercicionavidadretrofit.PersonajeActivity;
import com.example.ejercicionavidadretrofit.R;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PersonajesAdapter extends RecyclerView.Adapter<PersonajesAdapter.PersonajeVH>{

    private List<DataItem> objects;
    private Context context;
    private int resource;


    public PersonajesAdapter(List<DataItem> objects, Context contect, int resource) {
        this.objects = objects;
        this.context = contect;
        this.resource = resource;
    }

    @NonNull
    @Override
    public PersonajesAdapter.PersonajeVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View personajeView = LayoutInflater.from(context).inflate(resource,null);
        personajeView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));


        return new PersonajeVH(personajeView);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonajesAdapter.PersonajeVH holder, int position) {

        DataItem personaje = objects.get(position);
        holder.lblNombre.setText(personaje.getName());
        holder.lblId.setText(String.valueOf(personaje.getId()));
        Picasso.get()
                .load(personaje.getImageUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.imgPersonaje);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PersonajeActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("PERSONAJE",personaje);
                intent.putExtra("BUNDLE",bundle);

                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class PersonajeVH extends RecyclerView.ViewHolder {

        TextView lblNombre;
        TextView lblId;
        ImageView imgPersonaje;

        public PersonajeVH(@NonNull View itemView) {
            super(itemView);
            lblId = itemView.findViewById(R.id.lblIdPersonajeCard);
            lblNombre = itemView.findViewById(R.id.lblNombreCard);
            imgPersonaje = itemView.findViewById(R.id.imgPersonajeCard);
        }
    }
}
