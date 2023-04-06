package com.diaz.pokemon.ui.pokeinfo

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.diaz.pokemon.R

class PokeInfoActivity: AppCompatActivity() {
    lateinit var viewModel: PokeInfoViewModel

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(PokeInfoViewModel::class.java)

        initUI()
    }

    private fun initUI() {
        val id = intent.extras?.get("id") as Int
    }
}