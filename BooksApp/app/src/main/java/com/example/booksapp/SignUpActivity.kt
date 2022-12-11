package com.example.booksapp

//import android.content.ContentValues
import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

//import android.widget.Button
//import android.widget.TextView
//import android.widget.Toast

class SignUpActivity : AppCompatActivity() {

    lateinit var fnameID: EditText
    lateinit var lnameID: EditText
    lateinit var emailID: EditText
    lateinit var passID: EditText
    lateinit var signupbtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        //getting the variables ID
        fnameID = findViewById(R.id.editTextFName)
        lnameID = findViewById(R.id.editTextLName)
        emailID = findViewById(R.id.editTextEmailAddress)
        passID = findViewById(R.id.editTextPassword)
        signupbtn = findViewById(R.id.signup)

        var helper = DbHelper(applicationContext)
        var db = helper.readableDatabase
        var rs  = db.rawQuery("SELECT * FROM LOGIN", null);


        signupbtn.setOnClickListener{
            var cv = ContentValues()
            cv.put("FNAME",fnameID.text.toString())
            cv.put("LNAME",lnameID.text.toString())
            cv.put("EMAIL",emailID.text.toString())
            cv.put("PASSWORD",passID.text.toString())
            db.insert("LOGIN", null, cv)
            rs.requery()

            Toast.makeText(applicationContext, "Inserted your login details", Toast.LENGTH_LONG).show()

            fnameID.setText("")
            lnameID.setText("")
            emailID.setText("")
            passID.setText("")
            fnameID.requestFocus()

        }
    }
}