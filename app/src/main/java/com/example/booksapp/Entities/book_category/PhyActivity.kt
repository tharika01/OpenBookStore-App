package com.example.booksapp.Entities.book_category

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.booksapp.R

class PhyActivity:AppCompatActivity() {

    /*private lateinit var phyRecyclerView: RecyclerView
    private lateinit var phyBooks: ArrayList<Books>
    lateinit var imageID : Array<Int>
    lateinit var heading :Array<String>
    lateinit var categoryID :Array<Int>
    lateinit var num_book :Array<Int>*/
    override fun onCreate(savedInstanceState: Bundle?) {
        //WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phy)
        /*imageID = arrayOf(
            R.drawable.search_book,
            R.drawable.search_book,
            R.drawable.search_book,
            R.drawable.search_book,
            R.drawable.search_book,
            R.drawable.search_book,
            )
        heading = arrayOf(
            "heading1",
            "heading2",
            "heading3",
            "heading4",
            "heading5",
            "heading6"
        )
        categoryID = arrayOf(
            1,2,3,4,5,6
        )
        num_book = arrayOf(10, 2,1,6,4, 5)

        phyRecyclerView = findViewById(R.id.recycler_view)
        phyRecyclerView.layoutManager = LinearLayoutManager(this)
        phyRecyclerView.setHasFixedSize(true)
        phyBooks = arrayListOf<Books>()
        getUserdata()
    }
    private fun getUserdata(){
        for(i in imageID.indices){
            val book = Books(imageID[i], heading[i],  categoryID[i], noofbooks =2)
            phyBooks.add(book)
        }
        phyRecyclerView.adapter = categoryAdapter(phyBooks)*/
    }
}