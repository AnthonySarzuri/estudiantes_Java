package com.example.challengeemptytext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class HomeActivity extends AppCompatActivity {
    private TextView txtHello;
    private Button btnCalculate;
    private Estudiante estudiante;

    private String nombre, apellido,mail;
    private int phone, code;

    private Spinner spData;
    private ArrayList<String> opciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        inicializarVistas();
        recibirDatosPantallaA();
        mostrarDatos();
        popularSpinner();
        btnCalculate.setOnClickListener(view ->{
            getSpinnerValues();
        });
    }
    private void inicializarVistas(){

        txtHello=findViewById(R.id.txtHello);
        spData=findViewById(R.id.spData);
        btnCalculate=findViewById(R.id.btnCalculate);

    }
    private void recibirDatosPantallaA(){
        /*nombre=this.getIntent().getExtras().getString("nombre_persona","");
        apellido=this.getIntent().getExtras().getString("apellido_persona","");
        mail=this.getIntent().getExtras().getString("apellido_persona","");
        phone=this.getIntent().getExtras().getInt("apellido_persona",0);
        code=this.getIntent().getExtras().getInt("apellido_persona",0);*/
        estudiante = (Estudiante) this.getIntent().getExtras().getSerializable("objeto_estudiante");
    }
    private void mostrarDatos(){
        //txtHello.setText("Nombre: "+nombre+"\n"+"Apellido: "+apellido+"\n");
        txtHello.setText("Nombre: "+estudiante.getNombre()+
                "\nApellido: "+estudiante.getApellido()+
                "\nCelular: "+estudiante.getCelular()+
                "\nEmail: "+estudiante.getEmail()+
                "\nCodigo: "+estudiante.getCodigoEstudiante()+
                "\n¿Es estudiante?: "+estudiante.isEstudiante());
    }

    private void getSpinnerValues(){
        //Informacion que se puede obtener del elemnto seleccionado en el spinner
        String value=(String) spData.getSelectedItem();
        int position= spData.getSelectedItemPosition();
        switch(value){
            case "Notas":
                //Procedimiento
                break;
            case "Faltas":
                //Procedimiento
                break;
        }

    }

    private void popularSpinner(){
        opciones = new ArrayList<>(Arrays.asList("Notas","Faltas"));
        opciones.add("Opcion");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,opciones);
        spData.setAdapter(adapter);
    }
}