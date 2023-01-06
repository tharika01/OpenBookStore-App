package com.example.booksapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.booksapp.Books.Books
import com.example.booksapp.Entities.DBProjectDao
import com.example.booksapp.Entities.Relations.Books_Donor.DonorBooksCross
import com.example.booksapp.Entities.Relations.Books_Receiver.ReceiverBooksCross
import com.example.booksapp.Entities.Relations.Donor_Receiver.DonorReceiverCross
import com.example.booksapp.Entities.book_category.BookCategory
import com.example.booksapp.Entities.cart.Cart
import com.example.booksapp.Entities.donor.Donor
import com.example.booksapp.Entities.login.Login
import com.example.booksapp.receiver.Receiver

@Database(entities = [Login :: class,
    Donor :: class,
    Cart :: class,
    Books :: class,
    Receiver :: class,
    BookCategory :: class ,
    DonorBooksCross :: class,
    ReceiverBooksCross :: class,
    DonorReceiverCross :: class], version = 1)
abstract class BooksDatabase : RoomDatabase() {
    abstract val dbProjectDao : DBProjectDao

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
                    "database6"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}