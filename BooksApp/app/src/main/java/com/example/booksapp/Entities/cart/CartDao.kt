package com.example.booksapp.Entities.cart

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface CartDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(cart: Cart)
}