package com.example.booksapp.Entities.Relations.Books_Receiver

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.booksapp.Books.Books
import com.example.booksapp.Entities.Relations.Books_Donor.DonorBooksCross
import com.example.booksapp.receiver.Receiver

data class BooksWithReceivers(
    @Embedded val Books:Books,
    @Relation(
        parentColumn = "bookid",
        entityColumn = "book_id",
        associateBy= Junction(DonorBooksCross::class)
    )
    val receiver:  List<Receiver>
)