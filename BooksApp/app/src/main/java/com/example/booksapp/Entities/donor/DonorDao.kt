package com.example.booksapp.Entities.donor

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
    //@Insert(onConflict = OnConflictStrategy.IGNORE)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(donor: Donor) //Called using student method in MainActivity.kt


    //updating donor table with book details
    @Query("UPDATE donor_table " +
            "SET DBook_name = :bookName,DBook_id = :bookNo " +
            "WHERE donorid = :id")
    suspend fun update(bookName: String, bookNo: String, id: Int?)
    /*@Update
    suspend fun update(bookName: String, bookNo: String)*/

    @Delete
    suspend fun delete(donor: Donor)

    @Query("DELETE FROM donor_table")
    suspend fun  deleteAll()
}