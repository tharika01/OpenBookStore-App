package com.example.booksapp.Entities.Relations.Books_Receiver

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.booksapp.Books.Books
import com.example.booksapp.receiver.Receiver

data class ReceiverswithBooks(
    @Embedded val receiver: Receiver,
    @Relation(
        parentColumn = "ReceiverID",
        entityColumn = "bookid",
        associateBy= Junction(ReceiverBooksCross::class)
    )
    val Books: List<Books>
)