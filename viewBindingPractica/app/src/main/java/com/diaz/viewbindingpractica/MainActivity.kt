package com.diaz.viewbindingpractica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.diaz.viewbindingpractica.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        updateText("Hola mundo")
    }

    private fun updateText(text:String) {
        binding.textViewTexto.text = text
    }
}