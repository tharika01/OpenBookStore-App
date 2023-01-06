package com.example.booksapp.Entities.login


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.booksapp.BooksDatabase
import com.example.booksapp.Entities.donor.Donor
import com.example.booksapp.databinding.ActivitySignUpBinding
import com.example.booksapp.receiver.Receiver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var BookDb : BooksDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        BookDb = BooksDatabase.getDatabase(this)

        binding.signupBtn.setOnClickListener{
            writeData()
        }

    }
    private fun writeData(){
        val firstName = binding.editTextFName.text.toString()
        val lastName = binding.editTextLName.text.toString()
        val email = binding.editTextEmailAddress.text.toString()
        val password = binding.editTextPassword.text.toString()
        val address = binding.Address.text.toString()
        val mob_num = binding.phoneNumber.text.toString()

        if(firstName.isNotEmpty() && lastName.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && address.isNotEmpty() && mob_num.isNotEmpty()){
            GlobalScope.launch(Dispatchers.IO){
                //adding user details to donor table, receiver and login table
                val donor = Donor(
                    null, firstName, lastName, mob_num, address, email, null, null
                )
                val receiver = Receiver(
                    null, firstName, lastName, mob_num, address, email, null,null
                )
                BookDb.dbProjectDao.insert(firstName, lastName,email, password)
                BookDb.dbProjectDao.insertDonor(donor)
                BookDb.dbProjectDao.insertReceiver(receiver)
            }

            binding.editTextFName.text.clear()
            binding.editTextLName.text.clear()
            binding.editTextEmailAddress.text.clear()
            binding.editTextPassword.text.clear()
            binding.Address.text.clear()
            binding.phoneNumber.text.clear()

            Toast.makeText(this, "Successfully Written", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this, "Please enter text", Toast.LENGTH_SHORT).show()
        }
    }

}
