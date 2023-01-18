package com.example.booksapp.entity.Relations.Books_Receiver

import androidx.room.Entity

@Entity(primaryKeys = ["ReceiverID","bookid"])
data class ReceiverBooksCross (
    val ReceiverID: Int,
    val bookid: Int
)

