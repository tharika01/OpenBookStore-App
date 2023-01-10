package com.example.booksapp.Entities.Relations.Donor_Receiver

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.booksapp.Entities.Relations.Donor_Receiver.DonorReceiverCross
import com.example.booksapp.Entities.donor.Donor
import com.example.booksapp.receiver.Receiver

data class ReceiverwithDonors(
    @Embedded val receiver: Receiver,
    @Relation(
        parentColumn = "ReceiverID",
        entityColumn = "DonorID",
        associateBy= Junction(DonorReceiverCross::class)
    )
    val donor: List<Donor>
)