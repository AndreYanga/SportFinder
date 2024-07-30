
package com.andre.sportfinder.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.andre.sportfinder.data.entity.Usuario

@Dao
interface UsuarioDao {
    @Insert
    suspend fun inserir(usuario: Usuario)

    @Query("SELECT * FROM usuarios WHERE email = :email AND senha = :senha")
    suspend fun autenticar(email: String, senha: String): Usuario?
}
