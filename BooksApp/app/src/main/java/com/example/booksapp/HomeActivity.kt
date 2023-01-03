package com.example.booksapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.booksapp.Books.Books
import com.example.booksapp.Entities.Relations.Books_Donor.DonorBooksCross
import com.example.booksapp.Entities.Relations.Books_Receiver.ReceiverBooksCross
import com.example.booksapp.Entities.Relations.Donor_Receiver.DonorReceiverCross
import com.example.booksapp.Entities.book_category.BookCategory
import com.example.booksapp.Entities.cart.Cart
import com.example.booksapp.Entities.cart.CartActivity
import com.example.booksapp.Entities.donor.Donor
import com.example.booksapp.databinding.ActivityHomeBinding
import com.example.booksapp.Entities.donor.DonorActivity
import com.example.booksapp.receiver.Receiver

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_home)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
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

        val dao = BooksDatabase.getDatabase(this).DBProjectDao()
        //Inserting values
        val donors= listOf(
            Donor(1,"Jerry","Thomson","1234567899","Bangalore","Jerry@gmail.com","HCVerma","101"),
            Donor(2,"Tom","Little","1234567898","Mangalore","Tom@gmail.com","Databasebook","102"),
            Donor(3,"Paw","Twinky","9934567899","Dubai","Paw@gmail.com","Oliver-chemistry","103"),
            Donor(4,"Pinky","Winky","8034567899","Delhi","Pinky@gmail.com","Allen-masterbook","104"),
            Donor(5,"Laala","Dipsy","7834567899","Hyderabad","laala@gmail.com","RichDadPoorDad","105"),
            Donor(5,"Radha","Roopesh","6834567899","Kochi","Radha@gmail.com","HCVerma","101"),
            Donor(5,"Karthik","S","3834567899","Sullia","Karthik@gmail.com","Oliver-chemistry","103")



        )
        val receivers=listOf(
            Receiver(5,"Laala","Dipsy","7834567899","Hyderabad","laala@gmail.com","Databasebook","102"),
            Receiver(6,"Tommy","Thomson","1234577899","Mangalore","Tommy@gmail.com","AutomateTheBoringStuff","106"),
            Receiver(7,"Ramya","krishna","8234567899","Bangalore","Ramya@gmail.com","HCVerma","101"),
            Receiver(1,"Jerry","Thomson","1234567899","Bangalore","Jerry@gmail.com","NCERT_maths","107"),
            Receiver(8,"Berklin","Tommy","9999997898","Japan","Berklin@gmail.com","Allen-masterbook","104")
        )
        val books=listOf(
            Books(101,"HCVerma",111,2),
            Books(102,"Databasebook",112,1),
            Books(103,"Oliver-chemistry",113,2),
            Books(104,"Allen-masterbook",111,1),
            Books(105,"RichDadPoorDad",115,1),
            Books(106,"AutomateTheBoringStuff",116,0),
            Books(107,"NCERT_maths",117,0)
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
            Cart(101,1,"HCVerma"),
            Cart(102,1,"Databasebook")
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
            DonorReceiverCross(101,1,7),
            DonorReceiverCross(102,2,5),
            DonorReceiverCross(104,4,8)
        )
    }

    //Adding cart to the action bar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_menu, menu)
        return true
    }

    //Added on click listener for cart
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.cart->{
                //Toast.makeText(this@HomeActivity, "Going to cart". Toast.LENGTH_LONG).show()
                val intent = Intent(this@HomeActivity, CartActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }

    }
}