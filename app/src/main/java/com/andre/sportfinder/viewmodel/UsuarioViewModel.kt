
package com.andre.sportfinder.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andre.sportfinder.data.entity.Usuario
import com.andre.sportfinder.data.repository.UsuarioRepository
import kotlinx.coroutines.launch

class UsuarioViewModel(private val repository: UsuarioRepository) : ViewModel() {
    fun inserir(usuario: Usuario) {
        viewModelScope.launch {
            repository.inserir(usuario)
        }
    }

    fun autenticar(email: String, senha: String, onResult: (Usuario?) -> Unit) {
        viewModelScope.launch {
            val usuario = repository.autenticar(email, senha)
            onResult(usuario)
        }
    }
}
