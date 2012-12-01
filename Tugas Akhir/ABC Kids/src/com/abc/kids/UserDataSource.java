package com.abc.kids;
import java.util.ArrayList;
import java.util.List;



import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class UserDataSource {
	
	private SQLiteDatabase database;
	private MySQLiteHelper dbHelper;
	private List<User> listUser = null;
	
	public static final String COL_ID = "iduser";
    public static final String COL_USERNAME = "username";
    
    private String[] allColumns = { COL_ID,
    		COL_USERNAME };
	
	  public UserDataSource(Context context) {
	    dbHelper = new MySQLiteHelper(context);
	  }
	
	  public void open() throws SQLException {
	    database = dbHelper.getWritableDatabase();
	  }
	
	  public void close() {
	    dbHelper.close();
	  }
	
	public User createUser(String user) {
		  
		  ContentValues initialValues = new ContentValues();
		  initialValues.put(COL_USERNAME, user);
                
		  long insertId= this.database.insert(dbHelper.DB_TABLE_USER, null, initialValues);
		  
		  Cursor cursor = database.query(dbHelper.DB_TABLE_USER,
			        allColumns, COL_ID + " = " + insertId, null,
			        null, null, null);
		  
		  cursor.moveToFirst();
		  User newUser = cursorToUser(cursor);
		  cursor.close();
		  return newUser;
	  }
	
	  public void deleteUser(User user) {
	    long id = user.getId();
	    System.out.println("User deleted with id: " + id);
		database.delete(dbHelper.DB_TABLE_USER, COL_ID
		    + " = " + id, null);
		  }
	 
	  
	  public boolean updateUser(User user,String newusername) {
		try {
			database.beginTransaction();

			String updateSQL = "UPDATE " + dbHelper.DB_TABLE_USER
					+ " SET username = ?  " + " WHERE iduser = ?";
			
			database.execSQL(
					updateSQL,
					new Object[] { newusername,user.getId() });

			database.setTransactionSuccessful();
		} finally {
			database.endTransaction();
		}
		return true;
	}
 
 
		 
	  
	  public void updateListUser(List<User> listUser2) {
			this.listUser = listUser2;
		}
	  
	  
	
	  public List<User> getAllUser() {
	    List<User> users = new ArrayList<User>();
	
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
	
	  private User cursorToUser(Cursor cursor) {
	    User user = new User();
	    user.setId(cursor.getLong(0));
	    user.setName(cursor.getString(1));
	    return user;
	  }
	  
	  public boolean get() {
		 
			    	  	  	  
		  		  Cursor cursor = database.rawQuery ( "select * from user ", new String[] {});
				if (cursor.getCount() > 0) {
					 
					return true;
						
					} 
			
				else  {
					return false;
				}
			}

			
	  
	  
	   
	   

	 
}
