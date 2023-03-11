package com.example.ejercicioclase

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val messageTextView = findViewById<TextView>(R.id.messageTextView)
        val message = intent.getStringExtra("message")
        val existingText = messageTextView.text.toString()
        val newText = existingText + " " + message
        messageTextView.text = newText

    }
}