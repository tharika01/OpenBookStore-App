package com.example.booksapp.entity.book_category

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BookCategory(
    @PrimaryKey(autoGenerate = false)
    val category_id : Int?,
    @ColumnInfo(name= "availability") val availability: Long?,
    @ColumnInfo(name = "genre") val genre : String?
)




