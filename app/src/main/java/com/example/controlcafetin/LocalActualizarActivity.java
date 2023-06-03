package com.example.controlcafetin;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LocalActualizarActivity extends Activity {

    ControlBD helper;
    EditText editLocal;
    EditText editNombre;
    EditText editApellido;
    EditText editSexo;
    /** Called when the activity is first created. */
    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_actualizar);
        helper = new ControlBD(this);
        editLocal = (EditText) findViewById(R.id.editLocal);
        editNombre = (EditText) findViewById(R.id.editNombre);
        editApellido = (EditText) findViewById(R.id.editApellido);
        editSexo = (EditText) findViewById(R.id.editSexo);
    }
    public void actualizarLocal(View v) {
        Local local = new Local();
        local.setLocal(editLocal.getText().toString());
        local.setNombre(editNombre.getText().toString());
        local.setApellido(editApellido.getText().toString());
        local.setSexo(editSexo.getText().toString());
        helper.abrir();
        String estado = helper.actualizar(local);
        helper.cerrar();
        Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
    }
    public void limpiarTexto(View v) {
        editLocal.setText("");
        editNombre.setText("");
        editApellido.setText("");
        editSexo.setText("");
    }
}