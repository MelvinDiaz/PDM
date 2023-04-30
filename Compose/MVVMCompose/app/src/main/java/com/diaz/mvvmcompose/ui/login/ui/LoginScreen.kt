package com.diaz.mvvmcompose.ui.login.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun LoginScreen(viewModel: LoginViewModel) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Login(
            Modifier
                .align(Alignment.Center)
                .fillMaxSize(), viewModel
        )
    }
}

@Composable
fun Login(modifier: Modifier, viewModel: LoginViewModel) {
    val email: String by viewModel.email.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")
    val loginEnable: Boolean by viewModel.loginEnabled.observeAsState(initial = false)
    val isLoading: Boolean by viewModel.isLoading.observeAsState(initial = false)
    val coroutineScope = rememberCoroutineScope()


    if (isLoading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(Modifier.align(Alignment.Center))
        }
    } else {
        Column(modifier) {


            HeaderTitle()
            Spacer(modifier = Modifier.padding(40.dp))

            LoginBox(email, viewModel, password, loginEnable, coroutineScope)

            Spacer(modifier = Modifier.padding(40.dp))
            RegisterBox()
        }
    }


}

@Composable
fun HeaderTitle() {
    Text(
        text = "Bienvenido a Autominder", fontSize = 24.sp, modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun LoginBox(
    email: String,
    viewModel: LoginViewModel,
    password: String,
    loginEnable: Boolean,
    coroutineScope: CoroutineScope,
) {

    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF0B2748),
        ),
        modifier = Modifier
            .padding(16.dp)
            .height(350.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)

        ) {
            AccountHeader()
            EmailTextField(email) { viewModel.onLoginChange(it, password) }
            Spacer(modifier = Modifier.padding(8.dp))

            PasswordTextField(password) { viewModel.onLoginChange(email, it) }
            ForgotPassword()
            Spacer(modifier = Modifier.padding(8.dp))

            LoginButton(loginEnable) {
                coroutineScope.launch {
                    viewModel.OnLoginSelected(email, password)
                }

            }
        }
    }
}

@Composable
fun AccountHeader() {
    Text(
        text = "Ingresa a tu cuenta",
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        textAlign = TextAlign.Center,
        fontSize = 22.sp,
        color = Color(0xFFDEE0FF),
    )
}

@Composable
fun ForgotPassword() {
    Text(
        text = "¿Olvidaste tu contraseña?", modifier = Modifier
            .fillMaxWidth()
            .clickable { }
            .padding(8.dp),
        textAlign = TextAlign.End,
        color = Color(0xFFDEE0FF)
    ) //TODO: Add clickable
}

@Composable
fun EmailTextField(email: String, onTextFieldChanged: (String) -> Unit) {
    OutlinedTextField(
        value = email,
        onValueChange = { onTextFieldChanged(it) },
        label = { Text("Email") },
        shape = MaterialTheme.shapes.small,

        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),

        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        placeholder = { Text("example@example.com") },

        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color(0xFFDEE0FF),
            cursorColor = Color(0xFFDEE0FF),
            focusedBorderColor = Color(0xFFDEE0FF),
            unfocusedBorderColor = Color(0xFFDEE0FF),
            focusedLabelColor = Color(0xFFDEE0FF),
            unfocusedLabelColor = Color(0xFFDEE0FF),
            placeholderColor = Color(0xFFDEE0FF),
        ),
    )
}

@Composable
fun PasswordTextField(password: String, onTextFieldChanged: (String) -> Unit) {
    OutlinedTextField(
        value = password,
        onValueChange = { onTextFieldChanged(it) },
        label = { Text("Password") },
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = PasswordVisualTransformation(),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color(0xFFDEE0FF),
            cursorColor = Color(0xFFDEE0FF),
            focusedBorderColor = Color(0xFFDEE0FF),
            unfocusedBorderColor = Color(0xFFDEE0FF),
            focusedLabelColor = Color(0xFFDEE0FF),
            unfocusedLabelColor = Color(0xFFDEE0FF),
            placeholderColor = Color(0xFFDEE0FF),
        ),
    )
}

@Composable
fun LoginButton(loginEnable: Boolean, onLoginSelected: () -> Unit) {
    Button(
        onClick = { onLoginSelected() },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFDEE0FF),
            disabledContainerColor = Color(0xFF000000)
        ),
        enabled = loginEnable,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 0.dp, bottom = 0.dp, start = 16.dp, end = 16.dp)
    ) {
        Text(text = "Iniciar sesión", color = Color.Black)
    }

}

@Composable
fun RegisterBox() {
    Text(
        text = "¿No tienes cuenta?", modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), textAlign = TextAlign.Center, color = Color.Black
    )
    RegisterButton()
}

@Composable
fun RegisterButton() {
    Button(
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0B2748)),
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 0.dp, bottom = 0.dp, start = 25.dp, end = 25.dp)
    ) {
        Text(text = "Regístrate", color = Color(0xFFDEE0FF))
    }
}