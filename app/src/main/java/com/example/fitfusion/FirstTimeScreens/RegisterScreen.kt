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
import com.example.fitfusion.ShowImage
import com.example.fitfusion.localdatabase.usuarios.AppDatabaseViewModel
import com.example.fitfusion.localdatabase.usuarios.User

@Composable
fun RegisterScreen(navController: NavController, databaseViewModel: AppDatabaseViewModel) {
    var email by rememberSaveable { mutableStateOf("") }
    var name by rememberSaveable { mutableStateOf("") }
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
            value = name,
            onValueChange = { name = it },
            label = { Text("Enter name.") }
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Enter password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        Text(text = errortxt,
            color = Color.Red)
        /*try {
            println("${databaseViewModel.getUserByEmail(email)}")
            println("${databaseViewModel.getUserByUsername(name)}")
        }catch (e:Exception){
            Text(text = "No existe el usuario")
        }*/

        Button(onClick = {
            val user = User(username = name, email = email, password = password)

            try {
                databaseViewModel.insert(user)
                navController.navigate("inicio")
            } catch (e: Exception) {
                errortxt = "La dirección de email ya existe."
                // Log error
            }
        }) {
            Text("Siguiente")
        }
    }

}

