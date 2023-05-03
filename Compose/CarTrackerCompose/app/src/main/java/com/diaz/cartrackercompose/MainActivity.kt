package com.diaz.cartrackercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.diaz.cartrackercompose.ui.car.FloatingAddButton
import com.diaz.cartrackercompose.ui.car.MainCarScreen


@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Scaffold(

                floatingActionButton = { FloatingAddButton()},

            ){
                contentPadding -> Box(modifier = Modifier.padding(contentPadding)) {
                MainCarScreen()
            }

            }
        }
    }
}