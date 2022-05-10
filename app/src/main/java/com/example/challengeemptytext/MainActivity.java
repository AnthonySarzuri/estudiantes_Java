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
    private Estudiante student;

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
            obtenerInformacion();

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
        Mail=etMail.getText().toString();
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
        Cuando se quiere navegar de una pantalla A a otra pantalla B
        se debe hacer uso del componenete llamado INTENT
        el mismo se comporta como el criterio de querer responder
        a una intención o deseo en términos simples.
        Si la intención se puede resolver pues logramos el objetivo
        y un método en específico lanzará la siguiente pantalla.
        Para configurar un INTENT en este sentido, se debe crear
        una instancia de la clase Intent y en su constructor
        indicarle de donde a donde quieren ir, pero deben ser referenciadas
        en conceptos del contexto de la clase que representa a esa pantalla
        */
        Intent intencion = new Intent(this, HomeActivity.class);
        //Paso 1: mandar datos primitivos
        /*
        Quieren pasar datos a otra pantalla
        Usar el Intent
        en el Intent -> configurar un archivo temporal
        archivo temporal -> guarda registro en un formato.
        ese formato se conoce como: CLAVE(key) -> VALOR(value)
        ejemplo: .putExtra("Llave"(clave), valor(primitiva))
        El archivo pueden entenderlo que se llama extras
        y cada registro que crean es un EXTRA
        La llave debe ser una cadena string única
         */
        /*nombre = etNombre.getText().toString();
        apellido = etApellido.getText().toString();
        celular = etCelular.getText().toString();
        email = etEmail.getText().toString();
        codigo = etCodigo.getText().toString();
        esEstudiante = swEstudiante.isChecked();
        intencion.putExtra("nombre_persona",nombre);
        intencion.putExtra("apellido_persona",apellido);
        intencion.putExtra("celular_persona",celular);
        intencion.putExtra("email_persona",email);
        intencion.putExtra("codigo_persona",codigo);
        intencion.putExtra("esEstudiante_persona",esEstudiante);*/
        //Paso alternativo: pasar datos por objeto serializado
        //Objeto Bundle entiendace como si fuera un archivo temporal
        Bundle archivoTemporal = new Bundle();
        archivoTemporal.putSerializable("objeto_estudiante",student);
        intencion.putExtras(archivoTemporal);
        startActivity(intencion);
    }
    private void obtenerInformacion(){
            /*nombre = etNombre.getText().toString();
            apellido = etApellido.getText().toString();
            String email = etApellido.getText().toString();
            int celular = Integer.parseInt(etCelular.getText().toString());
            int codigo = Integer.parseInt(etCodigo.getText().toString());
            //En el switch o checkbox ustedes quieren obtener el valor
            //cuando el elemento ha sdo marcado y eso es un atributo
            //llamdo checked
            //en valores booleanos el get cambia por is por temas de lenguaje
            boolean esEstudiante = swEstudiante.isChecked();*/
            student = new Estudiante(etName.getText().toString(),
                    etLastName.getText().toString(),
                    etPassWord.getText().toString(),
                    Integer.parseInt(etPhone.getText().toString()),
                    etMail.getText().toString(),
                    swStudent.isChecked()
            );
            if (swStudent.isChecked()){
                student.setCodigoEstudiante(Integer.parseInt(etCode.getText().toString()));
            }
            //tvResultado.setText(estudiante.toString());
            pasarOtraPantalla();

    }
}