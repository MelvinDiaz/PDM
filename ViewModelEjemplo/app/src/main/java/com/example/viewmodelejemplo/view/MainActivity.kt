package com.example.viewmodelejemplo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.viewmodelejemplo.databinding.ActivityMainBinding
import com.example.viewmodelejemplo.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.quoteModel.observe(this, Observer {
            binding.textViewQuote.text = it.quote
            binding.textViewAutor.text = it.author
        })

        binding.viewContainaer.setOnClickListener {
            quoteViewModel.randomQuote()
        }
    }
}