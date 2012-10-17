package com.povilas.sid.ktu.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataSqLiteHelper extends SQLiteOpenHelper {
	//SHEDULE table
	  public static final String TABLE_SHEDULE = "shedule";
	  public static final String COLUMN_ID = "_id";
	  public static final String COLUMN_WEEKDAY = "weekday";
	  public static final String COLUMN_SUBJECT = "subject";
	  public static final String COLUMN_LOCATION = "location";
	  public static final String COLUMN_TIME = "time";
	  public static final String COLUMN_COLOR = "color";
	  
	  //GROUPS table
	  // TODO make version with correct database architecture
	  public static final String TABLE_GROUPS = "groups";
	  public static final String COLUMN_SUBJECT_CODE = "subject_code";
	  public static final String COLUMN_GROUP_CODE = "group_code";
	  public static final String COLUMN_GROUP_TITLE = "group_title";
	  public static final String COLUMN_SUBJECT_TITLE = "subject_title";
	  public static final String COLUMN_USER_BELONGS = "user_belongs";
	  
	  //SYSTEM table
	  public static final String TABLE_SYSTEM = "system";
	  public static final String COLUMN_VARIABLE = "variable";
	  public static final String COLUMN_VALIUE = "value";
	  
	  

	  private static final String DATABASE_NAME = "shedule.db";
	  private static final int DATABASE_VERSION = 1;

	  // Database creation sql statement
	  private static final String DATABASE_CREATE = "create table "
	      + TABLE_SHEDULE + "(" 
			  + COLUMN_ID + " integer primary key autoincrement, " 
			  + COLUMN_WEEKDAY  + " integer not null, "
			  +	COLUMN_SUBJECT  + " text not null, "
			  + COLUMN_LOCATION + " text not null, "
			  + COLUMN_TIME     + " text not null, "
			  + COLUMN_COLOR    + " text not null "
	      +");"
			  +" create table " + TABLE_GROUPS + " ("
			  + COLUMN_ID + " integer primary key autoincrement, "
			  + COLUMN_SUBJECT_TITLE + " text not null, "
			  + COLUMN_SUBJECT_CODE  + " text not null, "
			  + COLUMN_GROUP_TITLE   + " text not null, "
			  + COLUMN_GROUP_CODE    + " text not null, "
			  + COLUMN_USER_BELONGS  + " integer not null default (0) "
	      +");"
			  +" create table " + TABLE_SYSTEM + " ("
			  + COLUMN_VARIABLE + " text primary key, "
			  + COLUMN_VALIUE   + " text "
	      +");";

	  public DataSqLiteHelper(Context context) {
	    super(context, DATABASE_NAME, null, DATABASE_VERSION);
	  }

	  @Override
	  public void onCreate(SQLiteDatabase database) {
	    database.execSQL(DATABASE_CREATE);
	  }

	  @Override
	  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	    Log.w(DataSqLiteHelper.class.getName(),
	        "Upgrading database from version " + oldVersion + " to "
	            + newVersion + ", which will destroy all old data");
	    db.execSQL("DROP TABLE IF EXISTS " + TABLE_SHEDULE);
	    onCreate(db);
	  }
}

/*ADVANCED VERSION EXAMPLE*/
// @SuppressWarnings("unused")
///** Helper to the database, manages versions and creation */
//public class PlaceDataSQL extends SQLiteOpenHelper {
//	private static final String DATABASE_NAME = "xmlParse.db";
//	private static final int DATABASE_VERSION = 1;
//
//	private Context context;
//
//	public PlaceDataSQL(Context context) {
//		super(context, DATABASE_NAME, null, DATABASE_VERSION);
//		this.context = context;
//	}
//
//	@Override
//	public void onCreate(SQLiteDatabase db) {
//		db.execSQL("CREATE TABLE xmlTable (id INTEGER PRIMARY KEY AUTOINCREMENT,name varchar(20), description varchar(20), " +
//				"cost varchar(20))");
//	}
//
//	
//	private void versionUpdation(SQLiteDatabase db) {
//
//	}
//
//	/**
//	 * Check if the database already exist to avoid re-copying the file each
//	 * time you open the application.
//	 * 
//	 * @return true if it exists, false if it doesn't
//	 */
//	public boolean checkDataBase(String db) {
//
//		SQLiteDatabase checkDB = null;
//
//		try {
//			String myPath = "data/data/"+ context.getPackageName() +"/databases/" + db;
//			checkDB = SQLiteDatabase.openDatabase(myPath, null,
//					SQLiteDatabase.OPEN_READONLY);
//
//		} catch (SQLiteException e) {
//
//			// database does't exist yet.
//
//		} catch (Exception e) {
//
//		}
//
//		if (checkDB != null) {
//
//			checkDB.close();
//
//		}
//
//		return checkDB != null ? true : false;
//	}
//
//	@Override
//	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//		if (oldVersion >= newVersion)
//			return;
//
//		if (oldVersion == 1) {
//			Log.d("New Version", "Datas can be upgraded");
//		}
//
//		Log.d("Sample Data", "onUpgrade	: " + newVersion);
//	}
//
