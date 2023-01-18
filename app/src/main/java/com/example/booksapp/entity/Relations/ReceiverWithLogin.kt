
package com.example.booksapp.entity.Relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.booksapp.entity.login.Login
import com.example.booksapp.receiver.Receiver

class ReceiverWithLogin (
    @Embedded val login: Login,
    @Relation(
        parentColumn = "id",
        entityColumn="receiverid"
    )
    val donors: List<Receiver>

)
