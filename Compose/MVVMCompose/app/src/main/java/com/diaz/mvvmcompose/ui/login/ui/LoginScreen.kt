package com.diaz.mvvmcompose.ui.login.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.diaz.mvvmcompose.ui.theme.backgroundColor

@Composable
@Preview(showBackground = true)
fun LoginScreen() {
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Login(
            Modifier
                .align(Alignment.Center)
                .fillMaxSize()
        )
    }
}

@Composable
fun Login(modifier: Modifier) {
    Column(modifier) {
        HeaderTitle()
        Spacer(modifier = Modifier.padding(40.dp))
        LoginBox()
        Spacer(modifier = Modifier.padding(40.dp))
        RegisterBox()
    }
}

@Composable
fun HeaderTitle() {
    Text(
        text = "Bienvenido a Autominder", fontSize = 24.sp, modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(), textAlign = TextAlign.Center
    )
}

@Composable
fun LoginBox() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF0B2748),
        ),
        modifier = Modifier
            .padding(16.dp)
            .height(350.dp),


        ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Ingresa a tu cuenta",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                textAlign = TextAlign.Center,
                fontSize = 22.sp,
                color = Color.White,
            )
            EmailTextField()
            PasswordTextField()
            Text(
                text = "¿Olvidaste tu contraseña?", modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp), textAlign = TextAlign.End, color = Color.White
            ) //TODO: Add clickable
            Spacer(modifier = Modifier.padding(8.dp))
            LoginButton()
        }
    }

}

@Composable
fun EmailTextField() {
    var email by rememberSaveable { mutableStateOf("") }
    TextField(
        value = email,
        onValueChange = { email = it },
        label = { Text("Email") },
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(16.dp)

    )
}

@Composable
fun PasswordTextField() {
    var password by rememberSaveable { mutableStateOf("") }
    TextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Password") },
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(16.dp)

    )
}

@Composable
fun LoginButton() {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 0.dp, bottom = 0.dp, start = 16.dp, end = 16.dp)
    ) {
        Text(text = "Iniciar sesión")
    }

}

@Composable
fun RegisterBox() {
    Text(text = "¿No tienes cuenta?", modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp), textAlign = TextAlign.Center, color = Color.Black)
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 0.dp, bottom = 0.dp, start = 25.dp, end = 25.dp)
    ) {
        Text(text = "Regístrate")
    }
}