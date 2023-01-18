package com.example.booksapp.entity.login

//import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
//import org.jetbrains.annotations.NotNull

@Entity(tableName = "login")
data class Login(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = "FirstName") val firstName: String?,
    @ColumnInfo(name = "LastName") val lastName: String?,
    @ColumnInfo(name = "EmailId") val emailID: String?,
    @ColumnInfo(name = "Password") val password: String?
)
