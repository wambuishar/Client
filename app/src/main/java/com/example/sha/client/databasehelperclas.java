
package com.example.sha.client;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.provider.FontsContractCompat;

import static android.support.v4.provider.FontsContractCompat.*;

public class databasehelperclas extends SQLiteOpenHelper

{
    public static final String DATABASE_NAME = "Register.db";
    public static final String TABLE_NAME = "Register_table";
    public static final String Col_1 = "ID";
    public static final String Col_2 = "PHONE";
    public static final String Col_3 = "USER_NAME";
    public static final String Col_4 = "EMAIL";
    public static final String Col_5 = "PASSWORD";
    public static final String Col_6 = "PASSWORD";


//    -----------------------------------------------


    public static final String Table_name = "Contact_table";
    public static final String Col_21 = "ID";
    public static final String Col_22 = "NAME";
    public static final String Col_23 = "Phone";
    public static final String Col_24 = "EMAIL";

    public databasehelperclas(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + " (ID INTERGER PRIMARY KEY, NAME TEXT, USER_NAME TEXT, EMAIL VARCHAR, PASSWORD TEXT)");
        sqLiteDatabase.execSQL("create table " + Table_name + " (ID INTERGER PRIMARY KEY, NAME TEXT, EMAIL VARCHAR, PHONE INTERGER,PASSWORD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if EXISTS " + TABLE_NAME);
        sqLiteDatabase.execSQL("drop table if EXISTS " + Table_name);
        onCreate(sqLiteDatabase);

    }

    public boolean insertData(String name, String user_name, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase( );
        ContentValues contentValues = new ContentValues( );
        contentValues.put(Col_2, name);
        contentValues.put(Col_3, user_name);
        contentValues.put(Col_4, email);
        contentValues.put(Col_5, password);

        long results = db.insert(TABLE_NAME, null, contentValues);
        return results != -1;
    }

    public boolean insertData2(String name, int phone, String email) {
        SQLiteDatabase db = this.getWritableDatabase( );
        ContentValues contentValues = new ContentValues( );
        contentValues.put(Col_22, name);
        contentValues.put(Col_23, email);
        contentValues.put(Col_24, phone);
        long results = db.insert(Table_name, null, contentValues);
        return results != -1;

    }
    public boolean chemail(String email) {
        SQLiteDatabase db = this.getReadableDatabase( );
        Cursor cursor = db.rawQuery("select * from Register_table where email=?", new String[]{email});
        int cursor_count = cursor.getCount( );
        cursor.close( );
        return cursor_count > 0;
    }

    public boolean emailpassword(String password, String email) {
        SQLiteDatabase db = this.getReadableDatabase( );
        Cursor cursor = db.rawQuery("select * from Register_table where password=? and email=?", new String[]{password, email});
        int cursor_count = cursor.getCount( );
        cursor.close( );
        return cursor_count > 0;
    }

    public Cursor deleteAll() {
        Cursor c = getAllRows( );
        long rowId = c.getColumnIndexOrThrow(Col_1);
        if (c.moveToFirst( )) {
            do {
                deleteAll( );
            }
            while (c.moveToNext( ));
        }
        c.close( );
        return c;
    }

    public Cursor getAllRows(){
        String[] columns = new String[] { Col_23, Col_22 };

        SQLiteDatabase db = this.getReadableDatabase( );

        Cursor c = db.query(DATABASE_NAME, columns,null,null,null,null,null);
        if (c !=null){
            c.moveToFirst();
        }
        return c;
    }
}


