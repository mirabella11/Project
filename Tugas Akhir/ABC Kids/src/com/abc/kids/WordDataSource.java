package com.abc.kids;

import java.util.ArrayList;
import java.util.List;
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
	    word.setImg(cursor.getInt(3));
	    word.setType(cursor.getLong(4));
	    
	    return word;
	  }
	  
	  public Word get(int image,int qType) {
			 
		
  		Cursor cursor = database.rawQuery ( "select * from word where image = "  + (image+1) + " and tipe="+(qType), null);
  		Word word = new Word();
  		
  		if (cursor.getCount() > 0) {
  			int indexId = cursor.getColumnIndex("idword");
  			int indexIndo  = cursor.getColumnIndex("indonesia");
  			int indexEnglish = cursor.getColumnIndex("english");
			int indexImage = cursor.getColumnIndex("image");
			int indexType = cursor.getColumnIndex("tipe");
						
			cursor.moveToFirst();
			do {
				int id = cursor.getInt(indexId);
				String indonesia = cursor.getString(indexIndo);
				String inggris = cursor.getString(indexEnglish);
				int img = cursor.getInt(indexImage);
				int type = cursor.getInt(indexType);

				word.setId(id);
				word.setIndo(indonesia);
				word.setEng(inggris);
				word.setImg(img);
				word.setType(type);
								
				cursor.moveToNext();
			} while (!cursor.isAfterLast());
		}
		return word;
	} 
	  
	  
	  
	  public int[] getList(int type,int imgtype) {
		  int[] listar=new int[GlobalData.getInstance().max_number[imgtype-1]];
		  if (type==1){
			  
			  Cursor cursor = database.rawQuery ( "select * from word where tipe = " +imgtype+" order by indonesia asc", null);
			  if (cursor.getCount() > 0) {
		  			
					int indexImage = cursor.getColumnIndex("image"); 
					int i = 0;			
					cursor.moveToFirst();
					do {
						listar[i]= cursor.getInt(indexImage);
						i++;
						cursor.moveToNext();
					} while (!cursor.isAfterLast());
				}
		  } 
		  
		  else
		  {
			  Cursor cursor = database.rawQuery ( "select * from word where tipe = " +imgtype+" order by english asc", null);
			  
			  if (cursor.getCount() > 0) {
		  			
					int indexImage = cursor.getColumnIndex("image"); 
					int i = 0;			
					cursor.moveToFirst();
					do {
						listar[i]= cursor.getInt(indexImage);
						i++;
						cursor.moveToNext();
					} while (!cursor.isAfterLast());
				}
					
		  }
		  return  listar;
	  	
	  		  }
	  
	  
	  public Word[] getSpell(){
		  //Word word = new Word();
		  Word[] list=null;
		  Cursor cursor = database.rawQuery ( "select * from word where length(english)>=3 and length(english)<=6 and length(indonesia)>=3 and length(indonesia)<=6", null);
		  
		  if (cursor.getCount() > 0) {
			  	list = new Word[cursor.getCount()];
			  	int indexId = cursor.getColumnIndex("idword");
	  			int indexIndo  = cursor.getColumnIndex("indonesia");
	  			int indexEnglish = cursor.getColumnIndex("english");
				int indexImage = cursor.getColumnIndex("image");
				int indexType = cursor.getColumnIndex("tipe");
							
				cursor.moveToFirst();
				int i=0;
				do {
					int id = cursor.getInt(indexId);
					String indonesia = cursor.getString(indexIndo);
					String inggris = cursor.getString(indexEnglish);
					int img = cursor.getInt(indexImage);
					int typeImg = cursor.getInt(indexType);
					list[i] = new Word();
					list[i].setId(id);
					list[i].setIndo(indonesia);
					list[i].setEng(inggris);
					list[i].setImg(img);
					list[i].setType(typeImg);

					i++;
					
					cursor.moveToNext();
				} while (!cursor.isAfterLast());
			}
					  			  					  		 
		  return list;
	  }
}
