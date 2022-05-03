package com.example.challengeemptytext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private TextView txtHello;

    private String nombre, apellido,mail;
    private int phone, code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        inicializarVistas();
        recibirDatosPantallaA();
        mostrarDatos();
    }
    private void inicializarVistas(){
        txtHello=findViewById(R.id.txtHello);
    }
    private void recibirDatosPantallaA(){
        nombre=this.getIntent().getExtras().getString("nombre_persona","");
        apellido=this.getIntent().getExtras().getString("apellido_persona","");
        mail=this.getIntent().getExtras().getString("apellido_persona","");
        phone=this.getIntent().getExtras().getInt("apellido_persona",0);
        code=this.getIntent().getExtras().getInt("apellido_persona",0);
    }
    private void mostrarDatos(){ txtHello.setText("Nombre: "+nombre+"\n"+"Apellido: "+apellido+"\n");
    }
}