package com.example.fitfusion

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fitfusion.FirstTimeScreens.MenuOpciones

@Composable
fun SettingsScreen(navController: NavController){
    IconButton(onClick = { navController.navigate("inicio") }) {
        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Go back")
    }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp, start = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ){
        Text(
            text = "Ajustes",
            textAlign = TextAlign.Left,
            color = Color(0xFFBCBCBC),
            fontSize = 50.sp,
        )
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        /*val opcionesTipo2: Array<String> = arrayOf("Generico", "Boxeo", "Fútbol")
        MenuOpciones(opcionesTipo2, "Cambiar entrenamiento?")
        val opcionesDificultad2: Array<String> = arrayOf("Fácil", "Medio", "Difícil")
        MenuOpciones(opcionesDificultad2, "Cambiar dificultad?")*/
        
        Spacer(modifier = Modifier.size(70.dp))
        
        Button (onClick = { navController.navigate("inicio") } ) {
            Text("Confirmar")
        }
    }

}
