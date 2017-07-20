package com.example.ma.lecture7;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by MA on 7/17/2017.
 */

public class CartDB extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "cart.db";
    public static final String TABLE_NAME = "cart_item_table";
    public static final String COL_1 = "product_id";
    public static final String COL_2 = "product_name";
    public static final String COL_3 = "product_price";
    public static final String COL_4 = "product_discount";
    public static final String COL_5 = "product_quantity";
    public static final String COL_6 = "product_image";



    public CartDB(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (product_id INTEGER PRIMARY KEY AUTOINCREMENT,product_name TEXT,product_price INTEGER,MARKS INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
