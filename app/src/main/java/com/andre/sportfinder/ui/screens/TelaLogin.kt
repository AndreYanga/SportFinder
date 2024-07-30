package com.andre.sportfinder.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.navigation.NavHostController
import com.andre.sportfinder.viewmodel.UsuarioViewModel

@Composable
fun TelaLogin(viewModel: UsuarioViewModel, onLogin: () -> Unit, navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = senha,
            onValueChange = { senha = it },
            label = { Text("Senha") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                viewModel.autenticar(email, senha) { usuario ->
                    if (usuario != null) {
                        onLogin()
                    } else {
                        errorMessage = "Email ou senha incorretos. Tente novamente."
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }
        errorMessage?.let {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = it,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyLarge
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Não possui uma conta? Registre-se aqui.",
            modifier = Modifier.clickable {
                navController.navigate("register")
            },
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline
        )
    }
}
