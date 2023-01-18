package com.example.booksapp.entity.Relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.booksapp.entity.donor.Donor
import com.example.booksapp.entity.login.Login

class DonorsWithLogin (
    @Embedded val login: Login,
    @Relation(
        parentColumn = "id",
        entityColumn="donorid"
    )
    val donors: List<Donor>
    )
