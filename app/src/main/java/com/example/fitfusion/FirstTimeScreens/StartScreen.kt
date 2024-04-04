package com.example.fitfusion.FirstTimeScreens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        /*Button (onClick = { navController.navigate("login") },
            modifier = Modifier.height(80.dp).width(250.dp).padding(10.dp)
            ) {
            Text("Login", fontSize = 25.sp)
        }
        Button (onClick = { navController.navigate("register") },
            modifier = Modifier.height(80.dp).width(250.dp).padding(10.dp)
        ) {
            Text("Register", fontSize = 25.sp)
        }*/
        Button (onClick = { navController.navigate("register2") },
            modifier = Modifier.height(80.dp).width(250.dp).padding(10.dp)
        ) {
            Text("Entrar", fontSize = 25.sp)
        }
    }
}