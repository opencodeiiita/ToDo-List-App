package com.example.shivansh.to_dolist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public final static String DATABASE_NAME = "todolist.db";
    public final static String TABLE_NAME = "todolist_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "TASK";
    public static final String COL_3 = "DESCRIPTION";
    public static final String COL_4 = "DEADLINE";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME +"(ID INTEGER PRIMARY KEY AUTOINCREMENT,TASK TEXT,DESCRIPTION TEXT,DEADLINE INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }
    
     boolean addEmployee(String id, String task, String description, String salary) {
        ContentValues contentValues = new ContentValues();
         boolean addEmployee(String id, String task, String description, String deadline) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, task);
        contentValues.put(COL_3, description);
        contentValues.put(COL_4, salary);
        SQLiteDatabase db = getWritableDatabase();
        return db.insert(TABLE_NAME, null, contentValues) != -1;
    }
 
 
    /*
    * READ OPERATION
    * =================
    * Here we are reading values from the database
    * First we called the getReadableDatabase() method it will return us the SQLiteDatabase instance
    * but using it we can only perform the read operations.
    *
    * We are running rawQuery() method by passing the select query.
    * rawQuery takes two parameters
    * 1. The query
    * 2. String[] -> Arguments that is to be binded -> We use it when we have a where clause in our query to bind the where value
    *
    * rawQuery returns a Cursor object having all the data fetched from database
    * */
    Cursor getAllEmployees() {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }
 
    /*
    * UPDATE OPERATION
    * ==================
    */
    boolean updateEmployee(int id, String name, String description, String deadline) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
      
        contentValues.put(COL_2, task);
        contentValues.put(COL_3, description);
        contentValues.put(COL_4, deadline);
        return db.update(TABLE_NAME, contentValues, COL_1 + "=?", new String[]{String.valueOf(id)}) == 1;
    }
 
 
    /*
    * DELETE OPERATION
    * ======================
    */
     boolean addEmployee(String name, String dept, String joiningdate, double salary) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, task);
        contentValues.put(COL_3, description);
        contentValues.put(COL_4, deadline);
        SQLiteDatabase db = getWritableDatabase();
        return db.insert(TABLE_NAME, null, contentValues) != -1;
    }
 
 
    /*
    * READ OPERATION
    * =================
    */
    Cursor getAllEmployees() {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }
 
    /*
    * UPDATE OPERATION
    * ==================
     */
    boolean updateEmployee(int id, String name, String dept, double salary) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, task);
        contentValues.put(COL_3, description);
        contentValues.put(COL_4, salary);
        return db.update(TABLE_NAME, contentValues, COLUMN_ID + "=?", new String[]{String.valueOf(id)}) == 1;
    }
 
 
    /*
    * DELETE OPERATION
    * ======================
   */
    boolean deleteEmployee(int id) {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(TABLE_NAME, COL_1 + "=?", new String[]{String.valueOf(id)}) == 1;
    }
    * 2. String -> The where clause passed as columnname = ? 
    * 3. String[] -> The values to be binded on the where clause 
    * */
    boolean deleteEmployee(int id) {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(TABLE_NAME, COL_1 + "=?", new String[]{String.valueOf(id)}) == 1;
   
        contentValues.put(COLUMN_3, description);
        contentValues.put(COLUMN_4, deadline);
       
        SQLiteDatabase db = getWritableDatabase();
        return db.insert(TABLE_NAME, null, contentValues) != -1;
    }
 
 
    /*
    * READ OPERATION
    * =================
    */
    Cursor getAllEmployees() {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }
 
    /*
    * UPDATE OPERATION
    * ==================
    */
    boolean updateEmployee(int id, String name, String dept, double salary) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
       
        contentValues.put(COL_2, task);
        contentValues.put(COL_3, description);
        contentValues.put(COL_4, salary);
        return db.update(TABLE_NAME, contentValues, COL_1 + "=?", new String[]{String.valueOf(id)}) == 1;
    }
 
 
    /*
    * DELETE OPERATION
    * ======================
    */
    boolean deleteEmployee(int id) {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(TABLE_NAME, COL_1 + "=?", new String[]{String.valueOf(id)}) == 1;
    }
}
