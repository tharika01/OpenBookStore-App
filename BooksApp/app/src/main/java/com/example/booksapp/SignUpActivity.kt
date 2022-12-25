package com.example.booksapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.booksapp.databinding.ActivitySignUpBinding
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

        if(firstName.isNotEmpty() && lastName.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()){
            GlobalScope.launch(Dispatchers.IO){
                BookDb.LoginDao().insert(firstName, lastName,email, password)
            }

            binding.editTextFName.text.clear()
            binding.editTextLName.text.clear()
            binding.editTextEmailAddress.text.clear()
            binding.editTextPassword.text.clear()
            Toast.makeText(this, "Successfully Written", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this, "Please enter text", Toast.LENGTH_SHORT).show()
        }
    }

}
