package com.pouya11.buyinglist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by HP on 16/12/2016.
 */
public class DatabaseHelper {
    private SQLiteDatabase db;
    private int oldVersion;
    private int newVersion;

    public DatabaseHelper(Context context) {
super(context,"buyinglist",null,1);
    }

  @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE tbl_phone(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name VARCHAR(255) NULL," +
                "factory VARCHAR(255) NULL," +
                ")";
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}


