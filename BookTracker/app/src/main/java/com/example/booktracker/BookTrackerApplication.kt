package com.example.booktracker

import android.app.Application
import com.example.booktracker.data.books
import com.example.booktracker.repositories.BookRepository

class BookTrackerApplication: Application() {
    val bookRepository: BookRepository by lazy {
        BookRepository(books)
    }

}