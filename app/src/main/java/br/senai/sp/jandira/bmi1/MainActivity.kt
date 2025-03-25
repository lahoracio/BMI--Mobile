package br.senai.sp.jandira.bmi1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.bmi1.screens.BMIResultScreen
import br.senai.sp.jandira.bmi1.screens.HomeScreen
import br.senai.sp.jandira.bmi1.screens.UserDataScreen
import br.senai.sp.jandira.bmi1.ui.theme.BMI1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BMI1Theme {
                val controleDeNavegacao = rememberNavController()
                NavHost(
                    navController = controleDeNavegacao,
                    startDestination = "home"
                ){
                   composable(route = "home"){ HomeScreen(controleDeNavegacao) }
                   composable(route = "user_data"){ UserDataScreen(controleDeNavegacao) }
                   composable(route = "bmi_result"){ BMIResultScreen(controleDeNavegacao) }
                }

            }
        }
    }
}

