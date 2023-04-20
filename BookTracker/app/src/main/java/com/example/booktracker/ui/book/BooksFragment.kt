package com.example.booktracker.ui.book

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.booktracker.R
import com.example.booktracker.data.Book
import com.example.booktracker.data.books
import com.example.booktracker.databinding.FragmentBooksBinding
import com.example.booktracker.ui.BooksAdapter


class BooksFragment : Fragment() {
    private lateinit var binding: FragmentBooksBinding

    private lateinit var adapter: BooksAdapter
    private val viewModel: BooksViewModel by viewModels {
        BooksViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_books, container, false)
        binding.recyclerViewBooks.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewBooks.adapter = BooksAdapter(books)
        return binding.root
    }

}