package com.example.booksapp.Entities.Relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.booksapp.Entities.cart.Cart
import com.example.booksapp.receiver.Receiver

class ReceiverAndCart(
    @Embedded
    val receiver: Receiver,
    @Relation
        (
        parentColumn = "rbook_id",
        entityColumn=  "bookID"
    )
    val cart: Cart
)
