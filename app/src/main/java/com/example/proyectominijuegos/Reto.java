package com.example.proyectominijuegos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Reto extends AppCompatActivity {

    TextView tvPreguntaReto;
    miBaseDeDatos bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reto);

        Button btR = (Button) findViewById(R.id.btReto);
        bd = new miBaseDeDatos(this);
        tvPreguntaReto = (TextView) findViewById(R.id.tvReto);

        //ASIGNA AL TEXTVIEW UN RETO ALEATORIO
        cambiar();

        // BOTON PARA VOLVER AL MENU DE VERDAD O RETO
        btR.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Reto.this, VerdadORetoJuego.class));
                finish();
            }

        });

    }

    //METODO QUE CAMBIA EL TEXTO DEL RETO
    public void cambiar() {
        tvPreguntaReto.setText(bd.mostrarFrase(contratoFrases.Frases.TABLA3));
    }
}