package com.abc.kids;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAdapter {
	
	public static final String DATABASE_NAME ="DatabaseABC";
	public static final int DATABASE_VERSION =1;
	
	
	private static final String CREATE_TABLE_WORD = "create table word (idword integer PRIMARY KEY autoincrement, "
													+WordDBAdapter.INDONESIA+" text,"
													+WordDBAdapter.ENGLISH+" text,"
													+WordDBAdapter.IMAGEFILE+"text"+ ");";
	
    private static final String CREATE_TABLE_USER = "create table user (iduser integer primary key autoincrement, " 
    +UserDBAdapter.USER_NAME+" TEXT,"  
    +UserDBAdapter.AGE+" TEXT  "+ ");";  
	
   private static final String CREATE_TABLE_REPORT = "create table report (idreport integer primary key autoincrement, "  
    	    +ReportDBAdapter.Type_Test+" TEXT,"  
    	    +ReportDBAdapter.Score+" TEXT"   + ");";  
    		 
    	    
		    


	private final Context context; 
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

     
    public DatabaseAdapter(Context ctx)
    {
        this.context = ctx;
        this.DBHelper = new DatabaseHelper(this.context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper 
    {
        DatabaseHelper(Context context) 
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) 
        {
            db.execSQL(CREATE_TABLE_WORD);
            db.execSQL(CREATE_TABLE_USER);
            db.execSQL(CREATE_TABLE_REPORT);           
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, 
        int newVersion) 
        {               
            // Adding any table mods to this guy here
        }
    } 

   
    public DatabaseAdapter open() throws SQLException 
    {
        this.db = this.DBHelper.getWritableDatabase();
        return this;
    }

    /**
     * close the db 
     * return type: void
     */
    public void close() 
    {
        this.DBHelper.close();
    }
}