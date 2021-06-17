package com.example.proyectominijuegos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Verdad extends AppCompatActivity {
    TextView tvPreguntaVerdad;
    miBaseDeDatos bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verdad);

        Button btV = (Button) findViewById(R.id.btVerdad);
        bd = new miBaseDeDatos(this);
        tvPreguntaVerdad = (TextView) findViewById(R.id.tvVerdad);

        //ASIGNA AL TEXTVIEW UNA VERDAD ALEATORIA
        cambiar();

        // BOTON PARA VOLVER AL MENU DE VERDAD O RETO
        btV.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Verdad.this, VerdadORetoJuego.class));
                finish();
            }

        });
    }

    //METODO QUE CAMBIA EL TEXTO DE LA VERDAD
    public void cambiar() {
        tvPreguntaVerdad.setText(bd.mostrarFrase(contratoFrases.Frases.TABLA2));
    }
}