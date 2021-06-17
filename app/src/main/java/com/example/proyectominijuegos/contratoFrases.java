package com.example.proyectominijuegos;


import android.provider.BaseColumns;

public final class contratoFrases {

    private contratoFrases() {
    }

    public static class Frases implements BaseColumns {

        //DECLARACION NOMBRES DE TABLAS Y FILAS
        public static final String TABLA1 = "TABLA_YONUNCA";
        public static final String TABLA2 = "TABLA_VERDADES";
        public static final String TABLA3 = "TABLA_RETOS";
        public static final String COLUMNA1 = "_id";
        public static final String COLUMNA2 = "frase";
    }
}