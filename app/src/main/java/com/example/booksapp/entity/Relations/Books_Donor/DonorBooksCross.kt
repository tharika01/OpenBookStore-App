package com.example.booksapp.entity.Relations.Books_Donor

import androidx.room.Entity

@Entity(primaryKeys = ["DonorID","bookid"])
data class DonorBooksCross (
    val DonorID: Int,
    val bookid: Int
)