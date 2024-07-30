
package com.andre.sportfinder.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.andre.sportfinder.ui.screens.TelaLogin
import com.andre.sportfinder.ui.screens.TelaRegistro
import com.andre.sportfinder.ui.screens.TelaListaAcademias
import com.andre.sportfinder.viewmodel.UsuarioViewModel

@Composable
fun AppNavigation(navController: NavHostController, usuarioViewModel: UsuarioViewModel) {
    NavHost(navController, startDestination = "login") {
        composable("login") {
            TelaLogin(viewModel = usuarioViewModel, onLogin = {
                navController.navigate("lista_academias")
            })
        }
        composable("registro") {
            TelaRegistro(viewModel = usuarioViewModel, onRegister = {
                navController.navigate("login")
            })
        }
        composable("lista_academias") {
            TelaListaAcademias(academias = listOf(

            ))
        }
    }
}
