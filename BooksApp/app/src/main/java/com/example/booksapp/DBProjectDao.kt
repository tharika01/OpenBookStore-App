package com.example.booksapp.Entities

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
    import com.example.booksapp.receiver.Receiver
    @Dao
    interface DBProjectDao {

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

        //Insert to DonorReceiverCross
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertDonorReceiverCross(crossRef: DonorReceiverCross)

        //Insert to DonorBoooksCross
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertDonorBooksCross(crossRef: DonorBooksCross)

        //Insert to ReceiverBooksCross
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertReceiverBooksCross(crossRef: ReceiverBooksCross)

        //Receiver and cart- 1:1 relationship
        /*@Transaction
        @Query("SELECT * FROM receiver_table WHERE rbook_id = :rbook_id")
        suspend fun getReceiverandCart(rbook_id: Int): List<ReceiverAndCart>*/

        //Books and Category n:1
        /*@Transaction
        @Query("SELECT * FROM books_table WHERE categoryid = :categoryid")
        suspend fun getbookswithbookcategory(categoryid: Int): List<BooksWithBookCategory>*/

        //Receiver with donors (m:n)
        @Transaction
        @Query("SELECT * FROM receiver_table WHERE rbook_id = :rbook_id")
        suspend fun getStudentsOfSubject(rbook_id: Int): List<ReceiverwithDonors>

        //Donor with receiver(n:m)

        @Transaction
        @Query("SELECT * FROM donor_table WHERE donorid = :donorid")
        suspend fun getDonorsOfReceivers(donorid:Int): List<DonorwithReceiver>

        //DonorswithBooks m:n
        /*@Transaction
        @Query("SELECT * FROM donor_table WHERE book_id = :book_id")
        suspend fun getDonorswithBooks(book_id: Int): List<DonorswithBooks>*/

        //Books with  Donors : n:m
        @Transaction
        @Query("SELECT * FROM books_table WHERE bookid = :bookid")
        suspend fun getBooksOfDonors(bookid:Int): List<BookswithDonors>

        //Receiver with  books (m:n)
        @Transaction
        @Query("SELECT * FROM receiver_table WHERE rbook_id = :rbook_id")
        suspend fun getReceiverwithBooks(rbook_id: Int): List<ReceiverswithBooks>

        //Books with receiver(n:m)
        @Transaction
        @Query("SELECT * FROM books_table WHERE bookid = :bookid")
        suspend fun getBooksOfReceivers(bookid:Int): List<BooksWithReceivers>




    }
