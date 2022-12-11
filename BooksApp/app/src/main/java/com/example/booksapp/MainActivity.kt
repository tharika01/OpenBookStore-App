package com.example.booksapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.view.View
import android.widget.Button
import android.widget.EditText
//import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    
    //Declaring the variables 
    lateinit var signUP : Button
    lateinit var loginBtn : Button
    lateinit var emailID : EditText
    lateinit var passID : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //getting the id's of the views 
        signUP = findViewById(R.id.signUpButton)
        loginBtn = findViewById(R.id.loginButton)
        emailID = findViewById(R.id.editTextEmailAddress)
        passID = findViewById(R.id.editTextPassword)

        //open signup page when sign up button is clicked
        signUP.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        // creating instance of SQLite db
        val helper = DbHelper(applicationContext)
        val db = helper.readableDatabase  

        //Login authorization
        loginBtn.setOnClickListener {
            //getting email and password entered by the user
            var email = emailID.text.toString()
            var password = passID.text.toString()
            //query to check if the user details exists in LOGIN table
            val rs = db.rawQuery("SELECT * FROM LOGIN where EMAIL =? AND PASSWORD =?", arrayOf(email, password)) //2nd arg is for WHERE clause
            if(rs.moveToNext()) //Successful login then open the home page
            {
                Toast.makeText(applicationContext, "Login Successful", Toast.LENGTH_LONG).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
            else//invalid data then display toast msg, don't do anything
            {
                Toast.makeText(applicationContext, "Invalid", Toast.LENGTH_LONG).show()
            }
        }
    }
}
