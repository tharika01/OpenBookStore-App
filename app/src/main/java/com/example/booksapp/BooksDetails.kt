package com.example.booksapp

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.squareup.picasso.Picasso

class BooksDetails : AppCompatActivity() {

    //private lateinit var binding: ActivityBookDetailsBinding
    private lateinit var b : TextView
    private lateinit var imgUrl: ImageView
    private lateinit var avail : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)

        val title = intent.getStringExtra("title")
        val url = intent.getStringExtra("url")
        b = findViewById(R.id.book_name)
        b.text = title
        imgUrl = findViewById(R.id.photo)
        Picasso.get().load(url).into(imgUrl)


        avail = findViewById(R.id.availability)
        avail.setOnClickListener {
            AlertDialog.Builder(this)
                .setMessage("$title is in stock")
                .setPositiveButton("OK") { dialog, which ->

                }
                .create()
                .show()
        }
    }


}