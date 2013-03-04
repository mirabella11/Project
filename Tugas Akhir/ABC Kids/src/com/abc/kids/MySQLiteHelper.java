package com.abc.kids;

import android.content.ContentValues;
import android.content.Context;
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
		dataWord(db,"Kijang","Antelope",2,1);
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
  		dataWord(db,"Ilama","Ilama",41,1);
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
   		dataWord(db,"Anemon","Anemone",2,2);
  		dataWord(db,"Aster","Aster",3,2);
  		dataWord(db,"Bunga Lonceng","Bellflower",4,2);
  		dataWord(db,"Bugenvil","Bougainvillea",5,2);
  		dataWord(db,"Bunga Sapu","Broom",6,2);
  		dataWord(db,"Kamelia","Camellia",7,2);
  		dataWord(db,"Krisan","Chrysanthemum",8,2);
		dataWord(db,"Cempaka","Chrysolite",9,2);
  		dataWord(db,"Klematis","Clematis",10,2);
  		dataWord(db,"Bunga Cone ","Coneflower",11,2);
  		dataWord(db,"Bunga Kosmos","Cosmos",12,2);
  		dataWord(db,"Dahlia","Dahlia",13,2);
  		dataWord(db,"Daylily","Daylily",14,2);
  		dataWord(db,"Delphinium","Delphinium",15,2);
  		dataWord(db,"Edelweis","Edelweiss",16,2);
  		dataWord(db,"Kamboja","Frangipani",17,2);
  		dataWord(db,"Geranium","Geranium",18,2);
  		dataWord(db,"Gladiol","Gladiolus",19,2);
  		dataWord(db,"Hollyhock","Hollyhock",20,2);
  		dataWord(db,"Honeysuckle","Honeysuckle",21,2);
  		dataWord(db,"Hortensia","Hydrangea",22,2);
  		dataWord(db,"Iris","Iris",23,2);
  		dataWord(db,"Ivy","Ivy",24,2);
  		dataWord(db,"Melati","Jasmine",25,2);
  		dataWord(db,"Lavender","Lavender",26,2);
  		dataWord(db,"Lilac","Lilac",27,2);
  		dataWord(db,"Lili","Lily",28,2);
  		dataWord(db,"Bunga Telekan","Marigold",29,2);
  		dataWord(db,"Bunga Bulan","Moonflower",30,2);
  		dataWord(db,"Narsisis","Narcissus",31,2);
  		dataWord(db,"Oleander","Oleander",32,2);
  		dataWord(db,"Anggrek","Orchid",33,2);
  		dataWord(db,"Passionflower","Passionflower",34,2);
  		dataWord(db,"Peony","Peony",35,2);
  		dataWord(db,"Bunga Popy","Poppy",36,2);
  		dataWord(db,"Bunga Bangkai","Rafflesia",37,2);
  		dataWord(db,"Mawar","Rose",38,2);
  		dataWord(db,"Snowdrop","Snowdrop",39,2);
  		dataWord(db,"Bunga Matahari","Sunflower",40,2);
  		dataWord(db,"Bunga Terompet","Trumpetvine",41,2);
  		dataWord(db,"Sedap Malam","Tuberose",42,2);
  		dataWord(db,"Tulip","Tulip",43,2);
  		dataWord(db,"Vinca","Vinca",44,2);
  		dataWord(db,"Zinnia","Zinnia",45,2);
  		dataWord(db,"Foxglove","Foxglove",46,2);
  		
  		
  		 		
  		dataWord(db,"Acai","Acai",1,3);
  		dataWord(db,"Kacang Almond","Almond",2,3);
  		dataWord(db,"Apel","Apple",3,3);
  		dataWord(db,"Aprikot","Apricot",4,3);
  		dataWord(db,"Alpukat","Avocado",5,3);
  		dataWord(db,"Pisang","Banana",6,3);
  		dataWord(db,"Barberi","Barberries",7,3);		
  		dataWord(db,"Blackcurrant","Blackcurrant",8,3);
  		dataWord(db,"Blueberi","Blueberries",9,3);
  		dataWord(db,"Melon Kuning","Cantaloupe",10,3);
  		dataWord(db,"Jambu Monyet","Cashew",11,3);
  		dataWord(db,"Srikaya","Cherimoya",12,3);
  		dataWord(db,"Ceri","Cherry",13,3);
  		dataWord(db,"Kastanye","Chestnut",14,3);
  		dataWord(db,"Clementine","Clementine",15,3);
  		dataWord(db,"Kelapa","Coconuts",16,3);
  		dataWord(db,"Crowberi","Crowberry",17,3);
  		dataWord(db,"Buah Naga","Dragonfruit",18,3);
  		dataWord(db,"Durian","Durian",19,3);
  		dataWord(db,"Plum Eropa","European Plum",20,3);
  		dataWord(db,"Ara","Fig",21,3);
  		dataWord(db,"Gojiberi","Gojiberry",22,3);
   		dataWord(db,"Anggur","Grape",23,3);
  		dataWord(db,"Gooseberi","Gooseberries",24,3);
  		dataWord(db,"Jeruk Bali","Grapefruit",25,3);
  		dataWord(db,"Jambu Biji","Guava",26,3);
  		dataWord(db,"Hazelnut","Hazelnut",27,3);
  		dataWord(db,"Melon","Honeydew",28,3);
  		dataWord(db,"Nangka","Jackfruit",29,3);
  		dataWord(db,"Juniperberi","Juniperberries",30,3);
  		dataWord(db,"Kiwi","Kiwi",31,3);
  		dataWord(db,"Kumquat","Kumquat",32,3);
  		dataWord(db,"Jeruk Nipis","Lemon",33,3);
  		dataWord(db,"Jeruk Limau","Lime",34,3);
  		dataWord(db,"Leci","Lychee",35,3);
  		dataWord(db,"Mangga","Mango",36,3);
  		dataWord(db,"Manggis","Mangosteen",37,3);
  		dataWord(db,"Nectarine","Nectarine",38,3);
  		dataWord(db,"Jeruk","Orange",39,3);
  		dataWord(db,"Zaitun","Olive",40,3);
  		dataWord(db,"Pepaya","Papaya",41,3);
  		dataWord(db,"Markisa","Passionfruit",42,3);
  		dataWord(db,"Persik","Peach",43,3);
  		dataWord(db,"Pir","Pear",44,3);
  		dataWord(db,"Kesemek","Persimmon",45,3);
  		dataWord(db,"Nanas","Pineapple",46,3);
  		dataWord(db,"Kacang Pistacio","Pistachio",47,3);
  		dataWord(db,"Prem","Plum",48,3);
  		dataWord(db,"Delima","Pomegranate",49,3);
  		dataWord(db,"Pomelo","Pomelo",50,3);
  		dataWord(db,"Quince","Quince",51,3);
  		dataWord(db,"Rambutan","Rambutan",52,3);
  		dataWord(db,"Frambos","RaspBerry",53,3);
  		dataWord(db,"Jambu Merah","Red Guava",54,3);
  		dataWord(db,"Redcurrant","Redcurrant",55,3);
  		dataWord(db,"Salmonberi","Salmonberry",56,3);
  		dataWord(db,"Jeruk Mandarin","Satsuma",57,3);
  		dataWord(db,"Sea Buckthorn","Sea Buckthorn",58,3);
   		dataWord(db,"Labu","Squash",59,3);
  		dataWord(db,"Belimbing","StarFruit",60,3);
  		dataWord(db,"Stroberi","Strawberry",61,3);
  		dataWord(db,"Jeruk Keprok","Sweety",62,3);
  		dataWord(db,"Tamarillo","Tamarillo",63,3);
  		dataWord(db,"Tomat","Tomato",64,3);
  		dataWord(db,"Ugli","Ugli",65,3);
  		dataWord(db,"Semangka","Watermelon",66,3);
  	
  		
	 	 }
	 }		