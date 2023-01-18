package com.example.booksapp.entity.Relations.Donor_Receiver

import androidx.room.Entity

@Entity(primaryKeys=["DonorID", "ReceiverID"])
data class DonorReceiverCross (
    val DonorID: Int,
    val ReceiverID:Int
)
