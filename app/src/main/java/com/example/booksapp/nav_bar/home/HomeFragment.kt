package com.example.booksapp.nav_bar.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.booksapp.Books.Books
import com.example.booksapp.BooksAdapter
import com.example.booksapp.BooksDatabase
import com.example.booksapp.databinding.FragmentHomeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var em : TextView

    private lateinit var b : TextView
    private lateinit var avail : Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //val dao = BooksDatabase.getDatabase(this).dbProjectDao
        //val intent : Inent
        //val title = parseIntent().getStringExtra("title")

        /*fun Intent.getData(key: String): String {
            return extras?.getString(key) ?: "intent is null"
        }
        val title = intent.getData("title")

        b = binding.bookName
        b.text = title*/

       /* avail = binding.availability
        avail.setOnClickListener {
            AlertDialog.Builder(activity)
                .setMessage("$title is in stock")
                .setPositiveButton("OK") { dialog, which ->

                }
                .create()
                .show()
        }*/

        val books= arrayListOf<Books>(
            Books(101,"HCVerma",111,2,"https://5.imimg.com/data5/ANDROID/Default/2021/5/TB/KF/FI/64081808/1621056740586-jpg-500x500.jpg"),
            Books(102,"Databasebook",112,1,"https://via.placeholder.com/200"),
            Books(103,"Oliver-chemistry",113,2,"https://via.placeholder.com/200"),
            Books(104,"Allen-masterbook",111,1,"https://via.placeholder.com/200"),
            Books(105,"RichDadPoorDad",115,1,"https://via.placeholder.com/200"),
            Books(106,"AutomateTheBoringStuff",116,0,"https://via.placeholder.com/200"),
            Books(107,"NCERT_maths",117,0,"https://via.placeholder.com/200"),
            Books(108,"NCERT_Physics",111,1,"https://via.placeholder.com/200")
        )

        /*val bookList : ArrayList<Books> = ArrayList()
        CoroutineScope(Dispatchers.IO).launch {

            bookList.addAll(getAllBooks())
        }*/

        binding.recyclerview.apply{
            layoutManager = LinearLayoutManager(context.applicationContext)
            adapter = BooksAdapter(books)
        }
        return root
    }

    /*private suspend fun getAllBooks() : ArrayList<Books>{
        val db = BooksDatabase.getDatabase(requireContext())
        return db.dbProjectDao.getAllBooks()
    }*/

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}