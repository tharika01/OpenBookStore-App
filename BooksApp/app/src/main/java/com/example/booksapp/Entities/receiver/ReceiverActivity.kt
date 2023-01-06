package com.example.booksapp.Entities.receiver

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.booksapp.BooksDatabase
import com.example.booksapp.Entities.donor.Donor

import com.example.booksapp.databinding.ActivityReceiverBinding
import com.example.booksapp.databinding.ActivityReceiverBinding.inflate
import com.example.booksapp.nav_bar.profile.ProfileFragment
import com.example.booksapp.receiver.Receiver

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ReceiverActivity: AppCompatActivity() {
    private lateinit var binding : ActivityReceiverBinding
    private lateinit var appDb : BooksDatabase //Reference variable for our database


    override fun onCreate(savedInstanceState: Bundle?) {
        //WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        binding= ActivityReceiverBinding.inflate(layoutInflater)
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
            val receiver = Receiver(
                null, firstName, lastName, phoneNumber, address, emailId, bookName,bookNumber
            )

            // Coroutine: Just like IO type operation
            //Calling all the methods inside coroutines
            GlobalScope.launch(Dispatchers.IO) {
                //Putting all the details to table
                appDb.dbProjectDao.insertReceiver(receiver) //Calling insert method of donordao by passing object donor
            }

            //clear all input text fields
            binding.etFirstName.text.clear()
            binding.etLastName.text.clear()

            Toast.makeText(this@ReceiverActivity, "Successfully updated", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this@ReceiverActivity,"Please Enter data", Toast.LENGTH_SHORT).show()
        }

    }

    //Displaying the read data
    private suspend fun displayData(receiver: Receiver){
        withContext(Dispatchers.Main){
            binding.tvFirstName.text = receiver.rfname
            binding.tvLastName.text= receiver.rlname
            binding.tvRollNo.text = receiver.ReceiverID.toString()
        }
    }

    private fun readData() {

        val receiverid = binding.etReceiverNoRead.text.toString()

        //Donor id not empty
        if (receiverid.isNotEmpty()) {
            lateinit var receiver: Receiver
            GlobalScope.launch {
                //receiver = appDb.dbProjectDao.findById(receiverid.toInt())
                displayData(receiver)
            }
        }
    }
}