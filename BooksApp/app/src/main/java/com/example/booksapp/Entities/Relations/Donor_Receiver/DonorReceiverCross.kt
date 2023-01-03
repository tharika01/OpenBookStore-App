package com.example.booksapp.Entities.Relations.Donor_Receiver

import androidx.room.Entity

@Entity(primaryKeys=["bookid","donorid", "receiverid"])
data class DonorReceiverCross (
    val bookid: Int,
    val donorid: Int,
    val receiverid :Int
    )
