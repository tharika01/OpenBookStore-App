
package com.example.booksapp.Books

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


//We declared Receiver table here with primary key indication as well
@Entity(tableName = "books_table")
data class Books(
    @PrimaryKey(autoGenerate = true) val bookid: Int?,
    @ColumnInfo(name= "BName") val bname: String,
    @ColumnInfo(name= "Category_ID") val categoryid: Int,
    @ColumnInfo(name= "No_of_books") val noofbooks: Int?,

    )