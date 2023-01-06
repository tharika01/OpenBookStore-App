package com.example.booksapp.Entities.Relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.booksapp.Books.Books
import com.example.booksapp.Entities.book_category.BookCategory
class BooksWithBookCategory (
    /*@Embedded val bookCategory: BookCategory,
    @Relation(
        parentColumn = "category_id",
        entityColumn="categoryid"
    )
    val book : List<Books>*/
    @Embedded val  books: Books,
    @Relation(
        parentColumn = "categoryid",
        entityColumn = "category_id"
    )
    val bookCategory : List<BookCategory>
)