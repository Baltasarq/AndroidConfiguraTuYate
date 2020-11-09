package com.example.configuratuyate.ui;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.configuratuyate.R;

public class AcercaDeActivity extends AppCompatActivity {
    public void onCreate(Bundle extras)
    {
        super.onCreate( extras );
        this.setContentView( R.layout.activity_acerca_de );

        final Button BT_VOLVER = this.findViewById( R.id.btVolver );

        BT_VOLVER.setOnClickListener( (v) -> AcercaDeActivity.this.finish() );
    }
}
