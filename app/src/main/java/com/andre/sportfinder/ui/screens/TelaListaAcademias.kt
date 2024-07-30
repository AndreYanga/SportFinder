
package com.andre.sportfinder.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class Academia(val nome: String, val localizacao: String, val contato: String)

@Composable
fun TelaListaAcademias(academias: List<Academia>) {
    var pesquisa by remember { mutableStateOf("") }
    val academiasFiltradas = academias.filter {
        it.nome.contains(pesquisa, ignoreCase = true) ||
                it.localizacao.contains(pesquisa, ignoreCase = true) ||
                it.contato.contains(pesquisa, ignoreCase = true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = pesquisa,
            onValueChange = { pesquisa = it },
            label = { Text("Pesquisar Academias") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn {
            items(academiasFiltradas) { academia ->
                AcademiaItem(academia)
            }
        }
    }
}

@Composable
fun AcademiaItem(academia: Academia) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { /* Navegar para detalhes da academia */ }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = academia.nome, style = MaterialTheme.typography.headlineMedium)
            Text(text = academia.localizacao, style = MaterialTheme.typography.bodyLarge)
            Text(text = academia.contato, style = MaterialTheme.typography.bodyLarge)
        }
    }
}
