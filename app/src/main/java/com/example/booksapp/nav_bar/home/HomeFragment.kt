package com.example.booksapp.nav_bar.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.booksapp.entity.book_category.CategoriesAdapter
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
    private lateinit var recycler_view: RecyclerView
    private lateinit var adapter: BooksAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root



        /*val books= arrayListOf<Books>(
            Books(101,"HCVerma",111,2,"https://5.imimg.com/data5/ANDROID/Default/2021/5/TB/KF/FI/64081808/1621056740586-jpg-500x500.jpg"),
            Books(102,"Databasebook",112,1,"https://via.placeholder.com/200"),
            Books(103,"Oliver-chemistry",113,2,"https://via.placeholder.com/200"),
            Books(104,"Allen-masterbook",111,1,"https://via.placeholder.com/200"),
            Books(105,"RichDadPoorDad",115,1,"https://via.placeholder.com/200"),
            Books(106,"AutomateTheBoringStuff",116,0,"https://via.placeholder.com/200"),
            Books(107,"NCERT_maths",117,0,"https://via.placeholder.com/200"),
            Books(108,"NCERT_Physics",111,1,"https://via.placeholder.com/200")
        )*/

        val bookList : ArrayList<Books> = ArrayList()
        //bookList.clear()
        //val inviteAdapter = InviteAdapter(bookList)
        CoroutineScope(Dispatchers.IO).launch {
            bookList.clear()
            bookList.addAll(getAllBooks())

        }

        /*binding.recyclerview.apply{
            layoutManager = LinearLayoutManager(context.applicationContext, HorizontalScrollView)
            adapter = BooksAdapter(books)
        }*/
        recycler_view = binding.recyclerview
        adapter = BooksAdapter(bookList)
        recycler_view.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL, false)
        recycler_view.adapter = adapter

        //Top scroll items
        val categories = listOf(
            "Python",
            "Physics",
            "DBMS",
            "Chemistry",
            "Comics",
            "Python",
            "Physics",
            "Biology",
            "Unix Programming",
            "Datastructures"
        )

        //SCrolling option for top categories on home page
        binding.categoriesRecyclerView.apply {
            layoutManager = androidx.recyclerview.widget.LinearLayoutManager(
                activity,
                androidx.recyclerview.widget.RecyclerView.HORIZONTAL,
                false
            )
            adapter = CategoriesAdapter(categories)
        }
        return root
    }

    private suspend fun getAllBooks() : List<Books> {
        val db = BooksDatabase.getDatabase(requireContext())
        return db.dbProjectDao.getAllBooks()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}