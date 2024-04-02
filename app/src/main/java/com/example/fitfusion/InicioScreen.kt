package com.example.fitfusion

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fitfusion.data.MainViewModel
import java.text.SimpleDateFormat
import java.util.Date

@Composable
fun InicioScreen(navController: NavController, viewModel: MainViewModel) {
    val sdf = SimpleDateFormat("dd/MM/yyyy")
    val currentDateAndTime = sdf.format(Date())
    //#####################DATOS-CONSULTAS###############################
    val city = "Haria"
    val diaDeEntrenamiento = 5//Ejemplo dia 1-30
    var listaEjercicios = listOf(
        Ejercicio(1, "Sentadillas", 3, 10),
        Ejercicio(2, "Sentadillas", 3, 11),
        Ejercicio(3, "Sentadillas", 3, 12),
        Ejercicio(4, "Sentadillas", 3, 13),
        Ejercicio(5, "Sentadillas", 3, 14),
        Ejercicio(6, "Sentadillas", 3, 15),
        Ejercicio(7, "Sentadillas", 4, 10),
        Ejercicio(8, "Sentadillas", 4, 11),
        Ejercicio(9, "Sentadillas", 4, 12),
        Ejercicio(10, "Sentadillas", 4, 13),
        Ejercicio(11, "Sentadillas", 4, 14),
        Ejercicio(12, "Sentadillas", 4, 15),
        Ejercicio(13, "Sentadillas", 5, 10),
        Ejercicio(14, "Sentadillas", 5, 11),
        Ejercicio(15, "Sentadillas", 5, 12),
        Ejercicio(16, "Sentadillas", 5, 13),
        Ejercicio(17, "Sentadillas", 5, 14),
        Ejercicio(18, "Sentadillas", 5, 15),
        Ejercicio(19, "Sentadillas", 6, 10),
        Ejercicio(20, "Sentadillas", 6, 11),
        Ejercicio(21, "Sentadillas", 6, 12),
        Ejercicio(22, "Sentadillas", 6, 13),
        Ejercicio(23, "Sentadillas", 6, 14),
        Ejercicio(24, "Sentadillas", 6, 15),
        Ejercicio(25, "Sentadillas", 7, 10),
        Ejercicio(26, "Sentadillas", 7, 11),
        Ejercicio(27, "Sentadillas", 7, 12),
        Ejercicio(28, "Sentadillas", 7, 13),
        Ejercicio(29, "Sentadillas", 7, 14),
        Ejercicio(30, "Sentadillas", 7, 15)

    )
    var listaCardio = listOf(
        Cardio(1, "Correr", 10),
        Cardio(2, "Correr", 11),
        Cardio(3, "Correr", 12),
        Cardio(4, "Correr", 13),
        Cardio(5, "Correr", 14),
        Cardio(6, "Correr", 15),
        Cardio(7, "Correr", 16),
        Cardio(8, "Correr", 17),
        Cardio(9, "Correr", 18),
        Cardio(10, "Correr", 19),
        Cardio(11, "Correr", 20),
        Cardio(12, "Correr", 21),
        Cardio(13, "Correr", 22),
        Cardio(14, "Correr", 23),
        Cardio(15, "Correr", 24),
        Cardio(16, "Correr", 25),
        Cardio(17, "Correr", 26),
        Cardio(18, "Correr", 27),
        Cardio(19, "Correr", 28),
        Cardio(20, "Correr", 30),
        Cardio(21, "Correr", 30),
        Cardio(22, "Correr", 30),
        Cardio(23, "Correr", 30),
        Cardio(24, "Correr", 30),
        Cardio(25, "Correr", 30),
        Cardio(26, "Correr", 30),
        Cardio(27, "Correr", 30),
        Cardio(28, "Correr", 30),
        Cardio(29, "Correr", 30),
        Cardio(30, "Correr", 30)
    )


    fun consejoDehoy(temperatura: Double?): String{
        //return "Todo bien papu, ${temperatura}"
        if (temperatura!! >= 25){
            return "\uD83E\uDD75 Hace mucho calor, mejor entrena en casa. \uD83E\uDD75"
        }else if(temperatura < 17){
            return "\uD83E\uDD76 Que pelete, mejor entrena en casa. \uD83E\uDD76"
        }else{
            return "\uD83D\uDE0E Hace un buen dia para salir a correr. \uD83D\uDC4C"
        }
    }
    //#####################DATOS-CONSULTAS###############################
    Column {
        Column (
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ){
            Spacer(modifier = Modifier.size(70.dp))

            Text(
                text = "Día ${diaDeEntrenamiento}",
                textAlign = TextAlign.Center,
                fontSize = 50.sp,
                color = Color(0xFFEE4F2B)
            )
        }

        Column (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ){
            Text(
                text = "Días restantes ${(30 - diaDeEntrenamiento)}",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                color = Color(0xFFBCBCBC)
            )
        }

        Spacer(modifier = Modifier.size(70.dp))

        Column {
            Text("Fecha: ${currentDateAndTime}",
                fontSize = 30.sp,
                textAlign = TextAlign.Left,
                color = Color(0xFFBCBCBC))
        }

        Spacer(modifier = Modifier.size(25.dp))

        Column {
            Row {
                Text("Mañana: \n ${listaCardio[diaDeEntrenamiento - 1].name} - ${listaCardio[diaDeEntrenamiento - 1].durationMins} minutos.",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Left
                )
            }
            Row {
                val buttonColor = remember { mutableStateOf(Color.Gray) }
                Button(
                    onClick = { buttonColor.value = Color.Green},
                    modifier = Modifier
                        .clip(RoundedCornerShape(50.dp))
                        .background(buttonColor.value)
                ) { Text(text = "✔") }
            }
        }

        Spacer(modifier = Modifier.size(20.dp))

        Column {
            Row {
                Text("Tarde: \n ${listaEjercicios[diaDeEntrenamiento - 1].name} - ${listaEjercicios[diaDeEntrenamiento - 1].sets} x ${listaEjercicios[diaDeEntrenamiento - 1].reps}",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Left
                )
            }
            Row {
                val buttonColor = remember { mutableStateOf(Color.Gray) }
                Button(
                    onClick = { buttonColor.value = Color.Green},
                    modifier = Modifier
                        .clip(RoundedCornerShape(50.dp))
                        .background(buttonColor.value)
                ) { Text(text = "✔") }
            }
        }

        Spacer(modifier = Modifier.size(20.dp))


        val isLoading: Boolean by viewModel.isLoading.observeAsState(initial = true)
        if (isLoading) {
            viewModel.getCurrentWeather(city)
            Column {
                Text("Cargando...")
            }
        } else {
            var temperatura: Double = 0.0
            if (viewModel.currentWeather.value?.main?.temp != null) {
                temperatura = viewModel.currentWeather.value?.main?.temp!!
            }
            Column {
                Text("Consejo:",
                    fontSize = 25.sp,
                    textAlign = TextAlign.Left)
                Spacer(modifier = Modifier.size(10.dp))
                Text(
                    consejoDehoy(temperatura),
                    fontSize = 20.sp,
                    textAlign = TextAlign.Left)
            }

            Column (
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ){
                Text(
                    text = "$temperatura °C, $city",
                    textAlign = TextAlign.Center,
                    color = Color(0xFFBCBCBC),
                    fontSize = 50.sp,
                )
            }
        }
    }
}