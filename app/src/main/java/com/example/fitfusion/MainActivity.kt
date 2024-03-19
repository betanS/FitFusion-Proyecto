package com.example.fitfusion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fitfusion.FirstTimeScreens.LoginScreen
import com.example.fitfusion.FirstTimeScreens.RegisterScreen
import com.example.fitfusion.FirstTimeScreens.RegisterScreen2
import com.example.fitfusion.FirstTimeScreens.StartScreen
import com.example.fitfusion.ui.theme.FitFusionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FitFusionTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}
@Composable
fun App(
    navController: NavHostController = rememberNavController()
) {

    Scaffold() { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "inicio"
        ) {
            composable(route = "home") {
                StartScreen(navController)
            }
            composable(
                route = "login",
            ) {
                LoginScreen(navController)
            }
            composable(
                route = "register"
            ) {
                RegisterScreen(navController)
            }
            composable(
                route = "register2"
            ) {
                RegisterScreen2(navController)
            }
            composable(
                route = "inicio"
            ) {
                InicioScreen(navController)
            }
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
fun ShowImage() {
    Image(
        modifier = Modifier
            .width(250.dp)
            .height(250.dp)
            .padding(23.dp),
        painter = painterResource(id = R.drawable.logo_app),
        contentDescription = "logo"
    )
}