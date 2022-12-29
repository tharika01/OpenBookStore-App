package com.example.booksapp.Entities.book_category

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface BookCategoryDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(bookCategory: BookCategory){}
}