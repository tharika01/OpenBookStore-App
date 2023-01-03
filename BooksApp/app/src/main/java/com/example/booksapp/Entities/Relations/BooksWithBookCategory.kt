package com.example.booksapp.Entities.Relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.booksapp.Books.Books
import com.example.booksapp.Entities.book_category.BookCategory

class BooksWithBookCategory (
    @Embedded val bookCategory: BookCategory,
    @Relation(
        parentColumn = "categoryid",
        entityColumn="category_id"
    )
    val donors: List<Books>

)
