package com.example.booksapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.booksapp.databinding.ActivityDonorBinding
import com.example.booksapp.donor.Donor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DonorActivity : AppCompatActivity() {
    //view binding

    private lateinit var binding : ActivityDonorBinding
    private lateinit var appDb : BooksDatabase //Reference variable for our database


    override fun onCreate(savedInstanceState: Bundle?) {
        //WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        binding= ActivityDonorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Initialize DB to our app
        appDb= BooksDatabase.getDatabase(this)

        //Calling write data and read data methods
        binding.btnWriteData.setOnClickListener {
            writeData()
        }

        binding.btnReadData.setOnClickListener {
            readData()
        }
    }

    private fun writeData(){

        val firstName= binding.etFirstName.text.toString()
        val lastName = binding.etLastName.text.toString()
        val bookNumber =binding.etbookNumber.text.toString()
        val address=binding.etaddress.text.toString()
        val emailId=binding.etemailId.text.toString()
        val phoneNumber=binding.etphoneNumber.text.toString()
        val bookName= binding.etbookName.text.toString()
        //donor id add

        //make sure first two boxes are not empty
        if(firstName.isNotEmpty() && lastName.isNotEmpty()) {
            //Create object for our donor
            //Pass null for donor id as it is auto generated
            val donor = Donor(
                null, firstName, lastName, phoneNumber, address, emailId, bookName,bookNumber
            )

            // Coroutine: Just like IO type operation
            //Calling all the methods inside coroutines
            GlobalScope.launch(Dispatchers.IO) {
                //Putting all the details to table
                appDb.DonorDao().insert(donor) //Calling insert method of donordao by passing object donor
            }

            //clear all input text fields
            binding.etFirstName.text.clear()
            binding.etLastName.text.clear()

            Toast.makeText(this@DonorActivity, "Successfully updated", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this@DonorActivity,"Please Enter data", Toast.LENGTH_SHORT).show()
        }

    }

    //Displaying the read data
    private suspend fun displayData(donor: Donor){
        withContext(Dispatchers.Main){
            binding.tvFirstName.text = donor.dfname
            binding.tvLastName.text= donor.dlname
            binding.tvRollNo.text = donor.donorid.toString()
        }
    }

    private fun readData() {

        val donorid = binding.etDonorNoRead.text.toString()

        //Donor id not empty
        if (donorid.isNotEmpty()) {
            lateinit var donor: Donor

            GlobalScope.launch {
                donor = appDb.DonorDao().findById(donorid.toInt())
                displayData(donor)
            }
        }
    }
}
