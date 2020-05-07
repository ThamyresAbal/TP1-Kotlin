package com.example.tp1android.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tp1android.Model.Contato
import com.example.tp1android.dao.UsuarioDAO
import com.example.tp1android.Model.Usuario
import com.example.tp1android.dao.ContatoDAO

@Database(
    entities = arrayOf(
        Usuario::class,
        Contato::class
    ),
    version = 1
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun usuarioDao() : UsuarioDAO
    abstract fun contatoDao() : ContatoDAO
}

