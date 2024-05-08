package com.example.sqlite.adaptadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sqlite.R
import com.example.sqlite.entidades.Contactos


class ListaContactosAdaptador(var listaContactos: ArrayList<Contactos>) :
    RecyclerView.Adapter<ListaContactosAdaptador.ContactoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactoViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.lista_item_contacto, null, false)
        return ContactoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactoViewHolder, position: Int) {
        holder.viewNombre.text = listaContactos[position].nombre
        holder.viewTelefono.text = listaContactos[position].telefono
        holder.viewemail.text = listaContactos[position].email
    }

    override fun getItemCount(): Int {
        return listaContactos.size
    }

    inner class ContactoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var viewNombre: TextView
        var viewTelefono: TextView
        var viewemail: TextView

        init {
            viewNombre = itemView.findViewById(R.id.viewNombre)
            viewTelefono = itemView.findViewById(R.id.viewTelefono)
            viewemail = itemView.findViewById(R.id.viewemail)
        }
    }
}
