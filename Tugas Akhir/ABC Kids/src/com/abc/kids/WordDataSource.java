package com.abc.kids;

import java.util.ArrayList;
import java.util.List;

import android.R.integer;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class WordDataSource {
	
	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	
	public static final String COL_ID = "idword";
    public static final String COL_INDONESIA = "indonesia";
    public static final String COL_ENGLISH= "english";
    public static final String COL_IMG = "image";
    public static final String COL_TYPE= "tipe";

    
    private String[] allColumns = { COL_ID,COL_INDONESIA,COL_ENGLISH,
    		COL_IMG,COL_TYPE};
	
	  public WordDataSource(Context context) {
	    dbHelper = new MySQLiteHelper(context);
	  }
	
	  public void open() throws SQLException {
	    database = dbHelper.getWritableDatabase();
	  }
	
	  public void close() {
	    dbHelper.close();
	  }
	
	public Word createWord(String indo, String eng , String img, int type) {
		  
		  ContentValues initialValues = new ContentValues();
		  initialValues.put(COL_INDONESIA, indo);
		  initialValues.put(COL_ENGLISH, eng);
		  initialValues.put(COL_IMG, img);
		  initialValues.put(COL_TYPE, type);
                
		  long insertId= this.database.insert(dbHelper.DB_TABLE_WORD, null, initialValues);
		  
		  Cursor cursor = database.query(dbHelper.DB_TABLE_WORD,
			        allColumns, COL_ID + " = " + insertId, null,
			        null, null, null);
		  cursor.moveToFirst();
		  Word newWord = cursorToWord(cursor);
		  cursor.close();
		  return newWord;
	  }
	
	  
	
	  public List<Word> getAllWord() {
	    List<Word> words = new ArrayList<Word>();
	
	    Cursor cursor = database.query(dbHelper.DB_TABLE_WORD,
	        allColumns, null, null, null, null, null);
	
	    cursor.moveToFirst();
	    while (!cursor.isAfterLast()) {
		    Word word = cursorToWord(cursor);
		    words.add(word);
		    cursor.moveToNext();
	    }
	    // Make sure to close the cursor
	    cursor.close();
	    return words;
	  }
	
	  private Word cursorToWord(Cursor cursor) {
	    Word word = new Word();
	    word.setId(cursor.getLong(0));
	    word.setIndo(cursor.getString(1));
	    word.setEng(cursor.getString(2));
	    word.setImg(cursor.getString(3));
	    word.setType(cursor.getLong(4));
	    
	    return word;
	  }
	  
	  
	 


}
