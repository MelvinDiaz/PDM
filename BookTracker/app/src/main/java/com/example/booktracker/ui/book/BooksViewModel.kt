package com.example.booktracker.ui.book

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.booktracker.BookTrackerApplication
import com.example.booktracker.repositories.BookRepository

class BooksViewModel(private val repository: BookRepository) : ViewModel() {

    fun getBooks() = repository.getBooks()

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as BookTrackerApplication
                BooksViewModel(app.bookRepository)
            }
        }
    }

}