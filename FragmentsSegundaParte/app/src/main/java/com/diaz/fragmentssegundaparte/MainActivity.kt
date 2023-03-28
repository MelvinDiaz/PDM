package com.diaz.fragmentssegundaparte

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonNews = findViewById<Button>(R.id.button_news)
        val buttonScience = findViewById<Button>(R.id.button_science)
        val buttonSports = findViewById<Button>(R.id.button_sports)


        buttonNews.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, NewFragmen()).commit()
        }


        buttonScience.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, ScienceFragment()).commit()
        }

        buttonSports.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, sportsFragmentt()).commit()
        }
    }
}