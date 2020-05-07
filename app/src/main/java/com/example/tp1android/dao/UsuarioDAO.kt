package com.example.tp1android.dao

import androidx.room.*
import com.example.tp1android.Model.Usuario
import com.example.tp1android.Model.UsuarioAndContato

// Lista, cria, le, atualiza e exclui
@Dao
interface UsuarioDAO {
    @Insert fun store(usuario: Usuario)
    @Update fun update(usuario: Usuario)
    @Delete fun delete(usuario: Usuario)

    @Query("SELECT * FROM Usuario")
    fun all(): Array<Usuario>
    @Query("SELECT * FROM Usuario WHERE id = :indicador")
    fun show(indicador: Int): Array<Usuario>

    @Transaction
    @Query("SELECT * FROM Usuario")
    fun allWithAvalicao(): Array<UsuarioAndContato>
}