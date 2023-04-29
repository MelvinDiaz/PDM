@file:OptIn(ExperimentalMaterial3Api::class)

package com.diaz.states

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.style.ClickableSpan
import android.widget.Toast
import android.widget.Toolbar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.diaz.states.ui.theme.StatesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewContainer()
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview
fun ViewContainer() {
    Scaffold(
        topBar = { Toolbar() },
        content = { Content() },
        floatingActionButton = { floatingActionButton() },
        floatingActionButtonPosition = FabPosition.End,
    )
}

@Composable
fun floatingActionButton() {
    val context = LocalContext.current
    FloatingActionButton(
        onClick = { Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show()},
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text(text = "+")
    }
}


@Composable
fun Toolbar() {
    TopAppBar(
        title = { Text(text = "Aplicación", color = Color.Red)},
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)

    )

}

@Composable
fun Content() {
    var counter by rememberSaveable { mutableStateOf(0) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
            .padding(top = 100.dp)

    ) {
        item {
            Image(
                modifier = Modifier
                    .fillMaxWidth(),

                painter = painterResource(id = R.drawable.debian_magenta_pink_1920x1080),
                contentDescription = "Debian image"
            )
            Row() {
                Image(
                    modifier = Modifier.clickable { counter++ },
                    painter = painterResource(id = R.drawable.ic_favorite),
                    contentDescription = "Favorite"
                )
                Text(text = counter.toString())
            }
            Column {
                Text(
                    text = "Melvin",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 32.sp,
                    color = Color.White
                )
                Text(text = "Stack", fontSize = 22.sp, color = Color.White)
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    item {
                        Text(
                            text = "JavaScript",
                            fontSize = 22.sp,
                            color = Color.White,
                            modifier = Modifier.padding(16.dp)
                        )
                        Text(
                            text = "Python",
                            fontSize = 22.sp,
                            color = Color.White,
                            modifier = Modifier.padding(16.dp)
                        )
                        Text(
                            text = "Java",
                            fontSize = 22.sp,
                            color = Color.White,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            }

        }
    }
}