package com.diaz.mvvmcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.diaz.mvvmcompose.ui.login.ui.LoginScreen
import com.diaz.mvvmcompose.ui.login.ui.LoginViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen(LoginViewModel())
        }
    }
}

