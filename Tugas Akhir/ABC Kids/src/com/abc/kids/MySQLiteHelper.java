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
		dataWord(db,"Elang Laut","Albatross",1,1);  
		dataWord(db,"Antelope","Antelope",2,1);
		dataWord(db,"Luak","Badger",3,1);
		dataWord(db,"Kelelawar","Bat",4,1);
		dataWord(db,"Beruang","Bear",5,1);
		dataWord(db,"Lebah","Bee",6,1);
		dataWord(db,"Banteng","Bison",7,1);
		dataWord(db,"Kerbau","Buffallo",8,1);
		dataWord(db,"Unta","Camel",9,1);
		dataWord(db,"Kenari","Canary",10,1);
		dataWord(db,"Kardinal","Cardinal",11,1);
		dataWord(db,"Kucing","Cat",12,1);
		dataWord(db,"Ayam","Chicken",13,1);
		dataWord(db,"Simpanse","Chimpanzee",14,1);
		dataWord(db,"Sapi","Cow",15,1);
		dataWord(db,"Anjing Hutan","Coyote",16,1);
		dataWord(db,"Buaya","Crocodile",17,1);
		dataWord(db,"Gagak","Crow",18,1);
  		dataWord(db,"Anjing","Dog",19,1);
  		dataWord(db,"Lumba-Lumba","Dolphin",20,1);
  		dataWord(db,"Keledai","Donkey",21,1);
   		dataWord(db,"Bebek","Duck",22,1);
  		dataWord(db,"Elang","Eagle",23,1);
  		dataWord(db,"Gajah","Elephant",24,1);
  		dataWord(db,"Finch","Finch",25,1);
  		dataWord(db,"Flamingo","Flamingo",26,1);
  		dataWord(db,"Katak","Frog",27,1);
  		dataWord(db,"Siamang","Gibbon",28,1);
  		dataWord(db,"Kambing","Goat",29,1);
  		dataWord(db,"Angsa","Goose",30,1);
  		dataWord(db,"Gorila","Gorilla",31,1);
  		dataWord(db,"Landak","Hedgehog",32,1);
  		dataWord(db,"Kuda Nil","Hippopotamus",33,1);
  		dataWord(db,"Babi Hutan","Hog",34,1);
  		dataWord(db,"Kuda","Horse",35,1);
  		dataWord(db,"Hyena","Hyena",36,1);
  		dataWord(db,"Jaguar","Jaguar",37,1);
  		dataWord(db,"Domba","Lamb",38,1);
  		dataWord(db,"Macan Tutul","Leopard",39,1);
  		dataWord(db,"Singa","Lion",40,1);
  		dataWord(db,"Llama","Llama",41,1);
  		dataWord(db,"Lynx","Lynx",42,1);
  		dataWord(db,"Mockingbird","Mockingbird",43,1);
  		dataWord(db,"Monyet","Monkey",44,1);
  		dataWord(db,"Rusa Amerika","Moose",45,1);
  		dataWord(db,"Nyamuk","Mosquito",46,1);
  		dataWord(db,"Paus Pembunuh","Orca",47,1);
  		dataWord(db,"Burung Hantu","Owl",48,1);
  		dataWord(db,"Panther","Panther",49,1);
  		dataWord(db,"Burung Nuri","Parrot",50,1);
  		dataWord(db,"Merak","Peacock",51,1);
  		dataWord(db,"Pinguin","Penguin",52,1);
  		dataWord(db,"Babi","Pig",53,1);
  		dataWord(db,"Merpati","Pigeon",54,1);
  		dataWord(db,"Puma","Puma",55,1);
   		dataWord(db,"Badak","Rhinoceros",56,1);
  		dataWord(db,"Burung Camar","Seagull",57,1);
  		dataWord(db,"Singa Laut","Sealion",58,1);
  		dataWord(db,"Ular","Snake",59,1);
  		dataWord(db,"Burung Gereja","Sparrow",60,1);
  		dataWord(db,"Walet","Swallow",61,1);
  		dataWord(db,"Harimau","Tiger",62,1);
  		dataWord(db,"Kalkun","Turkey",63,1);
  		dataWord(db,"Burung Bangkai","Vulture",64,1);
  		dataWord(db,"Paus","Whale",65,1);
  		dataWord(db,"Srigala","Wolf",66,1);
  		dataWord(db,"Burung Pelatuk","Woodpecker",67,1);
  		dataWord(db,"Zebra","Zebra",68,1);
  		
  		
  		 	
   		dataWord(db,"Allium","Allium",1,2);
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
