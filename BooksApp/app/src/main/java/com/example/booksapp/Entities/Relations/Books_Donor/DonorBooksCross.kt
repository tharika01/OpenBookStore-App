package com.example.booksapp.Entities.Relations.Books_Donor

import androidx.room.Entity

@Entity(primaryKeys = ["rbook_id","bookid"])
data class DonorBooksCross (
    val rbook_id: Int,
    val bookid: Int

    )