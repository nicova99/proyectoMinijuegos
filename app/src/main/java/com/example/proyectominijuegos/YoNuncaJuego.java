package com.example.proyectominijuegos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class YoNuncaJuego extends AppCompatActivity {
    miBaseDeDatos bd;
    TextView tvPregunta;
    Button btYonu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_yo_nunca_juego);


        btYonu = (Button) findViewById(R.id.btYoNuncaJuego);
        bd = new miBaseDeDatos(this);
        tvPregunta = (TextView) findViewById(R.id.tvYoNuncaPregunta);
        cambiar();

        // BOTON PARA REFRESCAR LA PREGUNTA
        btYonu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cambiar();
            }

        });

    }

    //METODO QUE CAMBIA EL TEXTO DE LA PREGUNTA
    public void cambiar() {
        tvPregunta.setText(bd.mostrarFrase(contratoFrases.Frases.TABLA1));
    }

}