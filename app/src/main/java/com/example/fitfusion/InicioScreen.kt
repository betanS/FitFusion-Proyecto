package com.example.fitfusion

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController
import com.example.fitfusion.data.MainViewModel

@Composable
fun InicioScreen(navController: NavController, viewModel: MainViewModel) {
    val isLoading: Boolean by viewModel.isLoading.observeAsState(initial = true)
    if (isLoading) {
        viewModel.getCurrentWeather("Haría")
        Column {
            Text("Cargando...")
        }
    } else {
        // 1.- Cambiar las unidades de medida a españa
        // 2.- Añadir un text field
        // 3.- Añadir un boton que capture el text field  llame al viewmodel
        // 4.- Imprimir los datos de la nueva llamada
        Column {
            Text("Temperatura = ${viewModel.currentWeather.value?.main?.temp}")
            Text("Sensación térmica = ${viewModel.currentWeather.value?.main?.feels_like}")
            Text("Temperatura máxima = ${viewModel.currentWeather.value?.main?.temp_max}")
            Text("Temperatura mínima = ${viewModel.currentWeather.value?.main?.temp_min}")
            Text("Presión atmosférica = ${viewModel.currentWeather.value?.main?.pressure}")
            Text("Humedad = ${viewModel.currentWeather.value?.main?.humidity}")
        }
    }

    /*val sdf = SimpleDateFormat("'Fecha:\n'dd/MM/yyyy")
    val currentDateAndTime = sdf.format(Date())
    //var temperature by remember { mutableStateOf("") }
        Text(text = currentDateAndTime)

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            val currentDateAndTime = sdf.format(Date())
            //val (morning, afternoon) = Workout

            Text(
                currentDateAndTime,
                style = MaterialTheme.typography.headlineSmall
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
               /* Text(
                    "Mañana: ${morning.name} - ${morning.duration} mins",
                    style = MaterialTheme.typography.titleMedium
                )*/
                Column(
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .weight(1f)
                ) {
                    /*Text(
                        "Tarde: ${afternoon.name} - ${afternoon.sets} x ${afternoon.reps}",
                        style = MaterialTheme.typography.titleMedium
                    )*/
                    /*Text(
                        "Completado:${" ".repeat(10)} $date",
                        style = MaterialTheme.typography.displayMedium
                    )
                    Text(
                        advice.advice,
                        style = MaterialTheme.typography.titleMedium
                    )*/
                }
            }
        }*/
    }