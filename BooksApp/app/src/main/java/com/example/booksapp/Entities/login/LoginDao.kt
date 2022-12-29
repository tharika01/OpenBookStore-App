package com.example.booksapp.Entities.login

import androidx.room.*
import androidx.room.Query
import java.util.concurrent.Flow
import com.example.booksapp.Entities.login.LoginDao as LoginDao1

@Dao
interface LoginDao {
    @Query("INSERT INTO LOGIN(firstName, lastName, emailID, password) VALUES(:fName,:lName, :emailID, :pass)")
    fun insert(fName:String, lName: String, emailID : String, pass:String)

    /*@Query("SELECT * FROM login WHERE emailID=:emailID")
    suspend fun emailexists(emailID: String)*/

    @Query("SELECT id FROM LOGIN where emailID LIKE :emailID and password LIKE :pass")
    suspend fun authorize_user(emailID : String, pass: String) : Int{
        return 1
    }

}