package com.example.gymapp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

val modgym = ModelGym()
val contgym = RegLogView()
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "register") {
                composable("register") {
                    contgym.RegistrationScreen(navController = navController)
                }
                composable("login") {
                    contgym.LoginScreen(navController = navController)
                }
            }
        }
    }
}






