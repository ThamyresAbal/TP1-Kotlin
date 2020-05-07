package com.example.tp1android.Model
import android.graphics.drawable.Drawable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Usuario(
    var nome: String,
    var sobrenome: String,
    var foto: String,
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
)



