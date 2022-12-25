package com.example.booksapp.donor

import androidx.room.* //data access object

//We will write all the queries related to our database here

@Dao
interface DonorDao {

    @Query("SELECT * FROM donor_table")
    fun getAll(): List<Donor>

    @Query("SELECT DFName,DLName FROM donor_table WHERE donorid = :donorid " )
    suspend fun findById(donorid: Int) : Donor

    //suspend fun fi

    //suspend function we will do the operation in coroutines
    //since the insertion are IO operation it will take lot of time
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(donor: Donor) //Called using student method in MainActivity.kt

    @Delete
    suspend fun delete(donor: Donor)

    @Query("DELETE FROM donor_table")
    suspend fun  deleteAll()
}