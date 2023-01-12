package com.example.booksapp

import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.booksapp.Books.Books
import com.example.booksapp.Entities.Relations.Books_Donor.DonorBooksCross
import com.example.booksapp.Entities.Relations.Books_Receiver.ReceiverBooksCross
import com.example.booksapp.Entities.Relations.Donor_Receiver.DonorReceiverCross
import com.example.booksapp.Entities.book_category.BookCategory
import com.example.booksapp.Entities.cart.Cart
import com.example.booksapp.Entities.donor.Donor
import com.example.booksapp.databinding.ActivityHomeBinding
import com.example.booksapp.Entities.donor.DonorActivity
import com.example.booksapp.receiver.Receiver
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.bottomNavigationView

        val navController = findNavController(R.id.nav_host_fragment_activity_home)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_profile, R.id.navigation_cart
            )
        )
        //setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        binding.fabDonate.setOnClickListener{
            val intent = Intent(this@HomeActivity, DonorActivity::class.java)
            startActivity(intent)
        }

        //on click listener added to navigate to donor page
        binding.fabDonate.setOnClickListener{
            var intent = Intent(this@HomeActivity, DonorActivity::class.java)
            startActivity(intent)
        }

        val dao = BooksDatabase.getDatabase(this@HomeActivity).dbProjectDao
        //Inserting values
        val donors= listOf(
            Donor(1,"Jerry","Thomson","1234567899","Bangalore","Jerry@gmail.com","HCVerma","101","https://via.placeholder.com/200"),
            Donor(2,"Tom","Little","1234567898","Mangalore","Tom@gmail.com","Databasebook","102","https://via.placeholder.com/200"),
            Donor(3,"Paw","Twinky","9934567899","Dubai","Paw@gmail.com","Oliver-chemistry","103","https://via.placeholder.com/200"),
            Donor(4,"Pinky","Winky","8034567899","Delhi","Pinky@gmail.com","Allen-masterbook","104","https://via.placeholder.com/200"),
            Donor(5,"Laala","Dipsy","7834567899","Hyderabad","laala@gmail.com","RichDadPoorDad","105","https://via.placeholder.com/200"),
            Donor(5,"Radha","Roopesh","6834567899","Kochi","Radha@gmail.com","HCVerma","101","https://via.placeholder.com/200"),
            Donor(5,"Karthik","S","3834567899","Sullia","Karthik@gmail.com","Oliver-chemistry","103","https://via.placeholder.com/200")
        )
        val receivers=listOf(
            Receiver(5,"Laala","Dipsy","7834567899","Hyderabad","laala@gmail.com","Databasebook","102"),
            Receiver(6,"Tommy","Thomson","1234577899","Mangalore","Tommy@gmail.com","AutomateTheBoringStuff","106"),
            Receiver(7,"Ramya","krishna","8234567899","Bangalore","Ramya@gmail.com","HCVerma","101"),
            Receiver(1,"Jerry","Thomson","1234567899","Bangalore","Jerry@gmail.com","NCERT_maths","107"),
            Receiver(8,"Berklin","Tommy","9999997898","Japan","Berklin@gmail.com","Allen-masterbook","104")
        )
        val books= arrayListOf<Books>(
            Books(101,"HCVerma Part 1",111,2,"https://m.media-amazon.com/images/I/51MUOHEBCxL._SX388_BO1,204,203,200_.jpg"),
            Books(102,"HCVerma Part 2",111,1,"https://m.media-amazon.com/images/I/51WKljRVSyL._SX385_BO1,204,203,200_.jpg"),
            Books(103,"Chemistry NCERT(PART2)",112,2,"https://m.media-amazon.com/images/I/41DVb8jFa-L._SX387_BO1,204,203,200_.jpg"),
            Books(104,"Chemistry NCERT(PART1)",112,1,"https://m.media-amazon.com/images/I/41ZEuWtmqsL._SY264_BO1,204,203,200_QL40_FMwebp_.jpg"),
            Books(105,"Biology NCERT(CLASS 11)",113,1,"https://m.media-amazon.com/images/I/61I5v1h7j1L._SX198_BO1,204,203,200_QL40_FMwebp_.jpg"),
            Books(106,"Biology NCERT(CLASS 12)",113,0,"https://m.media-amazon.com/images/I/51+PUz96KiL._SX258_BO1,204,203,200_.jpg"),
            Books(107,"Mathematics NCERT",114,0,"https://m.media-amazon.com/images/I/51F2g74f2US._SY326_BO1,204,203,200_.jpg"),
            Books(108,"Mathematics RS Aggarwal",114,1,"https://m.media-amazon.com/images/I/41wNWkEhvRL._SX319_BO1,204,203,200_.jpg")
        )

        val BookCategory=listOf(
            BookCategory(111,2,"PUC-Physics"),
            BookCategory(112,1,"DBMS"),
            BookCategory(113,1,"PUC-Chemistry"),
            BookCategory(115,1,"NonAcademics"),
            BookCategory(116,0,"Python"),
            BookCategory(117,0,"PUC-Maths")

        )
        val cart=listOf(
            Cart(101,1,"HCVerma",1),
            Cart(102,1,"Databasebook",5)
        )
        val donorbooksrelation=listOf(
            DonorBooksCross(101,101),
            DonorBooksCross(102,102),
            DonorBooksCross(103,103),
            DonorBooksCross(104,104),
            DonorBooksCross(105,105)

        )
        val receiverbooksrelation=listOf(
            ReceiverBooksCross(101,101),
            ReceiverBooksCross(102,102),
            ReceiverBooksCross(104,104),
            ReceiverBooksCross(106,106),
            ReceiverBooksCross(107,107)
        )
        val donorreceiverrelation=listOf(
            DonorReceiverCross(101,1),
            DonorReceiverCross(102,2),
            DonorReceiverCross(104,4)
        )
        lifecycleScope.launch {
            donors.forEach { dao.insertDonor(it)}
            receivers.forEach { dao.insertReceiver(it) }
            books.forEach { dao.insertBooksAll(books) }
            cart.forEach { dao.insertCart(it) }
            BookCategory.forEach {dao.insertBookCategory(it)}
            donorbooksrelation.forEach {dao.insertDonorBooksCross(it)}
            donorreceiverrelation.forEach { dao.insertDonorReceiverCross(it)}
            receiverbooksrelation.forEach { dao.insertReceiverBooksCross(it) }
        }

        //rv = findViewById(R.id.recycler_view)
        //var bookList = ArrayList<Books>()
        //bookList = dao.getAllBooks()
        /*binding.recyclerview.apply{
            layoutManager = LinearLayoutManager(this@HomeActivity)
            adapter = BooksAdapter(books)
        }*/
    }
}