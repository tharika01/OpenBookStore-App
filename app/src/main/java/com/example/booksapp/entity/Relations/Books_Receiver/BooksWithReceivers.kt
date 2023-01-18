package com.example.booksapp.entity.Relations.Books_Receiver

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.booksapp.Books.Books
import com.example.booksapp.receiver.Receiver

data class BooksWithReceivers(
    @Embedded val Books:Books,
    @Relation(
        parentColumn = "bookid",
        entityColumn = "ReceiverID",
        associateBy= Junction(ReceiverBooksCross::class)
    )
    val receiver:  List<Receiver>
)