package com.example.scorewithviewmodel.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.scorewithviewmodel.R
import com.example.scorewithviewmodel.databinding.ActivityMainBinding
import com.example.scorewithviewmodel.viewmodel.NumberViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val numberViewModel: NumberViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}