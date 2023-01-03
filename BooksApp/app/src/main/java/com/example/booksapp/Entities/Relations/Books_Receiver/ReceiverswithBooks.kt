package com.example.booksapp.Entities.Relations.Books_Receiver

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.booksapp.Books.Books

data class ReceiverswithBooks(
    @Embedded val books: Books,
    @Relation(
        parentColumn = "rbook_id",
        entityColumn = "bookid",
        associateBy= Junction(ReceiverBooksCross::class)
    )
    val Books: List<Books>
)