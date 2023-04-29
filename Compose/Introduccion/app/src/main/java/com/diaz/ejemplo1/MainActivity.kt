package com.diaz.ejemplo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.diaz.ejemplo1.ui.theme.Ejemplo1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ejemplo1Theme {
                HelloApp()
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HelloApp() {
    Ejemplo1Theme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Greeting("Querido usuario")
        }
    }
}


@Composable()
fun exampleModifier() {
    Text(
        text = "Hello world!", modifier = Modifier
            .padding(16.dp)
            .height(50.dp)
    )
}

@Composable
fun Greeting(mensaje: String) {
    Box(modifier = Modifier.fillMaxSize()
    , contentAlignment = Alignment.Center){
        Text(text = "Hello $mensaje!")
    }
}


@Composable
fun GreetingPreview() {
    Ejemplo1Theme {
        Greeting("")
    }
}