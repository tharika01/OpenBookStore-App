package com.example.booksapp.entity.Relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.booksapp.entity.cart.Cart
import com.example.booksapp.receiver.Receiver


class ReceiverAndCart(
    @Embedded
    val receiver: Receiver,
    @Relation(
        parentColumn = "ReceiverID",
        entityColumn=  "CReceiverID"
    )
    val cart: Cart
)