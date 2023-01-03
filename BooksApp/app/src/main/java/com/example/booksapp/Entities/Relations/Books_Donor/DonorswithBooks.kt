package com.example.booksapp.Entities.Relations.Books_Donor

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.booksapp.Books.Books
import com.example.booksapp.Entities.Relations.Books_Donor.DonorBooksCross

data class DonorswithBooks(
    @Embedded val books: Books,
    @Relation(
        parentColumn = "book_id",
        entityColumn = "bookid",
        associateBy= Junction(DonorBooksCross::class)
    )
    val Books: List<Books>
)