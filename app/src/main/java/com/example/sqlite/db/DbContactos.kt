package com.example.sqlite.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import com.example.sqlite.entidades.Contactos

class DbContactos(context: Context?) : DbHelper(context) {

    private val context: Context? = context

    fun insertarContacto(nombre: String, telefono: String, email: String): Long {
        var id: Long = 0
        try {
            val dbHelper = DbHelper(context)
            val db = dbHelper.writableDatabase

            val values = ContentValues().apply {
                put("nombre", nombre)
                put("telefono", telefono)
                put("email", email)
            }

            id = db.insert(TABLE_CONTACTOS, null, values)
        } catch (ex: Exception) {
            ex.toString()
        }
        return id
    }

    fun mostrarContactos(): ArrayList<Contactos> {
        val dbHelper = DbHelper(context)
        val db = dbHelper.writableDatabase
        val listaContactos = ArrayList<Contactos>()
        var contacto: Contactos? = null
        var cursorContactos: Cursor? = null
        cursorContactos = db.rawQuery("SELECT * FROM " + TABLE_CONTACTOS, null)
        if (cursorContactos.moveToFirst()) {
            do {
                contacto = Contactos()
                contacto.id = cursorContactos.getInt(0)
                contacto.nombre = cursorContactos.getString(1)
                contacto.telefono = cursorContactos.getString(2)
                contacto.email = cursorContactos.getString(3)
                listaContactos.add(contacto)
            } while (cursorContactos.moveToNext())
        }
        cursorContactos.close()
        return listaContactos
    }

}