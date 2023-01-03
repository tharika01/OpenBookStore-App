package com.example.booksapp.Books

import androidx.room.* //data access object

//We will write all the queries related to our database here

@Dao
interface BooksDao {

    @Query("SELECT * FROM books_table")
    fun getAll(): List<Books>

    /*@Query("SELECT BName FROM books_table WHERE bookid = :bookid " )
    suspend fun findById(bookid: Int) : Books*/

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(donor: Books) //Called using book method in MainActivity.kt

    @Delete
    suspend fun delete(donor:Books)

    @Query("DELETE FROM donor_table")
    suspend fun  deleteAll()
}