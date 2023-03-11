package com.example.ejercicioclase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        bindViews()

    }
        private fun bindViews() {
            val btn = findViewById<Button>(R.id.mySendButton)
            val message = findViewById<EditText>(R.id.myMessage)
            //Show second activity
            btn.setOnClickListener {

                val intent = Intent(this, SecondActivity::class.java).apply {
                    putExtra("message", message.text.toString())
                }
1
                startActivity(intent)
            }


        }
    }