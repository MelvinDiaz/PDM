package com.diaz.mvvmcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.diaz.mvvmcompose.ui.forgot_password.ForgotPasswordScreen
import com.diaz.mvvmcompose.ui.login.ui.LoginScreen
import com.diaz.mvvmcompose.ui.login.ui.LoginViewModel
import com.diaz.mvvmcompose.ui.register.ui.RegisterScreen
import com.diaz.mvvmcompose.ui.theme.AppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme(useDarkTheme = false) {
                MyAppHost()
            }
        }
    }
}

@Composable
fun MyAppHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "login"
) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDestination
    ) {
        composable("login") {
            LoginScreen(LoginViewModel(), navController)
        }
        composable("register") {
            RegisterScreen()
        }
        composable("forgot_password") {
            ForgotPasswordScreen()
        }
    }
}