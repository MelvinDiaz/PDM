package com.example.booktracker.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.booktracker.data.Book
import com.example.booktracker.databinding.CardBookBinding

class BooksViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = CardBookBinding.bind(view)

    fun bind(book: Book) {
        binding.bookTitle.text = book.title
        binding.bookIsbn.text = book.isbn
        //TODO add authors and publisher correctly
        binding.bookAuthor.text = book.authors[0].firstName
        //binding.bookPublisher.text = book.publisher.toString()
    }
}