package com.example.booksapp.Entities.Relations.Books_Receiver

import androidx.room.Entity

@Entity(primaryKeys = ["book_id","bookid"])
data class ReceiverBooksCross (
    val book_id: Int,
    val bookid: Int
)

