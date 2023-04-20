package com.example.booktracker.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.booktracker.data.Book
import com.example.booktracker.databinding.CardBookBinding

class BooksAdapter(private var bookList: List<Book>) : RecyclerView.Adapter<BooksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = CardBookBinding.inflate(inflater, parent, false)
        return BooksViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    interface BooksAdapterDataProvider {
        fun getBookList(): List<Book>
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        val item = bookList[position]
        holder.bind(item)
    }
}