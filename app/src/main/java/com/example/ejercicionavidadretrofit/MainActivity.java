package com.example.ejercicionavidadretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.ejercicionavidadretrofit.Adapters.PersonajesAdapter;
import com.example.ejercicionavidadretrofit.Conexiones.APIConexiones;
import com.example.ejercicionavidadretrofit.Conexiones.RetrofitObject;
import com.example.ejercicionavidadretrofit.Modelos.DataItem;
import com.example.ejercicionavidadretrofit.Modelos.Response;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.LayoutManager lm;
    private List<DataItem> personajeList;
    private PersonajesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView contenedor = findViewById(R.id.contenedor);

        personajeList = new ArrayList<>();
        adapter = new PersonajesAdapter(personajeList, this,R.layout.personaje_view_holder);
        lm = new LinearLayoutManager(this);

        contenedor.setAdapter(adapter);
        contenedor.setLayoutManager(lm);

        doGetPersonajes();





    }

    private void doGetPersonajes() {

        Retrofit retrofit = RetrofitObject.getConnection();
        APIConexiones api = retrofit.create(APIConexiones.class);

        Call<Response> getResponse = api.getResponse();
        getResponse.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if(response.code() == HttpURLConnection.HTTP_OK){
                    Response resp = response.body();
                    personajeList.addAll(resp.getData());
                    adapter.notifyItemRangeInserted(0, personajeList.size());
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Toast.makeText(MainActivity.this, "ERROR DE CONEXIÓN", Toast.LENGTH_SHORT).show();
                Log.e("FAILURE", t.getLocalizedMessage());
            }
        });
    }
}