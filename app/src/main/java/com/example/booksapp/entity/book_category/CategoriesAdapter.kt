package com.example.booksapp.entity.book_category

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.booksapp.CategoriseActivity
import com.example.booksapp.R


class CategoriesAdapter(private val categories: List<String>) : RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {
    //var Onitemclick: ((Books)->Unit)=null
    override fun onBindViewHolder(holder: CategoriesAdapter.ViewHolder, position: Int) {
        holder.categoryName.text = categories[position]
        //Adding on click listener
        /* holder.itemView.setOnClickListener{
             Onitemclick?.invoke(Books)

         }*/
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_category_row, parent, false)
        val holder = ViewHolder(view)
        view.setOnClickListener {
            val intent= Intent(parent.context , CategoriseActivity::class.java)
            //intent.putExtra("title", categories[holder.adapterPosition].genre)
            parent.context.startActivity(intent)
        }
        return holder
    }


    override fun getItemCount() = categories.size

    //Categories place holder


    class ViewHolder(view: View) :RecyclerView.ViewHolder(view)  {
        var categoryName: TextView = view.findViewById(R.id.categoryName)
    }
}
