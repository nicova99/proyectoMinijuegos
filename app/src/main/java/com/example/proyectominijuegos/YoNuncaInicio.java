package com.example.proyectominijuegos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class YoNuncaInicio extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yo_nunca_inicio);

        // BOTON PARA CONTINUAR AL JUEGO
        Button btYoNunca = (Button) findViewById(R.id.btYoNunca);
        btYoNunca.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(YoNuncaInicio.this, YoNuncaJuego.class));
            }

        });
    }

}

