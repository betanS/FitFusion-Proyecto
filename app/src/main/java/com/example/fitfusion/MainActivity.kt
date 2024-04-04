package com.example.fitfusion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.fitfusion.FirstTimeScreens.RegisterScreen2
import com.example.fitfusion.FirstTimeScreens.StartScreen
import com.example.fitfusion.data.MainViewModel
import com.example.fitfusion.localdatabase.usuarios.AppDatabase
import com.example.fitfusion.localdatabase.usuarios.AppDatabaseViewModel
import com.example.fitfusion.ui.theme.FitFusionTheme

@Suppress("UNCHECKED_CAST")
class MainActivity : ComponentActivity() {
    val db by lazy {
        Room.databaseBuilder(
            context = applicationContext,
            klass = AppDatabase::class.java,
            name = "user.db"
        ).build()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FitFusionTheme {
                val databaseViewModel: AppDatabaseViewModel by viewModels<AppDatabaseViewModel>(
                    factoryProducer = {
                        object : ViewModelProvider.Factory {
                            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                                return AppDatabaseViewModel(db.dao) as T
                            }
                        }
                    }
                )
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    App(databaseViewModel)
                }
            }
        }
    }
}
@Composable
fun App(
    databaseViewModel: AppDatabaseViewModel,
    navController: NavHostController = rememberNavController()
) {
    val mainViewModel: MainViewModel = viewModel()
    Scaffold() { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home"
        ) {
            composable(route = "home") {
                Column {
                    /*Text(text = "DEBUG. Lista de usuarios", color = Color.White)
                        val userList = databaseViewModel.getAllUsers().collectAsState(initial = emptyList())
                        LazyColumn {
                            if (userList.value.isEmpty()) {
                                item {
                                    Text(text = "No hay usuarios en la DB", color = Color.White)
                                }
                            } else {
                                item {
                                    Text("Usuarios en la DB: ${userList.value.size}", color = Color.White)
                                }
                                items(userList.value) { user ->
                                    Text(" Name: ${user.username}", color = Color.White)
                                }
                            }
                        }*/
                }
                StartScreen(navController)
            }
            /*composable(
                route = "login",
            ) {
                LoginScreen(navController, databaseViewModel)
            }
            composable(
                route = "register"
            ) {
                RegisterScreen(navController, databaseViewModel)
            }*/
            composable(
                route = "register2"
            ) {
                RegisterScreen2(navController)
            }
            composable(
                route = "inicio"
            ) {
                InicioScreen(navController, mainViewModel)

            }
            composable(
                route = "settings"
            ) {
                SettingsScreen(navController)

            }
        }
    }
}
//#######################################################################


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


