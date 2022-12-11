@file:Suppress("UNREACHABLE_CODE")

package com.example.booksapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

//creating database named BOOKS

class DbHelper(context: Context) : SQLiteOpenHelper(context, "BOOKS", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        //creating table
        db?.execSQL("CREATE TABLE LOGIN(FNAME VARCHAR(20) NOT NULL, LNAME VARCHAR(20) NOT NULL, EMAIL TEXT PRIMARY KEY , PASSWORD TEXT NOT NULL)")
        //Inserting data into the table
        db?.execSQL("INSERT INTO LOGIN VALUES('sinchu', 'AC', 'sinchu@gmail.com', '456')")
        db?.execSQL("INSERT INTO LOGIN VALUES('thari','k','tharika@gmail.com', '123')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}
