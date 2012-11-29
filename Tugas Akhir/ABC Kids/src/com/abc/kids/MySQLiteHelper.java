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
				+WordDataSource.COL_IMG+" integer,"
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
	  
	  
	 private void dataWord(SQLiteDatabase db ,String indo, String eng , int img, int type){
		 
		  ContentValues initialValues = new ContentValues();
		  initialValues.put(WordDataSource.COL_INDONESIA, indo);
		  initialValues.put(WordDataSource.COL_ENGLISH, eng);
		  initialValues.put(WordDataSource.COL_IMG, img);
		  initialValues.put(WordDataSource.COL_TYPE, type);
               
		  long insertId= db.insert(DB_TABLE_WORD, null, initialValues);
		  
		  
		   
		 
		 
	 }
	  
	  public void insertWord(SQLiteDatabase db)
	      {		
		  
  		dataWord(db,"Anjing","Dog",1,1);
  		dataWord(db,"Bebek","Duck",2,1);
  		dataWord(db,"Burung Bangkai","Vulture",3,1);
  		dataWord(db,"Burung Puyuh","Quail",4,1);
  		dataWord(db,"Cicak","Newt",5,1);
  		dataWord(db,"Domba","Sheep",6,1);
  		dataWord(db,"Elang","Eagle",7,1);
  		dataWord(db,"Flamingo","Flamingo",8,1);
  		dataWord(db,"Gajah","Elephant",9,1);
  		dataWord(db,"Harimau","Tiger",10,1);
  		dataWord(db,"Ikan","Fish",11,1);
  		dataWord(db,"Iguana","Iguana",12,1);
  		dataWord(db,"Jerapah","Giraffe",13,1);
  		dataWord(db,"Kelinci","Rabbit",14,1);
  		dataWord(db,"Kadal","Lizard",15,1);
  		dataWord(db,"Kangguru","Kangaroo",16,1);
  		dataWord(db,"Kuda","Horse",17,1);
  		dataWord(db,"Lebah","Bee",18,1);
  		dataWord(db,"Monyet","Monkey",19,1);
  		dataWord(db,"Nyamuk","Mosquito",20,1);
  		dataWord(db,"Orangutan","Orangutan",21,1);
  		dataWord(db,"Panda","Panda",22,1);
  		dataWord(db,"Rusa","Deer",23,1);
  		dataWord(db,"Sapi","Cow",24,1);
  		dataWord(db,"Semut","Ant",25,1);
  		dataWord(db,"Srigala","Wolf",26,1);
  		dataWord(db,"Tupai","Squirrel",27,1);
  		dataWord(db,"Ulat","Caterpillar",28,1);
  		dataWord(db,"Ubur2","Jellyfish",29,1);
  		dataWord(db,"Walet","Swallow",30,1);
  		dataWord(db,"Yuyu","Crab",31,1);
  		dataWord(db,"Zebra","Zebra",32,1);
  		
  		dataWord(db,"Allium","AlliumOrchid",1,2);
  		dataWord(db,"Anggrek","Orchid",2,2);
  		dataWord(db,"Bugenvil","Bougainvillea",3,2);
  		dataWord(db,"Cempaka","Chrysolite",4,2);
  		dataWord(db,"Dahlia","Dahlia",5,2);
  		dataWord(db,"Edelweis","Edelweiss",6,2);
  		dataWord(db,"Gladiol","Gladiolus",7,2);
  		dataWord(db,"Hydrangea","Hydrangea",8,2);
  		dataWord(db,"Ivy","Ivy",9,2);
  		dataWord(db,"Kamboja","Frangipani",10,2);
  		dataWord(db,"Lili","Lily",11,2);
  		dataWord(db,"Matahari","Sunflower",12,2);
  		dataWord(db,"Mawar","Rose",13,2);
  		dataWord(db,"Melati","Jasmine",14,2);
  		dataWord(db,"Narsisis","Narcissus",15,2);
  		dataWord(db,"Rafflesia","Rafflesia",16,2);
  		dataWord(db,"Sedap Malam","Tuberose",17,2);
  		dataWord(db,"Tulip","Tulip",18,2);
  		dataWord(db,"Vinca","Vinca",19,2);
  		dataWord(db,"Xeranthemum","Xeranthemum",20,2);
  		dataWord(db,"Yarrow","Yarrow",21,2);
  		dataWord(db,"Zinnia","Zinnia",22,2);
  		
  		dataWord(db,"Apel","Apple",1,3);
  		dataWord(db,"Ara","Fig",2,3);
  		dataWord(db,"Anggur","Grape",3,3);
  		dataWord(db,"Belimbing","StarFruit",4,3);
  		dataWord(db,"Ceri","Cherry",5,3);
  		dataWord(db,"Durian","Durian",6,3);
  		dataWord(db,"Frambos","RaspBerry",7,3);
  		dataWord(db,"Jeruk","Orange",8,3);
  		dataWord(db,"Kelapa","Coconuts",9,3);
  		dataWord(db,"Kemiri","Hazelnut",10,3);
  		dataWord(db,"Kiwi","Kiwi",11,3);
  		dataWord(db,"Leci","Lychee",12,3);
  		dataWord(db,"Mangga","Mango",13,3);
  		dataWord(db,"Nangka","Jackfruit",14,3);
  		dataWord(db,"Pir","Pear",15,3);
  		dataWord(db,"Pisang","Banana",16,3);
  		dataWord(db,"Plum Eropa","European Plum",17,3);
  		dataWord(db,"Rambutan","Rambutan",18,3);
  		dataWord(db,"Semangka","Watermelon",19,3);
  		dataWord(db,"Stroberi","Strawberry",20,3);
  		dataWord(db,"Tomat","Tomato",21,3);
  		dataWord(db,"Zaitun","Olive",22,3);

  		
  	 	
  
  		 }
}
