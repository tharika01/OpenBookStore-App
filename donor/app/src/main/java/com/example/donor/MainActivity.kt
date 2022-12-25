package com.example.myapplication

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    //view binding

    private lateinit var binding : ActivityMainBinding
    private lateinit var appDb : AppDatabase //Reference variable for our database


    override fun onCreate(savedInstanceState: Bundle?) {
        //WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Initialize DB to our app
        appDb=AppDatabase.getDatabase(this)

        //Calling write data and read data methods
        binding.btnWriteData.setOnClickListener {
            writeData()
        }

        //binding.btnReadData.setOnClickListener {
            //readData()
        //}
    }

    private fun writeData(){

        val firstName= binding.etFirstName.text.toString()
        val lastName = binding.etLastName.text.toString()
        //donor id add

            //make sure first two boxes are not empty
        if(firstName.isNotEmpty() && lastName.isNotEmpty()) {
            //Create object for our donor
            //Pass null for donor id as it is auto generated
            val donor = Donor(
                null, firstName, lastName, null, null, null, null, null
            )
            // Coroutine: Just like IO type operation
            //Calling all the methods inside coroutines
            GlobalScope.launch(Dispatchers.IO) {
                //Putting all the details to table
                appDb.donorDao()
                    .insert(donor) //Calling insert method of donordao by passing object donor
            }

            //clear all input text fields
            binding.etFirstName.text.clear()
            binding.etLastName.text.clear()

            Toast.makeText(this@MainActivity, "Successfully updated", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this@MainActivity,"Please Enter data",Toast.LENGTH_SHORT).show()
        }

    }

   /* private fun readData(){

        val donorfname = binding.etFirstName.text.toString()

        //Donor id not empty
        if(donorfname.isNotEmpty()){
            lateinit var donor: Donor

            GlobalScope.launch {
                donor=appDb.donorDao().getAll()
            }
        }

    }*/
}


