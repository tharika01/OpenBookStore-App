package com.example.booksapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.booksapp.entity.login.SignUpActivity
import com.example.booksapp.databinding.ActivtyLandingBinding

class LandingActivity : AppCompatActivity() {

    private lateinit var binding: ActivtyLandingBinding
    /*private lateinit var BookDb : BooksDatabase
     */

    override fun onCreate(savedInstanceState: Bundle?) {

       /* val action = supportActionBar
        action!!.setTitle("Login")*/

        super.onCreate(savedInstanceState)
        binding = ActivtyLandingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //init db
        //BookDb = BooksDatabase.getDatabase(this)

        //open signup page when sign up button is clicked
        binding.login.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.registerbtn.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    /*private fun authorizeLogin() {
        val email = binding.editTextEmailAddress.text.toString()
        val password = binding.editTextPassword.text.toString()
        var login: Int
        println("Entered login")
        if(email.isNotEmpty() && password.isNotEmpty()){
            GlobalScope.launch(Dispatchers.IO){
                login = BookDb.dbProjectDao.authorize_user(email, password)
                //println(login.emailID.equals(email))
                if(login != null){
                    val intent = Intent(this@LandingActivity, HomeActivity::class.java)
                    startActivity(intent)
                }
                else//invalid data then display toast msg, don't do anything
                {
                    //Toast.makeText(this@MainActivity, "Invalid login details", Toast.LENGTH_LONG).show()
                    val intent = Intent(this@LandingActivity, SignUpActivity::class.java)
                    startActivity(intent)
                }
            }
        }
        else
        {
            Toast.makeText(this@LandingActivity, "Please enter some data", Toast.LENGTH_LONG).show()
        }
    }*/
}


