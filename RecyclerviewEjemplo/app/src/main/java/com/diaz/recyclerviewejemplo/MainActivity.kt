package com.diaz.recyclerviewejemplo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.diaz.recyclerviewejemplo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var listaPersonaje:MutableList<Personaje> = mutableListOf()
    private lateinit var recyclerPersonaje:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listaPersonaje.add(Personaje("Goku"))
        listaPersonaje.add(Personaje("Vegeta"))
        listaPersonaje.add(Personaje("Gohan"))
        listaPersonaje.add(Personaje("Piccolo"))
        listaPersonaje.add(Personaje("Krillin"))

        estavlecerAdaptador()
    }

    private fun estavlecerAdaptador(){
        recyclerPersonaje = binding.recyclerPersonaje
        recyclerPersonaje.layoutManager = LinearLayoutManager(this)
        recyclerPersonaje.adapter = RecyclerPersonaje(this, listaPersonaje)
    }
}