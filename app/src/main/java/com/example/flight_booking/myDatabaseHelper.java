package com.example.flight_booking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class myDatabaseHelper extends SQLiteOpenHelper {
    public myDatabaseHelper(Context context) {
        super(context, "database.db",null, 5);
    }

    @Override //database is created for the first time
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE register(id INTEGER PRIMARY KEY, username TEXT,email TEXT,password TEXT,amount INTEGER default 1000.0)";
        db.execSQL(createTableQuery);
        String createTableQuery2 = "CREATE TABLE history(id INTEGER PRIMARY KEY, username TEXT,password TEXT,ticket_value TEXT)";
        db.execSQL(createTableQuery2);
    }

    @Override//when schema is changed
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS register");
        db.execSQL("DROP TABLE IF EXISTS history");
        onCreate(db);
    }

    public Boolean insert(String username,String email,String password)
    {
        //account number generator
        Random random = new Random();

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("email",email);
        values.put("password",password);
        long result = db.insert("register", null, values);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Boolean checkUsername(String username)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from register where username = ?",new String[]{username});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkEmail(String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from register where email = ?",new String[]{email});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Boolean checkPassword(String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from register where password = ?",new String[]{password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public int getBalance(String username,String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select amount from register where username =? and password = ?",new String[]{username,password});
        int amount = 1;
        if(cursor.moveToFirst())
        {
            do{
                amount = cursor.getInt(cursor.getColumnIndexOrThrow("amount"));
                Log.d("Amount", String.valueOf(amount));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return amount;
    }

    public void setBalance(String username,String password,int amount_balance)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update register set amount = ?  where username =? and password = ?",new Object[]{amount_balance,username,password});
        db.close();
    }

    public int insert_history(String username, String password, String ticket_value)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("insert into history(username,password,ticket_value)values(?,?,?)",new Object[]{username,password,ticket_value});
        db.close();
        return 0;
    }

    public int delete(String username, String password, String ticket_value)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from history where username =? and password =? and ticket_value =?",new Object[]{username,password,ticket_value});
        db.close();
        return 0;
    }

    public ArrayList<String> getHistory(String username,String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select ticket_value from history where username =? and password = ?",new String[]{username,password});
        String amount = "";
        ArrayList<String> arr = new ArrayList<>();
        String s;
        if(cursor.moveToFirst())
        {
            do{
                amount = cursor.getString(cursor.getColumnIndexOrThrow("ticket_value"));
//                Log.d("Amount", String.valueOf(amount));
                arr.add(amount);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return arr;
    }

}
