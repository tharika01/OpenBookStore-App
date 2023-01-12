package com.example.booksapp.Entities.donor

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.booksapp.Books.Books
import com.example.booksapp.BooksDatabase
import com.example.booksapp.databinding.ActivityDonorBinding
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

        //val firstName= binding.etFirstName.text.toString()
        //val lastName = binding.etLastName.text.toString()
        val bookNumber =binding.etbookNumber.text.toString()
        //val address=binding.etaddress.text.toString()
        //val emailId=binding.etemailId.text.toString()
        //val phoneNumber=binding.etphoneNumber.text.toString()
        val bookName= binding.etbookName.text.toString()
        val donorID = binding.etDonorID.text.toString()
        val url = binding.photoUrl.text.toString()
        //donor id add

        //make sure first two boxes are not empty
        if(bookName.isNotEmpty() && bookNumber.isNotEmpty()) {
            //Create object for our donor
            val donor = Donor(
                null, null, null,null,null, null, bookName, bookNumber, url
            )
            val book= Books(
                null, bookName,null, null, url
            )
            // Coroutine: Just like IO type operation
            //Calling all the methods inside coroutines
            GlobalScope.launch(Dispatchers.IO) {
                //Putting all the details to table
                appDb.dbProjectDao.updateBook(bookName, bookNumber, donorID, url)
                appDb.dbProjectDao.insertBooks(book)
                //appDb.DonorDao().update(bookName,bookNumber) //Calling insert method of donordao by passing object donor
            }

            //clear all input text fields
            binding.etbookNumber.text.clear()
            binding.etbookName.text.clear()
            binding.photoUrl.text.clear()
            binding.etDonorID.text.clear()
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
            //binding.etbookName.text = donor.dphno
        }
    }

    private fun readData() {

        val donorid = binding.etDonorID.text.toString()

        //Donor id not empty
        if (donorid.isNotEmpty()) {
            lateinit var donor: Donor

            GlobalScope.launch {
                donor = appDb.dbProjectDao.findById(donorid.toInt())
                displayData(donor)
            }
        }
    }
}
