package com.example.donor_app
//Responsible for creating actual database
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.donor.DonorDao

@Database(entities = [Donor :: class], version=1)
abstract class AppDatabase:RoomDatabase() {

    abstract fun donorDao() : DonorDao

    //Only one instance of database is created throughout the app and will synchronise as well

    companion object{
        @Volatile
        private var INSTANCE : AppDatabase? = null

        //Will create new database
        //method will ensure that if the current instance is not equal to null then return the
        //the existing instance it will text context as argument
        //But the the app database is created for the first time and do not have the current instance of that then we will create it
        fun getDatabase(context : Context): AppDatabase{
            val tempInstance = INSTANCE
            if (tempInstance !=null){
                return tempInstance
            }
            //If it is been called from three diff places then all of them will not be executed instance it will wait for the first thread to complete
             synchronized(this){

                 //create app database for the first time
                 val instance = Room.databaseBuilder(
                     context.applicationContext,
                     AppDatabase::class.java,
                     "app_database"
                 ).build()
                 INSTANCE = instance
                 return instance
             }
        }
    }
}