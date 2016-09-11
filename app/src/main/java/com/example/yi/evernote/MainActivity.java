package com.example.yi.evernote;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InsertNote("New note");

//        Cursor cursor = getContentResolver().query(NotesProvider.CONTENT_URI,DBOpenHelper.ALL_COLUMNS, null, null, null, null);
    }

    private void InsertNote(String noteText) {
        ContentValues values = new ContentValues();
        values.put(DBOpenHelper.NOTE_TEXT, noteText);
        Uri noteUri = getContentResolver().insert(NotesProvider.CONTENT_URI, values);
        Log.d("MainActivity", "Inserted note " + noteUri.getLastPathSegment());
    }
}
