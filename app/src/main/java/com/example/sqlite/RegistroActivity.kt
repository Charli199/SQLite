package com.example.sqlite

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sqlite.db.DbContactos

class RegistroActivity : AppCompatActivity() {

    private lateinit var txtNombre: EditText
    private lateinit var txtTelefono: EditText
    private lateinit var txtemail: EditText
    private lateinit var btn_guardar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        txtNombre = findViewById(R.id.txtNombre)
        txtTelefono = findViewById(R.id.txtTelefono)
        txtemail = findViewById(R.id.txtemail)
        btn_guardar = findViewById(R.id.btnGuarda)

        btn_guardar.setOnClickListener {
            val dbContactos = DbContactos(this@RegistroActivity)
            val id = dbContactos.insertarContacto(txtNombre.text.toString(), txtTelefono.text.toString(), txtemail.text.toString())

            if (id > 0) {
                Toast.makeText(this@RegistroActivity, "El Registro se guardó correctamente", Toast.LENGTH_SHORT).show()
                limpiar()
            } else {
                Toast.makeText(this@RegistroActivity, "Registro no guardado correctamente. Por favor, inténtalo de nuevo", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun limpiar() {
        txtNombre.text.clear()
        txtemail.text.clear()
        txtTelefono.text.clear()
    }
}