package com.example.proyectominijuegos;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public miBaseDeDatos bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bd = new miBaseDeDatos(this);
        bd.llenarTablas();

        //CREAMOS LA BARRA DE HERRAMIENTAS
       // Toolbar toolbar = findViewById(R.id.toolbar);
     //   setSupportActionBar(toolbar);


        //DECLARACIÓN DE LOS BOTONES
        Button btVor = (Button) findViewById(R.id.btVor);
        Button btYn = (Button) findViewById(R.id.btYn);

        //BOTON QUE ABRE EL JUEGO YO NUNCA
        btYn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, YoNuncaInicio.class));

            }
        });

        //BOTON QUE ABRE EL JUEGO VERDAD O RETO
        btVor.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, VerdadORetoInicio.class));
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_acercade) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}