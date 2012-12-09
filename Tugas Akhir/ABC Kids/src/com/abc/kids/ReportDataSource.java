package com.abc.kids;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class ReportDataSource {

	
	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	
	public static final String COL_ID = "idreport";
	public static final String COL_ID_USER = "iduser";
	public static final String COL_TYPE = "type_test";
	public static final String COL_SCORE = "score";
	
    
    private String[] allColumns = { COL_ID,COL_ID_USER,COL_TYPE,
    		COL_SCORE };
	
	  public ReportDataSource(Context context) {
	    dbHelper = new MySQLiteHelper(context);
	  }
	
	  public void open() throws SQLException {
	    database = dbHelper.getWritableDatabase();
	  }
	
	  public void close() {
	    dbHelper.close();
	  }
	
	public Report createReport(long id, int type , int score) {
		  
		  ContentValues initialValues = new ContentValues();
		  initialValues.put(COL_ID_USER, id);
		  initialValues.put(COL_TYPE, type);
		  initialValues.put(COL_SCORE, score);
                
		  long insertId= this.database.insert(dbHelper.DB_TABLE_REPORT, null, initialValues);
		  
		  Cursor cursor = database.query(dbHelper.DB_TABLE_REPORT,
			        allColumns, COL_ID + " = " + insertId, null,
			        null, null, null);
		  cursor.moveToFirst();
		  Report newReport = cursorToReport(cursor);
		  cursor.close();
		  return newReport;
	  }
	
	/*  public void deleteReport(Report report) {
		    long id = user.getId();
		    System.out.println("Comment deleted with id: " + id);
			database.delete(dbHelper.DB_TABLE_USER, COL_ID
			    + " = " + id, null);
			  } */
		
	
	  
	
	  public List<Report> getAllReport() {
	    List<Report> reports = new ArrayList<Report>();
	
	    Cursor cursor = database.query(dbHelper.DB_TABLE_REPORT,
	        allColumns, null, null, null, null, null);
	
	    cursor.moveToFirst();
	    while (!cursor.isAfterLast()) {
	    	Report report = cursorToReport(cursor);
		    reports.add(report);
		    cursor.moveToNext();
	    }
	    // Make sure to close the cursor
	    cursor.close();
	    return reports;
	  }
	
	  private Report cursorToReport(Cursor cursor) {
		Report report = new Report();
	    report.setId(cursor.getLong(0));
	    report.setIduser(cursor.getLong(1));
	    report.setType(cursor.getInt(2));
	    report.setScore(cursor.getInt(3));
	    
	    return report;
	  }
	  
	  public Report get(long id,int type,int score) {
			 
			
	  		Cursor cursor = database.rawQuery ( "select * from report where  = ", null);
	  		Report report = new Report();
	  		
	  		if (cursor.getCount() > 0) {
	  			int indexId = cursor.getColumnIndex("idreport");
	  			int indexIduser  = cursor.getColumnIndex("iduser");
				int indexType = cursor.getColumnIndex("type_test");
				int indexScore = cursor.getColumnIndex("score");
							
				cursor.moveToFirst();
				do {
					int idre = cursor.getInt(indexId);
					int iduser = cursor.getInt(indexIduser);
					int type_test = cursor.getInt(indexType);
					int score_user = cursor.getInt(indexScore);
					

					report.setId(idre);
					report.setIduser(iduser);
					report.setType(type_test);
					report.setScore(score_user);
					

					cursor.moveToNext();
				} while (!cursor.isAfterLast());
			}
			return report;
		}
}
