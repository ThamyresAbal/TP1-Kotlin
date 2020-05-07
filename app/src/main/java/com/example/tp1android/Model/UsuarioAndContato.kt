package com.example.tp1android.Model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

@Entity
class UsuarioAndContato (
    @Embedded val usuario: Usuario,
    @Relation(
        parentColumn = "id",
        entityColumn = "usuario_id"
    ) val contato: Contato
)
{
    /*
    override fun toString(): String {
        return "${usuario.nome} ${usuario.sobrenome} -- ${contato.telefone}"
    }
    */
}