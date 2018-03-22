package com.example.a2olage06.sqlitemusic;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.view.GestureDetector;

import java.util.ArrayList;

/**
 * Created by 2olage06 on 21/03/2018.
 */

public class OpenHelper extends SQLiteOpenHelper {

    static final int VERSION = 1;
    static final String DATABASE_NAME = "music_sample";


    public OpenHelper(Context ctx){
        super(ctx, DATABASE_NAME, null, VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS Music (ID INTEGER PRIMARY KEY, title VARCHAR (255), artist VARCHAR(255), year INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Music");

    }


    public long insertSong(String title, String artist, long year)
    {
        SQLiteDatabase db = getWritableDatabase();
        SQLiteStatement st = db.compileStatement(
                "INSERT INTO Songs(title,artist,year) VALUES(?,?,?)"
        );
        st.bindString (1, title);
        st.bindString (2, artist);
        st.bindLong (3, year);
        long id = st.executeInsert();
        return id;
    }


    public int updateSong(long id, String title, String artist, long year)
    {
        SQLiteDatabase db = getWritableDatabase();
        SQLiteStatement st = db.compileStatement(
                "UPDATE Song SET title = ?, artist=?, year=? WHERE title=? "
        );
        st.bindString(1, title);
        st.bindString(2, artist);
        st.bindLong (3, year);
        int affectedRows = st.executeUpdateDelete();
        return affectedRows;

    }

    public int deleteSong(long id, String title, String artist, long year)
    {
        SQLiteDatabase db = getWritableDatabase();
        SQLiteStatement st = db.compileStatement(
                "DELETE FROM Song WHERE title=?, artist=?, year=?");
        st.bindString(1, title);
        st.bindString(2, artist);
        st.bindLong(3, year);
        int affectedRows = st.executeUpdateDelete();
        return affectedRows;
    }








}
