package com.example.controlcafetin;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mydatabase.db"; // Nombre de tu base de datos
    private static final int DATABASE_VERSION = 1; // Versión de la base de datos

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crea las tablas de la base de datos en el método onCreate
        String createTableQuery = "CREATE TABLE IF NOT EXISTS productos (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, precio REAL)";
        db.execSQL(createTableQuery);
        // Agrega otras tablas y columnas según tus necesidades
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Maneja la actualización de la base de datos en el método onUpgrade
        String dropTableQuery = "DROP TABLE IF EXISTS productos";
        db.execSQL(dropTableQuery);
        // Agrega otras tablas y columnas que necesiten ser actualizadas
        onCreate(db);
    }
}


