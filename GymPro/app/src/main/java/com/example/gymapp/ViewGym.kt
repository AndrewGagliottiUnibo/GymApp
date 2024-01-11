package com.example.gymapp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.gymapp.ModelGym
import com.example.gymapp.ControllerGym

val modgym = ModelGym()
val contgym = ControllerGym()
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




/*
@Preview
@Composable
fun PreviewRegistrationScreen() {
    RegistrationScreen(navController = rememberNavController())
}

@Preview
@Composable
fun PreviewLoginScreen() {
    LoginScreen(navController = rememberNavController())
}

 */



/* suspend fun saveUserData(username: String, password: String, userDao: UserDao) {
    val hashedPassword = modgym.hashPassword(password)

    val user = User(username = username, password = hashedPassword)
    userDao.insertUser(user)
}

 */

