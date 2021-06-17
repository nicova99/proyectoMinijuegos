package com.example.proyectominijuegos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VerdadORetoJuego extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verdad_o_reto_juego);

        //DECLARACIÓN DE LOS BOTONES
        Button btVerd = (Button) findViewById(R.id.btV);
        Button btRet = (Button) findViewById(R.id.btR);

        // BOTON PARA CONTINUAR A LA VENTANA DE VERDAD
        btVerd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(VerdadORetoJuego.this, Verdad.class));
                finish();
            }

        });
        // BOTON PARA CONTINUAR A LA VENTANA DE RETO
        btRet.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(VerdadORetoJuego.this, Reto.class));
                finish();
            }

        });
    }
}