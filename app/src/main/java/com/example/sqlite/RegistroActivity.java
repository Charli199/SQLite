package com.example.sqlite;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sqlite.db.DbContactos;

public class RegistroActivity extends AppCompatActivity {

    EditText txtNombre, txtTelefono, txtemail;
    Button btn_guardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txtNombre = findViewById(R.id.txtNombre);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtemail = findViewById(R.id.txtemail);
        btn_guardar = findViewById(R.id.btnGuarda);

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbContactos dbContactos = new DbContactos(RegistroActivity.this);
                long id = dbContactos.insertarContacto(txtNombre.getText().toString(),txtTelefono.getText().toString(),txtemail.getText().toString());

                if(id > 0){
                    Toast.makeText(RegistroActivity.this, "El Registro se guardó correctamente", Toast.LENGTH_SHORT).show();
                    limpiar();
                }else {
                    Toast.makeText(RegistroActivity.this, "Registro no guardado correctamente. Por favor, inténtalo de nuevo", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void limpiar(){
        txtNombre.setText("");
        txtemail.setText("");
        txtTelefono.setText("");
    }

}