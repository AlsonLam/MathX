package com.example.alson.mathx;

import android.app.LoaderManager;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Notes extends AppCompatActivity
implements LoaderManager.LoaderCallbacks<Cursor>
{
    private CursorAdapter cursorAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        insertNote("New note");


        String[] from = {DBOpenHelper.NOTE_TEXT};
        int[] to = {android.R.id.text1};

        cursorAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1,null,from,to,0);

        ListView list = findViewById(android.R.id.list);
        list.setAdapter(cursorAdapter);




    }

    private void insertNote(String noteText) {
        ContentValues values = new ContentValues();
        values.put(DBOpenHelper.NOTE_TEXT, noteText);
        Uri noteUri = getContentResolver().insert(NotesProvider.CONTENT_URI,values);

        Log.d("Notes", "Inserted Notes" + noteUri.getLastPathSegment());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        switch (id) {
            case R.id.action_create_sample:
                insertSampleData();
                break;
            case R.id.action_delete_all:
                deleteAllNotes();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void deleteAllNotes() {
    }

    private void insertSampleData(){
        insertNote("Simple note");
        insertNote("Multi-line\nnote");
        insertNote("Very long note with a lot of text that exceeds the width of the screen");
        restartLoader();
    }

    private void restartLoader (){
        getLoaderManager().restartLoader(0,null, this);
    }
   

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(this, NotesProvider.CONTENT_URI,
                null, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        cursorAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        cursorAdapter.swapCursor(null);
    }
}
