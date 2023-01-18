package com.example.booksapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.booksapp.entity.login.SignUpActivity
import com.example.booksapp.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var BookDb : BooksDatabase

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //init db
        BookDb = BooksDatabase.getDatabase(this)

        //open signup page when sign up button is clicked
        binding.signUpButton.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        binding.loginButton.setOnClickListener{
            val res = authorizeLogin()
            //Toast.makeText(this@MainActivity, "Login Successful", Toast.LENGTH_LONG).show()
        }
        binding.backBtn.setOnClickListener {
            val intent = Intent(this, LandingActivity::class.java)
            startActivity(intent)
        }
    }

    private fun authorizeLogin() {
        val email = binding.editTextEmailAddress.text.toString()
        val password = binding.editTextPassword.text.toString()
        var login: Int

        println("Entered login")
        if(email.isNotEmpty() && password.isNotEmpty()){
            GlobalScope.launch(Dispatchers.IO){
                login = BookDb.dbProjectDao.authorize_user(email, password)
                //println(login.emailID.equals(email))
                if(login != null){
                    val intent = Intent(this@MainActivity, HomeActivity::class.java)
                    intent.putExtra("emailID", email)
                    startActivity(intent)
                }
                else//invalid data then display toast msg, don't do anything
                {
                    Toast.makeText(this@MainActivity, "Invalid login details", Toast.LENGTH_LONG).show()
                    val intent = Intent(this@MainActivity, SignUpActivity::class.java)
                    startActivity(intent)
                }
            }
        }
        else
        {
            Toast.makeText(this@MainActivity, "Please enter some data", Toast.LENGTH_LONG).show()
        }
    }
}


