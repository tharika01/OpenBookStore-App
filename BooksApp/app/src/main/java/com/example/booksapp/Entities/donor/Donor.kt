package com.example.booksapp.Entities.donor

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo

//We declared Donor table here with primary key indication as well
@Entity(tableName = "donor_table")
data class Donor(
    @PrimaryKey(autoGenerate = true) val donorid: Int?,
    @ColumnInfo(name= "DFName") val dfname: String?,
    @ColumnInfo(name="DLName") val dlname:String?,
    @ColumnInfo(name= "DPh.No") val dphno: String?,
    @ColumnInfo(name= "DAddress") val daddress: String?,
    @ColumnInfo(name= "DEmail_ID") val demailid: String?,
    @ColumnInfo(name= "DBook_name") val dbookname: String?,
    @ColumnInfo(name= "DBook_id")val book_id: String?

)

