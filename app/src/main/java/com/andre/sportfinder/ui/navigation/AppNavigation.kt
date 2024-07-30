package com.andre.sportfinder.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.andre.sportfinder.ui.screens.TelaListaAcademias
import com.andre.sportfinder.ui.screens.TelaLogin
import com.andre.sportfinder.ui.screens.TelaRegistro
import com.andre.sportfinder.ui.screens.TelaDetalhesAcademia
import com.andre.sportfinder.viewmodel.UsuarioViewModel
import com.andre.sportfinder.ui.screens.Academia

@Composable
fun AppNavigation(navController: NavHostController, usuarioViewModel: UsuarioViewModel) {
    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            TelaLogin(
                viewModel = usuarioViewModel,
                onLogin = {
                    navController.navigate("lista_academias") {
                        popUpTo("login") { inclusive = true }
                    }
                },
                navController = navController
            )
        }
        composable("register") {
            TelaRegistro(
                viewModel = usuarioViewModel,
                onRegisterSuccess = {
                    navController.navigate("login") {
                        popUpTo("register") { inclusive = true }
                    }
                }
            )
        }
        composable("lista_academias") {

            val academias = listOf(
                Academia("Academia 1", "Localização 1", "Contato 1"),
                Academia("Academia 2", "Localização 2", "Contato 2")
            )
            TelaListaAcademias(academias = academias, navController = navController)
        }
        composable("detalhes_academia/{nome}/{localizacao}/{contato}") { backStackEntry ->
            val nome = backStackEntry.arguments?.getString("nome") ?: ""
            val localizacao = backStackEntry.arguments?.getString("localizacao") ?: ""
            val contato = backStackEntry.arguments?.getString("contato") ?: ""
            TelaDetalhesAcademia(nome = nome, localizacao = localizacao, contato = contato)
        }
    }
}
