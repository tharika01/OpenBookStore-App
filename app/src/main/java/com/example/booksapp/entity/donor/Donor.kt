package com.example.booksapp.entity.donor

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo

//We declared Donor table here with primary key indication as well
@Entity(tableName = "donor_table")
data class Donor(
    //@ColumnInfo(name= "DonorID") val donorid: Int?,
    @PrimaryKey(autoGenerate = true) val DonorID: Int?,
    @ColumnInfo(name= "DFName") val dfname: String?,
    @ColumnInfo(name="DLName") val dlname:String?,
    @ColumnInfo(name= "DPh.No") val dphno: String?,
    @ColumnInfo(name= "DAddress") val daddress: String?,
    @ColumnInfo(name= "DEmail_ID") val demailid: String?,
    @ColumnInfo(name= "DBook_name") val dbookname: String?,
    @ColumnInfo(name= "DBookID") val book_id: String?,
    val photourl: String?
)

