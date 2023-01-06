package com.example.booksapp.Entities.cart

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Cart")//, primaryKeys =["CBookID", "CReceiverID"])
data class Cart(
    //@ColumnInfo(name = "CBookID") val bookID: Int?,
    @PrimaryKey(autoGenerate = true) val CBookID :Int?,
    @ColumnInfo(name = "quantity") val quantity:  Int?,
    @ColumnInfo(name = "BookName") val bookName: String?,
    @ColumnInfo(name = "CReceiverID") val receiverid: Int?
)
