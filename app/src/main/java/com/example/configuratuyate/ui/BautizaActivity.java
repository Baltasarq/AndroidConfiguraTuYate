package com.example.configuratuyate.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.configuratuyate.R;

public class BautizaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bautiza);

        final Button BT_CANCELAR = this.findViewById( R.id.btCancelar );
        final Button BT_GUARDAR = this.findViewById( R.id.btGuardar );

        BT_CANCELAR.setOnClickListener( (v) -> BautizaActivity.this.cancela() );
        BT_GUARDAR.setOnClickListener( (v) -> BautizaActivity.this.guarda() );
    }

    private void cancela()
    {
        this.setResult( Activity.RESULT_CANCELED );
        this.finish();
    }

    private void guarda()
    {
        final EditText ED_NOMBRE = this.findViewById( R.id.edNombre );
        final Intent DATOS_RETORNO = new Intent();

        DATOS_RETORNO.putExtra( "nombre", ED_NOMBRE.getText().toString() );

        this.setResult( Activity.RESULT_OK, DATOS_RETORNO );
        this.finish();
    }
}
