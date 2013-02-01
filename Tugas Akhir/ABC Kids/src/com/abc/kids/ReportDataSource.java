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
	private List<Report> listReport = null;
	
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
	    report.setUsername(cursor.getString(1));
	    report.setType(cursor.getInt(2));
	    report.setScore(cursor.getInt(3));
	    
	    return report;
	  }
	  
	  public Report getHigh(long id,int type) {
			 
			
	  		Cursor cursor = database.rawQuery ( "select idreport,iduser,type_test,max(score) score from report where iduser = "+id+" and type_test="+type, null);
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

	   public List<Report> getHighscore(int type) {
			 
		   Report[] high=null;
		   List<Report> reports = new ArrayList<Report>();
	  		Cursor cursor = database.rawQuery ("select idreport,username,type_test,max(score) score from report r inner join user u on r.iduser=u.iduser where type_test= "+type+" group by r.iduser order by score desc limit 10", null);
	 
	  		
	  		
	  		if (cursor.getCount() > 0) {
	  			high = new Report[cursor.getCount()];
	  			int indexId = cursor.getColumnIndex("idreport");
	  			int indexIduser  = cursor.getColumnIndex("username");
				int indexType = cursor.getColumnIndex("type_test");
				int indexScore = cursor.getColumnIndex("score");
							
				cursor.moveToFirst();
				int i=0;
				do {
				 
					Report report = cursorToReport(cursor);
				    reports.add(report);
		 

					cursor.moveToNext();
				} while (!cursor.isAfterLast());
			}
			return reports;
		}
	   
	   public void updateListReport(List<Report> listReport2) {
			this.listReport = listReport2;
		}
	   
	   /*
	  public List<User> getAllUser() {
	   
	
	    Cursor cursor = database.query(dbHelper.DB_TABLE_USER,
	        allColumns, null, null, null, null, null);
	
	    cursor.moveToFirst();
	    while (!cursor.isAfterLast()) {
		    User user = cursorToUser(cursor);
		    users.add(user);
		    cursor.moveToNext();
	    }
	    // Make sure to close the cursor
	    cursor.close();
	    return users;
	  }
	
	  
	  */
}

