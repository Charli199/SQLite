package com.example.sqlite

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sqlite.adaptadores.ListaContactosAdaptador
import com.example.sqlite.db.DbContactos
import com.example.sqlite.entidades.Contactos

class MainActivity : AppCompatActivity() {

    private lateinit var listaContactos: RecyclerView
    private lateinit var ListaArrayContactos: ArrayList<Contactos>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listaContactos = findViewById(R.id.listaContactos)
        listaContactos.setLayoutManager(LinearLayoutManager(this))

        val dbContactos = DbContactos(this)
        ListaArrayContactos = ArrayList()

        val adapter = ListaContactosAdaptador(dbContactos.mostrarContactos())
        listaContactos.setAdapter(adapter)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menuNuevo -> {
                nuevoRegistro()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun nuevoRegistro() {
        val intent = Intent(this, RegistroActivity::class.java)
        startActivity(intent)
    }

}
