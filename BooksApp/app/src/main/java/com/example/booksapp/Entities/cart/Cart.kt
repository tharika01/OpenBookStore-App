package com.example.booksapp.Entities.cart

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Cart(
    @PrimaryKey(autoGenerate = true) val bookID: Int?,
    @ColumnInfo(name = "quantity") val quantity:  Int?,
    @ColumnInfo(name = "BookName") val bookName: String?
)
