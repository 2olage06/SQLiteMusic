package com.example.a2olage06.sqlitemusic;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
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

    public ArrayList<Song>findSon()
    {
        String title=  "";
        ArrayList<Song> music_sample = new ArrayList<Song>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM music_sample WHERE title = ?/", new String[] {title});

        if(cursor.moveToFirst()){
            while(!cursor.isAfterlast())
            {
                Song s = new Song
                        (cursor.getString(cursor.getColumnIndex("title"))),
                        cursor.getString(cursor.getColumnIndex("artist")),
                        cursor.getLong(cursor.getColumnIndex("year"));
                Song.add(s);
                cursor.moveToNext()
            }
        }#
        cursor.close();
        return Song;
    }
}
