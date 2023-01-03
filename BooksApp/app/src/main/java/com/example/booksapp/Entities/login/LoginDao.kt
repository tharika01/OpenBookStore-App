package com.example.booksapp.Entities.login

import androidx.room.*
import androidx.room.Query
import com.example.booksapp.Entities.donor.Donor

@Dao
interface LoginDao {
    @Query("INSERT INTO LOGIN(firstName, lastName, emailID, password) VALUES(:fName,:lName, :emailID, :pass)")
    fun insert(fName:String, lName: String, emailID : String, pass:String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDonor(donor: Donor)


    /*@Query("SELECT * FROM login WHERE emailID=:emailID")
    suspend fun emailexists(emailID: String)*/

    @Transaction
    @Query("SELECT id FROM LOGIN where emailID LIKE :emailID and password LIKE :pass")
    suspend fun authorize_user(emailID : String, pass: String) : Int
    /*{
            return 1
        }*/
    /*@Transaction
    @Query("SELECT * FROM donor_table WHERE donorid= :donorid")
    suspend fun getDonorswhoLoggedin(donorid: Int): List<DonorswhoLoggedin>*/
}