package com.example.booksapp.entity.Relations.Books_Donor

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.booksapp.Books.Books
import com.example.booksapp.entity.donor.Donor

data class BookswithDonors(
    @Embedded val Books: Books,
    @Relation(
        parentColumn = "bookid",
        entityColumn = "DonorID",
        associateBy= Junction(DonorBooksCross::class)
    )
    val donor:  List<Donor>
)