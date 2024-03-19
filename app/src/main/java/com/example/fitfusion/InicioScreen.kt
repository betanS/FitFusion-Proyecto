package com.example.fitfusion

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.text.SimpleDateFormat
import java.util.Date

@Composable
fun InicioScreen(navController: NavController) {
    val sdf = SimpleDateFormat("'Fecha:\n'dd/MM/yyyy")
    val currentDateAndTime = sdf.format(Date())

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Pantalla de inicio")
        Text(text = currentDateAndTime)

        Spacer(modifier = Modifier.padding(20.dp))

        Text(text = "Mañana")
        Text(text = "Tarde")
        Text(text = "Consejo")
        Text(text = getTemperature("Haria"))

    }
}