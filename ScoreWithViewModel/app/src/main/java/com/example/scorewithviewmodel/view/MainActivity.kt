package com.example.scorewithviewmodel.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.scorewithviewmodel.R
import com.example.scorewithviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}