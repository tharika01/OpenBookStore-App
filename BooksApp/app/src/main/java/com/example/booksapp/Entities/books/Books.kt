
package com.example.booksapp.Books

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


///We declared Receiver table here with primary key indication as well
@Entity(tableName = "books_table")//, primaryKeys = ["bookid","categoryid"])
data class Books(
    //@ColumnInfo(name= "bookid") val bookid: Int?,
    @PrimaryKey(autoGenerate = true) val bookid :Int?,
    @ColumnInfo(name= "BName") val bname: String?,
    @ColumnInfo(name= "categoryid") val categoryid: Int?,
    @ColumnInfo(name= "No_of_books") val noofbooks: Int?,
)