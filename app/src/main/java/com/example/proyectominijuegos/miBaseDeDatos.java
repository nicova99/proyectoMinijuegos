package com.example.proyectominijuegos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class miBaseDeDatos extends SQLiteOpenHelper {
    //CONSTANTES

    //DECLARACIÓN DE LA BASE DE DATOS Y SU VERSIÓN
    private static final String NOMBRE_BD = "BD_MINIJUEGOS.qlite3";
    private static final int VERSION_BD = 1;

    //TABLAS
    //TABLA YO NUNCA
    private static final String CREAR_TABLA1 =
            "CREATE TABLE " + contratoFrases.Frases.TABLA1 + "(" +
                    contratoFrases.Frases.COLUMNA1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    contratoFrases.Frases.COLUMNA2 + " TEXT) ";
    //TABLA VERDADES
    private static final String CREAR_TABLA2 =
            "CREATE TABLE " + contratoFrases.Frases.TABLA2 + "(" +
                    contratoFrases.Frases.COLUMNA1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    contratoFrases.Frases.COLUMNA2 + " TEXT) ";
    //TABLA RETOS
    private static final String CREAR_TABLA3 =
            "CREATE TABLE " + contratoFrases.Frases.TABLA3 + "(" +
                    contratoFrases.Frases.COLUMNA1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    contratoFrases.Frases.COLUMNA2 + " TEXT) ";

    private SQLiteDatabase bd;

    //DECLARACION DEL CURSOR
    public Cursor c;


    //CONSTRUCTOR DE LA BASE DE DATOS
    public miBaseDeDatos(Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
        bd = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        //CREAMOS LAS TABLAS
        bd.execSQL(CREAR_TABLA1);
        bd.execSQL(CREAR_TABLA2);
        bd.execSQL(CREAR_TABLA3);
        //LLENAMOS LAS TABLAS CON LAS SENTENCIAS


    }

    //METODO QUE AGREGA UNA FRASE A LA TABLA SELECCIONADA. PASAMOS POR PARAMETRO LA PREGUNTA, VERDAD O RETO Y LA TABLA A LA QUE QUEREMOS AGREGAR DICHA SENTENCIA.
    public void addString(String pregunta, String nombreTabla) {
        ContentValues cv = new ContentValues();
        //PODEMOS UTILIZAR LA CONSTANTE contratoFrases.Frases.COLUMNA2, YA QUE TODAS LAS TABLAS TIENEN EL MISMO FORMATO DE COLUMNA "_id" Y COLUMNA "frase".
        cv.put(contratoFrases.Frases.COLUMNA2, pregunta);
        bd.insertOrThrow(nombreTabla, null, cv);
    }
    public void llenarTablas(){
        //ESTAS LINEAS VACÍAN LAS TABLAS ANTES DE LLAMAR EL METODO QUE LAS LLENA, PARA EVITAR REPETICIÓN EN LAS FILAS
        //VACIADO TABLA 1
        bd.execSQL("Delete from "+contratoFrases.Frases.TABLA1);
        bd.execSQL("DELETE FROM SQLITE_SEQUENCE WHERE name='"+contratoFrases.Frases.TABLA1+"';");
        //VACIADO TABLA 2
        bd.execSQL("Delete from "+contratoFrases.Frases.TABLA2);
        bd.execSQL("DELETE FROM SQLITE_SEQUENCE WHERE name='"+contratoFrases.Frases.TABLA2+"';");
        //VACIADO TABLA 3 
        bd.execSQL("Delete from "+contratoFrases.Frases.TABLA3);
        bd.execSQL("DELETE FROM SQLITE_SEQUENCE WHERE name='"+contratoFrases.Frases.TABLA3+"';");

        //LLENADO DE LAS TRES TABLAS
        llenarTablaVerdades();
        llenarTablaRetos();
        llenarTablaYoNunca();
    }

    //METODO QUE ACTUALIZA LAS TABLES
    @Override
    public void onUpgrade(SQLiteDatabase bd, int versionAnterior, int versionNueva) {
        //Estas lineas eliminan las tablas si estas se actualizan al iniciar la apliación
        bd.execSQL("DROP TABLE IF EXISTS " + contratoFrases.Frases.TABLA1);
        bd.execSQL("DROP TABLE IF EXISTS " + contratoFrases.Frases.TABLA2);
        bd.execSQL("DROP TABLE IF EXISTS " + contratoFrases.Frases.TABLA3);

        //Se vuelven a crear las tablas
        onCreate(bd);
    }

/*    //METODO ANTIGUO: EXTRAE DE LA TABLA INDICADA UNA PREGUNTA ALEATORIA
    public String mostrarFraseYoNunca() {
        String pregu = "nada";

        c = bd.rawQuery("SELECT * FROM " + contratoFrases.Frases.TABLA1 + " ORDER BY RANDOM() LIMIT 1", null); //Seleccionamos de la tabla 1
        //una fila aleatoria utilizando random() y limit 1.
        c.moveToFirst();
        pregu = c.getString(c.getColumnIndex(contratoFrases.Frases.COLUMNA2));
        c.close();
        return pregu;
    }*/


    //METODO IMPORTANTE: EXTRAE DE LA TABLA INDICADA UNA PREGUNTA ALEATORIA

    public String mostrarFrase(String tabla) {
        String pregu = "nada";
        c = bd.rawQuery("SELECT * FROM " + tabla + " ORDER BY RANDOM() LIMIT 1", null);
        //Seleccionamos de la tabla pasada por parámetro
        //una fila aleatoria utilizando random() y limit 1.
        c.moveToFirst();
        pregu = c.getString(c.getColumnIndex(contratoFrases.Frases.COLUMNA2));//recogemos en la variable pregu el valor de la fila extraida en la sentencia del cursor
        c.close();//cerramos el cursor
        return pregu;
    }


    //LOS SIGUIENTES METODOS SE EJECUTAN EN EL ONCREATE DE LA APLICACIÓN, ES DECIR EN LA INSTALACIÓN. LLENAN LAS
    //TABLAS CON LAS PREGUNTAS, VERDADES Y RETOS.
    public void llenarTablaYoNunca() {
        String tabla = contratoFrases.Frases.TABLA1; //recogemos el nombre de la tabla en una variable local
        addString("Yo nunca me he caído en un río", tabla);
        addString("Yo nunca he comido un insecto", tabla);
        addString("Yo nunca he estado en el extranjero", tabla);
        addString("Yo nunca he conocido a mi ídolo", tabla);
        addString("Yo nunca he copiado en un examen", tabla);
        addString("Yo nunca me he roto una pierna", tabla);
        addString("Yo nunca he vivido lejos de mi familia", tabla);
        addString("Yo nunca he estado sin dormir más de 24 horas", tabla);
        addString("Yo nunca he visitado un museo", tabla);
        addString("Yo nunca he visto un león en  persona", tabla);
        addString("Yo nunca he tenido una mascota", tabla);

    }

    public void llenarTablaVerdades() {
        String tabla = contratoFrases.Frases.TABLA2; //recogemos el nombre de la tabla en una variable local
        addString("¿Has estado a punto de fallecer?", tabla);
        addString("¿Has tenido alguna experiencia paranormal? cuéntala", tabla);
        addString("¿Qué es lo peor que has hecho por dinero?", tabla);
        addString("¿Has cometido alguna vez algún delito?", tabla);
        addString("¿Qué es lo más raro que has hecho nunca?", tabla);
        addString("¿Cuál es tu mayor miedo?", tabla);
        addString("¿Qué es lo peor que has ocultado a alguien?", tabla);
        addString("¿Cuál es la persona a la que más odias de esta habitación?", tabla);
        addString("¿Qué es lo peor que has ocultado a alguien?", tabla);
        addString("¿Te atreves a contar algún secreto de alguien de esta habitación?", tabla);
        addString("¿Qué es lo más asqueroso que has comido?", tabla);
        addString(" ¿Cuál es la mayor locura que has hecho?", tabla);

    }

    public void llenarTablaRetos() {
        String tabla = contratoFrases.Frases.TABLA3; //recogemos el nombre de la tabla en una variable local
        addString("Gritar en la calle que te has enamorado", tabla);
        addString("Actúa como un animal (el grupo elige)", tabla);
        addString("Abrazar a la primera persona que te encuentres en la calle", tabla);
        addString("No puedes decir malas palabras durante el resto del juego", tabla);
        addString("Dale una serenata a la persona que está al frente de ti", tabla);
        addString("Vístete con tu camisa al revés", tabla);
        addString("Canta cualquier cosa que digas durante el resto del juego", tabla);
        addString("Habla a un desconocido sobre vuestra antigüa amistad en la prisión", tabla);
        addString("Grita tu nombre lo más fuerte que puedas", tabla);
        addString("Canta una canción mientras los demás te aplauden", tabla);
        addString("Haz el pino", tabla);


    }

}