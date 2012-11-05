package com.abc.kids;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class WordDBAdapter {

    public static final String ROW_ID = "idword";
    public static final String INDONESIA = "indonesia";
    public static final String ENGLISH = "english";
    public static final String IMAGEFILE = "imagefile";

    private static final String DATABASE_TABLE = "word";

    private DatabaseHelper miraDbHelper;
    private SQLiteDatabase miraDb;

    private final Context miraCtx;

    private static class DatabaseHelper extends SQLiteOpenHelper {

        DatabaseHelper(Context context) {
            super(context, DatabaseAdapter.DATABASE_NAME, null, DatabaseAdapter.DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    /**
     * Constructor - takes the context to allow the database to be
     * opened/created
     * 
     * @param ctx
     *            the Context within which to work
     */
    public WordDBAdapter(Context ctx) {
        this.miraCtx = ctx;
    }

    /**
     * Open the database. If it cannot be opened, try to create a new
     * instance of the database. If it cannot be created, throw an exception to
     * signal the failure
     * 
     * @return this (self reference, allowing this to be chained in an
     *         initialization call)
     * @throws SQLException
     *             if the database could be neither opened or created
     */
    public WordDBAdapter open() throws SQLException {
        this.miraDbHelper = new DatabaseHelper(this.miraCtx);
        this.miraDb = this.miraDbHelper.getWritableDatabase();
        return this;
    }

    /**
     * close return type: void
     */
    public void close() {
        this.miraDbHelper.close();
    }

    /**
     * Create a new word. If the word is successfully created return the new
     * rowId for that word, otherwise return a -1 to indicate failure.
     * 
     * @param indo
     * @param eng
     * @param img
     * @return rowId or -1 if failed
     */
    public long createWord(String indonesia, String english, String imagefile){
        ContentValues initialValues = new ContentValues();
        initialValues.put(INDONESIA, indonesia);
        initialValues.put(ENGLISH, english);
        initialValues.put(IMAGEFILE, imagefile);
        return this.miraDb.insert(DATABASE_TABLE, null, initialValues);
    }

    /**
     * Delete the word with the given rowId
     * 
     * @param rowId
     * @return true if deleted, false otherwise
     */
    public boolean deleteWord(long rowId) {

        return this.miraDb.delete(DATABASE_TABLE, ROW_ID + "=" + rowId, null) > 0; //$NON-NLS-1$
    }

    /**
     * Return a Cursor over the list of all word in the database
     * 
     * @return Cursor over all word
     */
    public Cursor getAllWord() {

        return this.miraDb.query(DATABASE_TABLE, new String[] { ROW_ID,
                INDONESIA,ENGLISH,IMAGEFILE }, null, null, null, null, null);
    }

    /**
     * Return a Cursor positioned at the word that matches the given rowId
     * @param rowId
     * @return Cursor positioned to matching word, if found
     * @throws SQLException if word could not be found/retrieved
     */
    public Cursor getWord(long rowId) throws SQLException {

        Cursor mCursor =

        this.miraDb.query(true, DATABASE_TABLE, new String[] { ROW_ID, INDONESIA,
        		ENGLISH,IMAGEFILE}, ROW_ID + "=" + rowId, null, null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    /**
     * Update the word
     * 
     * @param rowId
     * @param ind
     * @param eng
     * @param img
     * @return true if the note was succfileessfully updated, false otherwise
     */
    public boolean updateWord(long rowId, String indonesia, String english,
            String imagefile){
        ContentValues args = new ContentValues();
        args.put(INDONESIA, indonesia);
        args.put(ENGLISH, english);
        args.put(IMAGEFILE, imagefile);

        return this.miraDb.update(DATABASE_TABLE, args, ROW_ID + "=" + rowId, null) >0; 
    }

}