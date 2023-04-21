package com.example.booktracker.ui

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.booktracker.data.Book
import com.example.booktracker.databinding.CardBookBinding

class BooksViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = CardBookBinding.bind(view)

    fun bind(book: Book) {
        binding.bookTitle.text = book.title
        binding.bookIsbn.text = book.isbn
        binding.bookAuthor.text = book.authors[0].firstName
        binding.bookPublisher.text = book.publisher.name
    }

    //**
    // onBookClicked shows a toast message when a book is clicked
    // can detect where the card was clicked
    // **
    fun onBookClicked(book: Book) {
        binding.root.setOnClickListener {
            Toast.makeText(binding.root.context, book.title, Toast.LENGTH_SHORT).show()
        }
    }
}