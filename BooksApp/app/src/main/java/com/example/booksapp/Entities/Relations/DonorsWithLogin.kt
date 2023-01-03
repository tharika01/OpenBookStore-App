package com.example.booksapp.Entities.Relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.booksapp.Entities.donor.Donor
import com.example.booksapp.Entities.login.Login

class DonorsWithLogin (
    @Embedded val login: Login,
    @Relation(
        parentColumn = "id",
        entityColumn="donorid"
    )
    val donors: List<Donor>
    )
