
package com.andre.sportfinder.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andre.sportfinder.data.entity.Usuario
import com.andre.sportfinder.data.repository.UsuarioRepository
import kotlinx.coroutines.launch

class UsuarioViewModel(private val repository: UsuarioRepository) : ViewModel() {
    fun inserir(usuario: Usuario, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            try {
                repository.inserir(usuario)
                onResult(true)
            } catch (e: Exception) {
                onResult(false)
            }
        }
    }

    fun autenticar(email: String, senha: String, onResult: (Usuario?) -> Unit) {
        viewModelScope.launch {
            val usuario = repository.autenticar(email, senha)
            onResult(usuario)
        }
    }
}
