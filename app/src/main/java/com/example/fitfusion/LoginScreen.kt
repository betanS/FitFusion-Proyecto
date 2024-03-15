package com.example.fitfusion

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        showImage()
        UserField("username")
        PassWrd()
        ClickableTxt()
        Button (onClick = { navController.navigate("inicio") } ) {
            Text("Login")
        }
    }
}
//#######################################################################

@Composable
fun UserField(txt: String) {
    var user by rememberSaveable { mutableStateOf("") }

    TextField(
        value = user,
        onValueChange = { user = it },
        label = { Text("Enter $txt.") }
    )
}
@Composable
fun PassWrd() {
    var password by rememberSaveable { mutableStateOf("") }

    TextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Enter password") },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )
}

@Composable
fun ClickableTxt(){
    var enabled by remember { mutableStateOf(true) }

    var text = "¿Has olvidado la contraseña?"
    ClickableText(
        text = AnnotatedString(text) ,
        onClick = {
            if (enabled) {
                enabled = false
                text = "Disabled"
            }
        })
}

@Composable
fun showImage(){
    Image(
        modifier = Modifier
            .width(200.dp)
            .height(200.dp)
            .padding(23.dp),
        painter = painterResource(id = R.drawable.logo),
        contentDescription = "logo"

    )
}
