package com.example.tp1android

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.tp1android.Model.Usuario
import com.example.tp1android.database.AppDatabase
import kotlinx.android.synthetic.main.activity_cadastro_contato.*


class CadastroContatoActivity : AppCompatActivity() {

    val PICK_IMAGE = 1234

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_contato)

        FABNovaImagem.setOnClickListener {
            val i = Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.INTERNAL_CONTENT_URI
            )
            startActivityForResult(Intent.createChooser(i, "Selecione uma imagem"), PICK_IMAGE)
        }

        btnCadastrar.setOnClickListener {
            var nome = edtNome.text.toString()
            var telefone = edtTelefone.text.toString()
            var foto = imageView.toString()

            var usuario = Usuario(nome, telefone,foto)

            var appDatabase = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java,
                "appDatabase.sql"
            )
                .allowMainThreadQueries()
                .build()

            appDatabase.usuarioDao().store(usuario)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode != Activity.RESULT_CANCELED) {
            if (requestCode == PICK_IMAGE) {
                val imagemSelecionada: Uri? = data?.data
                val foto = findViewById(R.id.imageView) as ImageView
                val bitmap = BitmapFactory.decodeFile(imagemSelecionada.toString())
              //  val bitmapReduzido = Bitmap.createScaledBitmap(bitmap, 1080, 1000, true)
                foto.setImageBitmap(bitmap)
               // foto.scaleType = ImageView.ScaleType.FIT_XY

            }
        }
    }
}
