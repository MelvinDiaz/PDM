package com.example.booktracker.repositories

import com.example.booktracker.data.Author
import com.example.booktracker.data.Book

class BookRepository(private val books: List<Book>) {
    fun getBooks() = books
    fun getBooksByAuthor(author: Author) = books.filter { book -> book.authors.contains(author) }
}