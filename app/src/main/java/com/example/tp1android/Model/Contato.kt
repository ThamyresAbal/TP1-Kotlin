package com.example.tp1android.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Contato (

 var telefone: String,
 var usuario_id: Int,
 @PrimaryKey(autoGenerate = true) var id: Int? = null

)