package com.diaz.cartrackercompose.ui.car

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.diaz.cartrackercompose.data.models.Car



@Composable
fun MainCarScreen(){
    val viewModel: CarViewModel = viewModel(factory = CarViewModel.Factory)
    val cars = viewModel.getCars()
    CarList(cars)
}


@Composable
fun CarList(car: List<Car>){
    val scrollState = rememberLazyListState()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        state = scrollState
    ){
        items(car){
            car ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ){
                    Column(modifier = Modifier.padding(16.dp)){
                        Text(text = car.model)
                        Text(text = car.year.toString())
                    }
                }
        }
    }
}