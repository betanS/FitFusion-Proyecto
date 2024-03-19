package com.example.fitfusion.FirstTimeScreens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.fitfusion.ShowImage

@Composable
fun StartScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ShowImage()
        Button (onClick = { navController.navigate("login") } ) {
            Text("Login")
        }
        Button (onClick = { navController.navigate("register") } ) {
            Text("Register")
        }
    }
}