package com.example.booksapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.view.View
import android.widget.Button
//import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signUP = findViewById<Button>(R.id.signUpButton)
        signUP.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        val helper = DbHelper(applicationContext)
        val db = helper.readableDatabase  //returns instance of sqlite db
        val rs = db.rawQuery("SELECT * FROM LOGIN", null) //2nd arg is for WHERE clause

        if(rs.moveToNext())  //printing toast if data is inserted into db
        {
            Toast.makeText(applicationContext, rs.getString(1), Toast.LENGTH_LONG).show()
        }
        rs.close()
    }
}