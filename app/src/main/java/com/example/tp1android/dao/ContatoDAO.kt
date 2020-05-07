package com.example.tp1android.dao

import androidx.room.*
import com.example.tp1android.Model.Contato
import com.example.tp1android.Model.Usuario

// Lista, cria, le, atualiza e exclui
@Dao
interface ContatoDAO {
    @Insert fun store(contato: Contato)
    @Update fun update(contato: Contato)
    @Delete fun delete(contato: Contato)

    @Query("SELECT * FROM Contato")
    fun all(): Array<Usuario>
    @Query("SELECT * FROM Contato WHERE id = :indicador")
    fun show(indicador: Int): Array<Usuario>
}