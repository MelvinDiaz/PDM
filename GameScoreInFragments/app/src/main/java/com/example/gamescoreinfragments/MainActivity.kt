package com.example.gamescoreinfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager

        val fragmentContainerView = findViewById<FrameLayout>(R.id.main_fragment_container)

        fragmentManager.beginTransaction().add(fragmentContainerView.id, MainFragment()).commit()
    }
}