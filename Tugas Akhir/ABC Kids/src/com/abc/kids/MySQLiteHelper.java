package com.abc.kids;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {
	
	  private static final String DATABASE_NAME = "DatabaseABC";
	  private static final int DATABASE_VERSION = 1;
	  public static final String DB_TABLE_USER = "user";
	  public static final String DB_TABLE_WORD = "word";
	  public static final String DB_TABLE_REPORT = "report";
	  
	  // Database creation sql statement
	  private static final String CREATE_TABLE_WORD = "create table word (idword integer PRIMARY KEY autoincrement, "
				+WordDataSource.COL_INDONESIA+" text,"
				+WordDataSource.COL_ENGLISH+" text,"
				+WordDataSource.COL_IMG+" text,"
				+WordDataSource.COL_TYPE+" integer"+ ");";
		
	  private static final String CREATE_TABLE_USER = "create table user (iduser integer primary key autoincrement, " 
		    +UserDataSource.COL_USERNAME+" TEXT" + ");";  
				
	  private static final String CREATE_TABLE_REPORT = "create table report (idreport integer primary key autoincrement, "  
	    	    +ReportDataSource.COL_ID_USER+" integer,"
	    	    +ReportDataSource.COL_TYPE+" TEXT,"
	    	    +ReportDataSource.COL_SCORE+" integer" + ");";  
	
	  
	
	  public MySQLiteHelper(Context context) {
	    super(context, DATABASE_NAME, null, DATABASE_VERSION);
	  }
	
	  @Override
	  public void onCreate(SQLiteDatabase database) {
	    database.execSQL(CREATE_TABLE_WORD);
	    database.execSQL(CREATE_TABLE_USER);
	    database.execSQL(CREATE_TABLE_REPORT);
	    insertWord(database);
	   
	    	  }
	
	  @Override 
	  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	    Log.w(MySQLiteHelper.class.getName(),
	        "Upgrading database from version " + oldVersion + " to "
	            + newVersion + ", which will destroy all old data");
	    db.execSQL("DROP TABLE IF EXISTS word");
	    db.execSQL("DROP TABLE IF EXISTS user");
	    db.execSQL("DROP TABLE IF EXISTS report");
	    onCreate(db);
	  }
	  
	  
	 private void dataWord(SQLiteDatabase db ,String indo, String eng , String img, int type){
		 
		  ContentValues initialValues = new ContentValues();
		  initialValues.put(WordDataSource.COL_INDONESIA, indo);
		  initialValues.put(WordDataSource.COL_ENGLISH, eng);
		  initialValues.put(WordDataSource.COL_IMG, img);
		  initialValues.put(WordDataSource.COL_TYPE, type);
               
		  long insertId= db.insert(DB_TABLE_WORD, null, initialValues);
		  
		  
		   
		 
		 
	 }
	  
	  public void insertWord(SQLiteDatabase db)
	      {		
		  
  		dataWord(db,"Ayam","Albatros","A",1);
  		dataWord(db,"Bebek","Bear","B",1);
  		dataWord(db,"Cicak","Co","C",1);
  		dataWord(db,"Duit","Dada","D",1);
  		dataWord(db,"Elang","Elephant","E",1);
  		 }
}
