package com.example.tp1android

import android.annotation.SuppressLint
import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tp1android.Model.Usuario
import com.example.tp1android.Model.UsuarioAndContato
import com.example.tp1android.adapter.ContatoAdapter
import com.example.tp1android.database.AppDatabaseService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.contatos_recycle.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       //val appDatabase = AppDatabaseService.getInstance(applicationContext)
        SetupTask().execute()
        fabAddUsuario.setOnClickListener {
            startActivity(Intent(this, CadastroContatoActivity::class.java))
        }

        /*btnEditar.setOnClickListener {
            //chamar uma activity para editar o usuario
            //OperacaoUpdate().execute() vai ficar dentro dessa activity
        }

        btnExcluir.setOnClickListener {
            OperacaoDeleteTask().execute()
            onRestart()
        }*/
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
            return  usuarios
        }
        override fun onPostExecute(result: Array<UsuarioAndContato>?) {
            super.onPostExecute(result)
            var contatoAdapter = ContatoAdapter(result!!)
            rcwContatos.adapter = contatoAdapter
            rcwContatos.layoutManager = LinearLayoutManager(applicationContext)
            // trocar a listView pela configuração recycle
            /*lstUsuarios.adapter = ArrayAdapter(
                applicationContext,
                android.R.layout.simple_list_item_activated_2,
                result!!
            )*/
        }
    }

    /*inner class OperacaoDeleteTask : AsyncTask<Usuario, Unit, Unit>(){
        override fun doInBackground(vararg params: Usuario?) {
            val appDatabase = AppDatabaseService.getInstance(applicationContext)
            appDatabase.usuarioDao().delete()
        }

        override fun onPostExecute(result: Unit?) {
            super.onPostExecute(result)
            Toast.makeText(applicationContext, "Contato apaado com sucesso",
                Toast.LENGTH_SHORT).show()
        }
    }*/

    /*inner class OperacaoUpdate : AsyncTask<Usuario, Unit, Unit>(){

        override fun doInBackground(vararg params: Usuario?) {
            val appDatabase = AppDatabaseService.getInstance(applicationContext)
            appDatabase.usuarioDao().update()
        }

        override fun onPostExecute(result: Unit?) {
            super.onPostExecute(result)

            Toast.makeText(applicationContext, "Contato atualizado com sucesso",
                Toast.LENGTH_SHORT).show()
        }

    }*/
}
