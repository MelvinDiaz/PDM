package com.example.booktracker.ui.book

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.booktracker.databinding.FragmentBooksBinding


class BooksFragment : Fragment() {
    private lateinit var binding: FragmentBooksBinding
    private val viewModel: BooksViewModel by viewModels {
        BooksViewModel.Factory
    }
}