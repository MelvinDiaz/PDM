package com.diaz.filas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.diaz.filas.ui.theme.FilasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            app()
        }
    }
}

@Composable
@Preview
fun app() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize() //Para todo el dispositivo
            .background(color = Color.Red)
    ) {
        item {
            Image(
                painter = painterResource(id = R.drawable.debian_magenta_pink_1920x1080),
                contentDescription = "Debian",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp) //Para el ancho del dispositivo
                    .padding(16.dp)
            )
            Text(
                text = "Item 1",
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                    fontSize = 32.sp
            )
            LazyRow(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                item {
                    Text(
                        text = "JavaScript",
                        color = Color.White,
                        modifier = Modifier.padding(16.dp)
                    )
                    Text(text = "Java", color = Color.White, modifier = Modifier.padding(16.dp))
                    Text(text = "Java", color = Color.White, modifier = Modifier.padding(16.dp))
                    Text(text = "Java", color = Color.White, modifier = Modifier.padding(16.dp))
                    Text(text = "Java", color = Color.White, modifier = Modifier.padding(16.dp))
                    Text(text = "Java", color = Color.White, modifier = Modifier.padding(16.dp))
                    Text(text = "Java", color = Color.White, modifier = Modifier.padding(16.dp))
                    Text(text = "Java", color = Color.White, modifier = Modifier.padding(16.dp))
                    Text(text = "Java", color = Color.White, modifier = Modifier.padding(16.dp))
                    Text(text = "Java", color = Color.White, modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}