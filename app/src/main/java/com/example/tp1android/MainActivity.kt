package com.example.tp1android

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.room.Room
import com.example.tp1android.Model.Usuario
import com.example.tp1android.database.AppDatabase
import com.example.tp1android.database.AppDatabaseService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val appDatabase = AppDatabaseService.getInstance(applicationContext)

        // back
        var usuarios = appDatabase.usuarioDao().all()
        // Post
        lstUsuarios.adapter = ArrayAdapter(
            applicationContext,
            android.R.layout.simple_list_item_activated_2,
            usuarios
        )
        fabAddUsuario.setOnClickListener {
            startActivity(Intent(this, CadastroContatoActivity::class.java))
        }
    }
    inner class SetupTask: AsyncTask<
            Unit,
            Unit,
            Array<Usuario>
            >(){
        override fun doInBackground(vararg params: Unit?): Array<Usuario> {
            TODO("Not yet implemented")
        }

        override fun onPostExecute(result: Array<Usuario>?) {
            super.onPostExecute(result)
        }

    }
}
