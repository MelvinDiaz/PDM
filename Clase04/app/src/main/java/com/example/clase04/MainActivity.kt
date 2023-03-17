package com.example.clase04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager

        val fragment = DataFragment.newInstance("Melvin", "Diaz")
        fragmentManager.beginTransaction()
            .replace(R.id.counter_dinamy_fragment, CounterFragment())
            .commit()

    }
}