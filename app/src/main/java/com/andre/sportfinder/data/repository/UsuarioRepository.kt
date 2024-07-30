
package com.andre.sportfinder.data.repository

import com.andre.sportfinder.data.dao.UsuarioDao
import com.andre.sportfinder.data.entity.Usuario

class UsuarioRepository(private val usuarioDao: UsuarioDao) {
    suspend fun inserir(usuario: Usuario) {
        usuarioDao.inserir(usuario)
    }

    suspend fun autenticar(email: String, senha: String): Usuario? {
        return usuarioDao.autenticar(email, senha)
    }
}
