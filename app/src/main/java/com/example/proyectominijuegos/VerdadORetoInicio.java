package com.example.proyectominijuegos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VerdadORetoInicio extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verdad_o_reto_inicio);


        // BOTON PARA CONTINUAR AL JUEGO
        Button btVoR = (Button) findViewById(R.id.btVoR);
        btVoR.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(VerdadORetoInicio.this, VerdadORetoJuego.class));

            }

        });

    }


}


