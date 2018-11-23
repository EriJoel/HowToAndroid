package com.ej.howtoandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DBOpenHelper extends SQLiteOpenHelper {
    String database_name = "DBHowToAndroid";
    String table_theme = "create table Tema(" +
            "ID_tema integer primary key autoincrement," +
            " Nombre text," +
            " Descripcion text)";
    String table_paragraph = "create table Parrafo(" +
            "ID_parrafo integer primary key autoincrement," +
            " Titulo text," +
            " Texto text," +
            " Url text," +
            " ID_tema," +
            " Profundidad integer," +
            "Foreign Key (ID_tema) references Tema(ID_tema))";
    public DBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(table_theme);
        db.execSQL(table_paragraph);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Tema");
        db.execSQL("drop table if exists Tema");
        db.execSQL(table_theme);
        db.execSQL(table_paragraph);

    }
}
