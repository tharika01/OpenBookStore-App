package com.example.booksapp.entity.Relations.Books_Donor

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.booksapp.Books.Books
import com.example.booksapp.entity.donor.Donor

data class DonorswithBooks(
    @Embedded val donor: Donor,
    @Relation(
        parentColumn = "DonorID",
        entityColumn = "bookid",
        associateBy= Junction(DonorBooksCross::class)
    )
    val Books: List<Books>
)