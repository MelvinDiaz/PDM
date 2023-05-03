package com.diaz.cartrackercompose.ui.car

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.diaz.cartrackercompose.R
import com.diaz.cartrackercompose.data.models.Car
import kotlinx.coroutines.launch


@Composable

fun MainCarScreen() {
    val viewModel: CarViewModel = viewModel(factory = CarViewModel.Factory)
    val cars = remember { mutableStateOf(listOf<Car>()) }

    //Wrapped in a coroutine
    LaunchedEffect(Unit) {
        viewModel.viewModelScope.launch {
            val _cars = viewModel.getCars()
            cars.value = _cars
        }
    }
    CarList(cars.value)
}


@Composable
fun CarList(car: List<Car>) {
    val scrollState = rememberLazyListState()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        state = scrollState
    ) {
        items(car) { car ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = car.model)
                    Text(text = car.year.toString())
                }
            }

        }
    }
}

@Preview
@Composable
fun FloatingAddButton() {
    val miniFabSize = 40.dp
    FloatingActionButton(
        modifier = Modifier.size(miniFabSize),
        onClick = { /*TODO*/ },
    ) {

        Icon(imageVector = Icons.Default.Add, contentDescription = "Add button")
    }
}