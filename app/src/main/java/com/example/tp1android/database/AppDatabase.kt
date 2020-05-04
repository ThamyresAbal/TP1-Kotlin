package com.example.tp1android.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tp1android.DAO.UsuarioDAO
import com.example.tp1android.Model.Usuario

@Database(
    entities = arrayOf(
        Usuario::class
    ),
    version = 1
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun usuarioDao() : UsuarioDAO
}