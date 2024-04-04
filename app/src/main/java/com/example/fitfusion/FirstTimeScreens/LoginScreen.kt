package com.example.fitfusion.FirstTimeScreens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.navigation.NavController
import com.example.fitfusion.ClickableTxt
import com.example.fitfusion.ShowImage
import com.example.fitfusion.localdatabase.usuarios.AppDatabaseViewModel

@Composable
fun LoginScreen(navController: NavController, databaseViewModel: AppDatabaseViewModel) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var errortxt by rememberSaveable { mutableStateOf(" ") }

    IconButton(onClick = { navController.navigateUp() }) {
        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Go back")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ShowImage()
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Enter email.") }
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Enter password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        ClickableTxt()
        Text(text = errortxt,
            color = Color.Red)

        Button(onClick = {
            // Obtener el email y la contraseña ingresados por el usuario
            val emailInput = email
            val passwordInput = password

            // Verificar el email y la contraseña utilizando el ViewModel
            /*val loginSuccessful = databaseViewModel.loginUser(emailInput, passwordInput)
            if (loginSuccessful) {
                // Si el inicio de sesión es exitoso, navegar a la pantalla de inicio
                navController.navigate("inicio")
            } else {
                // Si el inicio de sesión falla, mostrar un mensaje de error
                errortxt = "Email o contraseña incorrectos"
            }*/
        }) {
            Text("Login")
        }

    }
}

