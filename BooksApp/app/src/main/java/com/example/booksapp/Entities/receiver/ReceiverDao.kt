package com.example.booksapp.receiver

import androidx.room.* //data access object

//We will write all the queries related to our database here

@Dao
interface ReceiverDao {

    @Query("SELECT * FROM receiver_table")
    fun getAll(): List<Receiver>

    @Query("SELECT RFName,RLName FROM receiver_table WHERE receiverid = :receiverid " )
    suspend fun findById(receiverid: Int) :Receiver

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(donor: Receiver) //Called using student method in MainActivity.kt

    @Delete
    suspend fun delete(donor: Receiver)

    @Query("DELETE FROM donor_table")
    suspend fun  deleteAll()
}