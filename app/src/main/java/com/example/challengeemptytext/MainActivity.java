package com.example.challengeemptytext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView txtNameEmpty, txtLastNameEmpty, txtPassWord, txtData;
    private Button btnVerify;
    private EditText etName,etLastName,etPassWord,etMail,etPhone,etCode;
    private Switch swStudent;
    private boolean studiante;
    private String Name,LastName,Password, Mail,code;
    private int phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();

        btnVerify.setOnClickListener((view -> {

            getValues();
            if(etName.getText().toString().trim().equalsIgnoreCase("")&&etLastName.getText().toString().trim().equalsIgnoreCase("")&&etPassWord.getText().toString().trim().equalsIgnoreCase("")){
                showTextDataError();
            }
            else{
                if (etName.getText().toString().trim().equalsIgnoreCase("")){
                    showErrorName();
                    txtData.setText("");
                }

                else{showTextData();}


                if (etLastName.getText().toString().trim().equalsIgnoreCase("")){
                    showErrorLastName();
                    txtData.setText("");
                }

                else{showTextData();}

                if (etPassWord.getText().toString().trim().equalsIgnoreCase("")){
                    showErrorPassword();
                    txtData.setText("");
                }

                else{showTextData();}
            }

            pasarOtraPantalla();

        }));
    }

    private void initializeViews(){
        txtData=findViewById(R.id.txtData);
        txtNameEmpty=findViewById(R.id.txtNameEmpty);
        txtLastNameEmpty=findViewById(R.id.txtLastNameEmpty);
        txtPassWord=findViewById(R.id.txtPassWord);
        btnVerify=findViewById(R.id.btnVerifyData);
        etName=findViewById(R.id.etName);
        etLastName=findViewById(R.id.etLastName);
        etPassWord=findViewById(R.id.etPassWord);
        etMail=findViewById(R.id.etMail);
        etPhone=findViewById(R.id.etPhone);
        etCode=findViewById(R.id.etCode);
        swStudent=findViewById(R.id.swStudent);
    }
    private void getValues(){
        Name=etName.getText().toString();
        LastName=etLastName.getText().toString();
        Password=etPassWord.getText().toString();
        studiante=swStudent.isChecked();
    }



    private void showErrorName(){
        txtNameEmpty.setText("Este campo no puede estar vacio");
    }
    private void showErrorLastName(){
        txtLastNameEmpty.setText("Este campo no puede estar vacio");
    }
    private void showErrorPassword(){
        txtPassWord.setText("Este campo no puede estar vacio");
    }
    private void showTextData(){
        txtData.setText("Bienvenido: "+this.Name+" "+LastName);
    }
    private void showTextDataError(){
        txtData.setText("Todos los campos estan vacìos");
    }

    private void pasarOtraPantalla(){
        /*
         Para pasar datos a otra pantalla
         Usar el intent
         en el intent -> configurar el archivo temporal -> guarda registro en un formato. ese formaro se conoce como: CLAVE(key) -> VALOR(value)
         El archivo pueden entenderlo que se llama EXTRAS y cada registro que crean se es un EXTRA
        */
        Intent intencion = new Intent(this, HomeActivity.class);
        //las llaves no se pueden repetir
        intencion.putExtra("nombre_persona", Name);
        intencion.putExtra("apellido_persona", LastName);
        intencion.putExtra("mail_persona", Mail);
        intencion.putExtra("telefono_persona", phone);
        intencion.putExtra("codigo_persona", code);
        startActivity(intencion);
    }
}