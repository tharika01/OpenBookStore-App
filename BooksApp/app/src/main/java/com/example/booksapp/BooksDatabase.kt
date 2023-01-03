package com.example.booksapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.booksapp.Books.Books
import com.example.booksapp.Books.BooksDao
import com.example.booksapp.Entities.DBProjectDao
import com.example.booksapp.Entities.book_category.BookCategory
import com.example.booksapp.Entities.book_category.BookCategoryDao
import com.example.booksapp.Entities.cart.Cart
import com.example.booksapp.Entities.cart.CartDao
import com.example.booksapp.Entities.donor.Donor
import com.example.booksapp.Entities.donor.DonorDao
import com.example.booksapp.Entities.login.Login
import com.example.booksapp.Entities.login.LoginDao
import com.example.booksapp.receiver.Receiver
import com.example.booksapp.receiver.ReceiverDao

@Database(entities = [Login :: class,
                      Donor :: class,
                      Cart :: class,
                      Books :: class,
                      Receiver :: class,
                      BookCategory :: class], version = 1)
abstract class BooksDatabase : RoomDatabase() {
    abstract fun DBProjectDao() : DBProjectDao
    abstract fun LoginDao() : LoginDao
    abstract fun DonorDao(): DonorDao
    abstract fun BookCategoryDao(): BookCategoryDao
    abstract fun CartDao(): CartDao
    abstract fun BooksDao(): BooksDao
    abstract fun ReceiverDao(): ReceiverDao

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
                    "database5"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}