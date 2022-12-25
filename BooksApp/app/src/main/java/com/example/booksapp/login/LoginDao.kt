package com.example.booksapp.login

import androidx.room.*
import androidx.room.Query

@Dao
interface LoginDao {
    @Query("INSERT INTO LOGIN(firstName, lastName, emailID, password) VALUES(:fName,:lName, :emailID, :pass)")
    fun insert(fName:String, lName: String, emailID : String, pass:String)

    /*@Query("SELECT * FROM login WHERE emailID=:emailID")
    suspend fun emailexists(emailID: String)*/

    /*@Query("SELECT EXISTS(SELECT emailID,password FROM login where emailID = :emailID and password = :pass)")
    suspend fun authorizeuser(emailID : String, pass: String) :Int*/


}