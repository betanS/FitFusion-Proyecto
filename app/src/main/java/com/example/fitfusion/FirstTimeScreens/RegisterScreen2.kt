package com.example.fitfusion.FirstTimeScreens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fitfusion.localdatabase.AppDatabaseViewModel
import com.example.fitfusion.localdatabase.Training
import java.text.SimpleDateFormat
import java.util.Date

@SuppressLint("SimpleDateFormat")
@Composable
fun RegisterScreen2(
    navController: NavController,
    databaseViewModel: AppDatabaseViewModel
) {
    IconButton(onClick = { navController.navigateUp() }) {
        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Go back")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val isLoading: Boolean by databaseViewModel.isLoading.observeAsState(initial = true)
        if (!isLoading) {
            navController.navigate("inicio")
        }

        Text(text = "Continua o crea tu entrenamiento", color = Color.White)
        val opcionesTipo: Array<String> = arrayOf("Generico", "Boxeo", "Fútbol")
        var entrenamientoSeleccionado by remember { mutableStateOf(opcionesTipo.first()) }

        MenuOpciones(opcionesTipo, "Tipo de entrenamiento:") { seleccion ->
            entrenamientoSeleccionado = seleccion
        }
        /*val opcionesdificultad: Array<String> = arrayOf("Fácil", "Medio", "Difícil")
        MenuOpciones(opcionesdificultad, "Dificultad:")*/

        Button (onClick = {
            val newTraining: Training = Training(
                dia = 0,
                fecha = SimpleDateFormat("dd/MM/yyyy").format(Date()),
                entrenamiento = entrenamientoSeleccionado
            )
            databaseViewModel.insert(newTraining)
        } ) {
            Text("Siguiente")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuOpciones(opciones: Array<String>, titulo: String, onSeleccion: (opcion: String) -> Unit) {
    val context = LocalContext.current
    val listaOpciones = opciones
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(titulo) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            TextField(
                value = selectedText,
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                listaOpciones.forEach { item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            onSeleccion(item)
                            selectedText = item
                            expanded = false
                            Toast.makeText(context, item, Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
    }
}