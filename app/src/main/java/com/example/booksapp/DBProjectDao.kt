package com.example.booksapp.Entities

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.booksapp.Books.Books
import com.example.booksapp.Entities.Relations.*
import com.example.booksapp.Entities.Relations.Books_Donor.BookswithDonors
import com.example.booksapp.Entities.Relations.Books_Donor.DonorBooksCross
import com.example.booksapp.Entities.Relations.Books_Donor.DonorswithBooks
import com.example.booksapp.Entities.Relations.Books_Receiver.BooksWithReceivers
import com.example.booksapp.Entities.Relations.Books_Receiver.ReceiverBooksCross
import com.example.booksapp.Entities.Relations.Books_Receiver.ReceiverswithBooks
import com.example.booksapp.Entities.Relations.Donor_Receiver.DonorReceiverCross
import com.example.booksapp.Entities.Relations.Donor_Receiver.DonorwithReceiver
import com.example.booksapp.Entities.Relations.Donor_Receiver.ReceiverwithDonors
import com.example.booksapp.Entities.book_category.BookCategory
import com.example.booksapp.Entities.cart.Cart
import com.example.booksapp.Entities.donor.Donor
import com.example.booksapp.Entities.login.Login
import com.example.booksapp.receiver.Receiver
@Dao
interface DBProjectDao {
    //login dao
    @Query("INSERT INTO LOGIN(firstName, lastName, emailID, password) VALUES(:fName,:lName, :emailID, :pass)")
    fun insert(fName:String, lName: String, emailID : String, pass:String)

    //Checking if email id entered is already existing in  the db
    /*@Query("SELECT * FROM login WHERE emailID=:emailID")
    suspend fun emailexists(emailID: String)*/

    //Authorizing user login
    @Transaction
    @Query("SELECT id FROM LOGIN where emailID LIKE :emailID and password LIKE :pass")
    suspend fun authorize_user(emailID : String, pass: String) : Int


    //Insert to cart
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCart(cart: Cart)

    //Insert to books
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBooks(books: Books)

    //Insert to book category
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBookCategory(bookCategory: BookCategory)

    //Insert to donor
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDonor(donor: Donor)

    //Insert to receiver
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReceiver(receiver: Receiver)

    //Get all the books for that particular person from login table
    @Query("SELECT * FROM login WHERE EmailId = :emailID")
    fun getAll(emailID: String) : List<Login>

    //Insert to DonorReceiverCross
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDonorReceiverCross(crossRef: DonorReceiverCross)

    //Receiver with donors (m:n)
    @Transaction
    @Query("SELECT * FROM receiver_table WHERE rbook_id = :rbook_id")
    suspend fun getStudentsOfSubject(rbook_id: Int): List<ReceiverwithDonors>

    //Donor with receiver(n:m)
    @Transaction
    @Query("SELECT * FROM donor_table WHERE donorid = :donorid")
    suspend fun getDonorsOfReceivers(donorid:Int): List<DonorwithReceiver>


    //Insert to DonorBoooksCross
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDonorBooksCross(crossRef: DonorBooksCross)



    //Receiver and cart- 1:1 relationship
    @Transaction
    @Query("SELECT * FROM receiver_table WHERE rbook_id = :rbook_id")
    suspend fun getReceiverandCart(rbook_id: Int): List<ReceiverAndCart>

    //Books and Category n:1
    @Transaction
    @Query("SELECT * FROM books_table WHERE CategoryID = :categoryid")
    suspend fun getbookswithbookcategory(categoryid: Int): List<BooksWithBookCategory>

    //DonorswithBooks m:n
    @Transaction
    @Query("SELECT * FROM donor_table WHERE DBookID = :book_id")
    suspend fun getDonorswithBooks(book_id: Int): List<DonorswithBooks>

    //Books with  Donors : n:m
    @Transaction
    @Query("SELECT * FROM books_table WHERE bookid = :bookid")
    suspend fun getBooksOfDonors(bookid:Int): List<BookswithDonors>

    //Insert to ReceiverBooksCross
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReceiverBooksCross(crossRef: ReceiverBooksCross)

    //Receiver with  books (m:n)
    @Transaction
    @Query("SELECT * FROM receiver_table WHERE rbook_id = :rbook_id")
    suspend fun getReceiverwithBooks(rbook_id: Int): List<ReceiverswithBooks>

    //Books with receiver(n:m)
    @Transaction
    @Query("SELECT * FROM books_table WHERE bookid = :bookid")
    suspend fun getBooksOfReceivers(bookid:Int): List<BooksWithReceivers>

    //Retrieve data from the donor table
    @Query("SELECT DFName,DLName FROM donor_table WHERE donorid = :donorid " )
    suspend fun findById(donorid: Int) : Donor

    @Query("UPDATE donor_table SET DBook_name= :bookName, DBookID= :bookid ,photourl= :url WHERE DonorID = :donorID")
    suspend fun updateBook(bookName: String?, bookid: String, donorID: String, url: String)

    @Query("DELETE FROM DONOR_TABLE WHERE DBook_name = :bookName")
    suspend fun deleteBook(bookName: String?)

    @Query("SELECT * FROM books_table")
    fun getAllBooks() : LiveData<List<Books>>
}
