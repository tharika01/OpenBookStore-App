@file:Suppress("UNREACHABLE_CODE")

package com.example.booksapp


//import android.content.ContentValues
import android.content.Context
//import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DbHelper(context: Context) : SQLiteOpenHelper(context, "BOOKS.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        TODO("creating login table")
        //db?.execSQL("CREATE TABLE SIGNUP(FNAME TEXT NOT NULL, LNAME TEXT NOT NULL, EMAIL TEXT PRIMARY KEY , PASSWORD TEXT NOT NULL)")
        db?.execSQL("CREATE TABLE LOGIN(EMAIL PRIMARY KEY,PASSWORD TEXT NOT NULL)")
        db?.execSQL("INSERT INTO LOGIN VALUES('tharika@gmail.com', '123')")
        db?.execSQL("INSERT INTO LOGIN VALUES('sinchu@gmail.com', '456')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("creating new table everytime new data is inserted")
//        db?.execSQL("DROP TABLE IF EXISTS SIGNUP")
//        onCreate(db)
    }
}