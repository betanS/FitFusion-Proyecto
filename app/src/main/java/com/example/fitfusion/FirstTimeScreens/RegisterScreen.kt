package com.example.fitfusion.FirstTimeScreens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.fitfusion.PassWrd
import com.example.fitfusion.ShowImage
import com.example.fitfusion.UserField

@Composable
fun RegisterScreen(navController: NavController) {
    IconButton(onClick = { navController.navigateUp() }) {
        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Go back")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ShowImage()
        UserField("email")
        UserField("username")
        PassWrd()
        Button (onClick = { navController.navigate("inicio") } ) {
            Text("Login")
        }
    }
}