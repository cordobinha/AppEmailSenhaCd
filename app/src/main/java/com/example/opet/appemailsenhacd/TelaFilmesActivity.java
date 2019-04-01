package com.example.opet.appemailsenhacd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TelaFilmesActivity extends AppCompatActivity {

    private TextView textViewMensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_filmes);
        textViewMensagem = findViewById(R.id.textViewMensagem);
    }

    public void onFilmes (View view) {
        GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.create();
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://swapi.co/api/films//";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Filme Filme = gson.fromJson(response,Filme.class);
                        textViewMensagem.setText(Filme.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textViewMensagem.setText("Falha ao carregar filmes!");
                    }
                });

        queue.add(stringRequest);
    }

    public void backHome(View view){
        homeRedirect();
    }

    void homeRedirect(){
        Intent newActivity = new Intent(TelaFilmesActivity.this,CadastroActivity.class);
        startActivity(newActivity);
    }







        }
