package com.example.challengeemptytext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txtNameEmpty, txtLastNameEmpty, txtPassWord, txtData;
    private Button btnVerify;
    private EditText etName,etLastName,etPassWord;

    private String Name,LastName,Password;

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
    }
    private void getValues(){
        Name=etName.getText().toString();
        LastName=etLastName.getText().toString();
        Password=etPassWord.getText().toString();
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

}