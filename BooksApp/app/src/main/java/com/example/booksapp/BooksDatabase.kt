package com.example.booksapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.booksapp.donor.Donor
import com.example.booksapp.donor.DonorDao
import com.example.booksapp.login.Login
import com.example.booksapp.login.LoginDao

@Database(entities = [Login :: class, Donor :: class], version = 1)
abstract class BooksDatabase : RoomDatabase() {
    abstract fun LoginDao() : LoginDao
    companion object {
        @Volatile
        private var INSTANCE: BooksDatabase? = null
        fun getDatabase(context: Context): BooksDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BooksDatabase::class.java,
                    "books_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
    abstract fun DonorDao(): DonorDao
}