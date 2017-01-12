package com.pouya11.buyinglist;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by HP on 16/12/2016.
 */
public class PhoneRecord {
    private long id;
    private String name;
    private String factory;


    public PhoneRecord() {


    }

    public PhoneRecord(int id, String name, String factory) {
        this.setId(id);
        this.setName(name);
        this.setFactory(factory);

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }

    public String getfactory() {return factory;}

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public void save(Context context) {
        DatabaseHelper dbh = new DatabaseHelper(context);
       SQLiteDatabase db = dbh.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", this.getName());
        contentValues.put("factory", this.getName());
        this.setId(db.insert("tbl_phone", null, contentValues));

    }
}

