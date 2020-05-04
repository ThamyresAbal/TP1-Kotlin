package com.example.tp1android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.room.Room
import com.example.tp1android.database.AppDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var appDatabase = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "appDatabase.sql"
        )
            .allowMainThreadQueries().build()
        // back
        var usuarios = appDatabase.usuarioDao().all()
        // Post
        lstUsuarios.adapter = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_list_item_1,
            usuarios
        )
        fabAddUsuario.setOnClickListener {
            startActivity(Intent(this, CadastroContatoActivity::class.java))
        }
    }
}
