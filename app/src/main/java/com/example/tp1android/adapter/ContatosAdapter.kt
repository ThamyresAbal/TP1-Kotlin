package com.example.tp1android.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tp1android.Model.Usuario
import com.example.tp1android.R
import kotlinx.android.synthetic.main.contatosrecycle.view.*

class ContatosAdapter(
    var contatos: List<Usuario>
) : RecyclerView.Adapter<ContatosAdapter.ContatoViewHolder>(){

    class ContatoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageView = view.imgContato
        var txtNomeContato = view.txtVwNome
        var txtTelefoneContato = view.txtVwTelefone
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatoViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.contatosrecycle,
                parent,
                false
            )

        return ContatoViewHolder(view)
    }

    override fun getItemCount(): Int = contatos.size

    override fun onBindViewHolder(holder: ContatoViewHolder, position: Int) {

    }
}