package com.example.booksapp.receiver

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


    //We declared Receiver table here with primary key indication as well
    @Entity(tableName = "receiver_table")
    data class Receiver(
        @PrimaryKey(autoGenerate = true) val receiverid: Int?,
        @ColumnInfo(name= "RFName") val rfname: String?,
        @ColumnInfo(name="RLName") val rlname:String?,
        @ColumnInfo(name= "RPh.No") val rphno: String?,
        @ColumnInfo(name= "RAddress") val raddress: String?,
        @ColumnInfo(name= "REmail_ID") val remailid: String?,
        @ColumnInfo(name= "RBook_name") val rbookname: String?,
        @ColumnInfo(name= "RBook_id")val rbook_id: String?

    )

