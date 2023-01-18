package com.example.booksapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.booksapp.Books.Books
import com.squareup.picasso.Picasso

class BooksAdapter(private val books: ArrayList<Books>) :RecyclerView.Adapter<BooksAdapter.ViewHolder>(){
    override fun onBindViewHolder(holder: BooksAdapter.ViewHolder, position: Int){
        holder.title.text = books[position].bname
        Picasso.get().load(books[position].photourl).into(holder.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_books_row, parent, false)
        //opening the respective activity when one  of the grid is clicked
        val holder = ViewHolder(view)
        view.setOnClickListener {
            val intent = Intent(parent.context, BooksDetails:: class.java)
            intent.putExtra("title", books[holder.adapterPosition].bname)
            intent.putExtra("url", books[holder.adapterPosition].photourl)
            parent.context.startActivity(intent)
        }
        return holder
    }
    override fun getItemCount(): Int {
        return books.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.photo)
        val title: TextView = itemView.findViewById(R.id.title)
    }
}