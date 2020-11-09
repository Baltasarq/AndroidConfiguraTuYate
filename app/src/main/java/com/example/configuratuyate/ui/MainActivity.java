package com.example.configuratuyate.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.configuratuyate.R;
import com.example.configuratuyate.core.Yate;

public class MainActivity extends AppCompatActivity {
    public static final int REQ_BAUTIZA = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button BT_CONFIGURA = this.findViewById( R.id.btConfigura );
        final Button BT_BAUTIZA = this.findViewById( R.id.btBautiza );
        final Button BT_ACERCA_DE = this.findViewById( R.id.btAcercaDe );

        BT_BAUTIZA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.bautizaConActivity();
            }
        });

        BT_CONFIGURA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.configurador();
            }
        });

        BT_ACERCA_DE.setOnClickListener( (v) -> {
            MainActivity.this.muestraAcercaDe();
        });

        this.yate = new Yate();
        this.actualiza();
    }

    private void configurador()
    {
        AlertDialog.Builder dlg = new AlertDialog.Builder( this );

        dlg.setMultiChoiceItems(
                new String[]{
                        "Velas",
                        "Motor",
                        "Camperización",
                        "Lancha",
                        "Calefacción",
                        "Radar"
                },
                this.yate.getOpciones(),
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which,
                                        boolean isChecked)
                    {
                        if ( which == 0 ) {
                            MainActivity.this.yate.setVelas( isChecked );
                        }
                        else
                        if ( which == 1 ) {
                            MainActivity.this.yate.setMotor( isChecked );
                        }
                        else
                        if ( which == 2 ) {
                            MainActivity.this.yate.setCamperizacion( isChecked );
                        }
                        else
                        if ( which == 3 ) {
                            MainActivity.this.yate.setLancha( isChecked );
                        }
                        else
                        if ( which == 4 ) {
                            MainActivity.this.yate.setCalefaccion( isChecked );
                        }
                        else
                        if ( which == 5 ) {
                            MainActivity.this.yate.setRadar( isChecked );
                        }
                    }
                }
        );

        dlg.setPositiveButton("Finalizar",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.this.actualiza();
                    }
                });

        dlg.create().show();
    }

    private void actualiza()
    {
        final TextView txtYate = this.findViewById( R.id.txtYate );

        txtYate.setText( this.yate.toString() );
    }

    private void bautiza()
    {
        final EditText ED_NOMBRE = new EditText( this );
        AlertDialog.Builder dlg = new AlertDialog.Builder( this );

        dlg.setMessage( "Nombre del yate:" );
        dlg.setView( ED_NOMBRE );
        dlg.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.this.yate.setNombre(
                                ED_NOMBRE.getText().toString() );
                        MainActivity.this.actualiza();
                    }
                }
        );

        dlg.create().show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult( requestCode, resultCode, data );

        if ( resultCode == Activity.RESULT_OK ) {
            switch( requestCode ) {
                case REQ_BAUTIZA:
                    if ( data != null ) {
                        this.yate.setNombre( data.getExtras().getString( "nombre" ) );
                        this.actualiza();
                    } else {
                        Toast.makeText( this,
                                    "ERROR: no hay datos de retorno",
                                        Toast.LENGTH_LONG );
                    }
                    break;
            }
        }

        return;
    }

    private void bautizaConActivity()
    {
        final Intent DATOS_ENTRADA = new Intent( this, BautizaActivity.class );

        DATOS_ENTRADA.putExtra( "nombre", this.yate.getNombre() );

        this.startActivityForResult(
                DATOS_ENTRADA,
                REQ_BAUTIZA
        );
    }

    private void configuradorConActivity()
    {

    }

    private void muestraAcercaDe()
    {
        this.startActivity(
                new Intent( this, AcercaDeActivity.class ) );
    }

    private Yate yate;
}
