package com.andre.sportfinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.andre.sportfinder.data.database.AppDatabase
import com.andre.sportfinder.data.repository.UsuarioRepository
import com.andre.sportfinder.ui.navigation.AppNavigation
import com.andre.sportfinder.ui.theme.SportFinderTheme
import com.andre.sportfinder.viewmodel.UsuarioViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "sportfinder-database"
        ).build()
        val usuarioRepository = UsuarioRepository(db.usuarioDao())
        val usuarioViewModel = UsuarioViewModel(usuarioRepository)

        setContent {
            SportFinderTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    AppNavigation(navController = navController, usuarioViewModel = usuarioViewModel)
                }
            }
        }
    }
}
