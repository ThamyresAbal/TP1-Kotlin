package com.example.tp1android

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.tp1android.Model.Usuario
import com.example.tp1android.database.AppDatabase
import com.example.tp1android.database.AppDatabaseService
import kotlinx.android.synthetic.main.activity_cadastro_contato.*


class CadastroContatoActivity : AppCompatActivity() {

    val PICK_IMAGE = 1234

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_contato)

        FABNovaImagem.setOnClickListener {
            val i = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(Intent.createChooser(i, "Selecione uma imagem"), PICK_IMAGE)
        }

        btnCadastrar.setOnClickListener {
            var nomeSobrenome = edtNome.text.toString()
            var telefone = edtTelefone.text.toString()
            var foto = imageView.toString()

            var usuario = Usuario(nomeSobrenome, telefone,foto)

            val appDatabase = AppDatabaseService.getInstance(applicationContext)

            appDatabase.usuarioDao().store(usuario)

            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != Activity.RESULT_CANCELED) {
            if (requestCode == PICK_IMAGE) {
                val imagemURI = ImageDecoder.createSource(this.contentResolver, data!!.data!!)
                val imagemSelecionada = ImageDecoder.decodeBitmap(imagemURI)
                val foto = imageView
                foto.setImageBitmap(imagemSelecionada)
            }
        }
    }
}
