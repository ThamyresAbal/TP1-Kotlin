package com.example.tp1android

import android.annotation.SuppressLint
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.room.Room
import com.example.tp1android.Model.Usuario
import com.example.tp1android.Model.UsuarioAndContato
import com.example.tp1android.database.AppDatabase
import com.example.tp1android.database.AppDatabaseService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val appDatabase = AppDatabaseService.getInstance(applicationContext)
        SetupTask().execute()
        fabAddUsuario.setOnClickListener {
            startActivity(Intent(this, CadastroContatoActivity::class.java))
        }
    }

    @SuppressLint("StaticFieldLeak")
    inner class SetupTask: AsyncTask<
            Unit,
            Unit,
            Array<UsuarioAndContato>
            >(){
        override fun onPreExecute() {
            super.onPreExecute()
            Toast.makeText(applicationContext, "Carregando lista", Toast.LENGTH_LONG).show()
        }
        override fun doInBackground(vararg params: Unit?): Array<UsuarioAndContato> {
            val appDatabase = AppDatabaseService.getInstance(applicationContext)
            val usuarios = appDatabase.usuarioDao().allWithAvalicao()
            return  usuarios!!
        }
        override fun onPostExecute(result: Array<UsuarioAndContato>?) {
            super.onPostExecute(result)
            // trocar a listView pela configuração recycle
            lstUsuarios.adapter = ArrayAdapter(
                applicationContext,
                android.R.layout.simple_list_item_activated_2,
                result!!
            )
        }
    }
}
