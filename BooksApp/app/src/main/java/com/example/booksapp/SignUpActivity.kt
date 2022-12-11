package com.example.booksapp

//import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.widget.Button
//import android.widget.TextView
//import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        /*var helper = DbHelper(applicationContext)
        var db = helper.readableDatabase
        var rs  = db.rawQuery("SELECT * FROM SIGNUP", null);

        if(rs.moveToNext())
        {
            Toast.makeText(applicationContext, rs.getString(1), Toast.LENGTH_LONG).show()
        }

        val login = findViewById<Button>(R.id.loginButton)
        val fname = findViewById<TextView>(R.id.editTextFName)
        val name = findViewById<TextView>(R.id.editTextLName)
        val email = findViewById<TextView>(R.id.editTextEmailAddress)
        val password = findViewById<TextView>(R.id.editTextPassword)
        
        login.setOnClickListener{
            var cv = ContentValues()
            cv.put("FNAME",fname.text.toString())
            cv.put("NAME",name.text.toString())
            cv.put("EMAIL",email.text.toString())
            cv.put("PASSWORD",password.text.toString())

            //fname.text = ""
            name.text = ""
            email.text = ""
            password.text = ""
        }*/
    }
}