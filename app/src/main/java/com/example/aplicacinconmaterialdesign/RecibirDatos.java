package com.example.aplicacinconmaterialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RecibirDatos extends AppCompatActivity {

    Button btnEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recibir_datos);

        TextView tvname = findViewById(R.id.text_view_name);
        TextView tvdate = findViewById(R.id.text_view_birth_date);
        TextView tvphone = findViewById(R.id.text_view_phone);
        TextView tvemail = findViewById(R.id.text_view_email);
        TextView tvdescrip = findViewById(R.id.text_view_description);

        Bundle parameter = getIntent().getExtras();
        String name = parameter.getString("name");
        String birth_date = parameter.getString("birthdate");
        String phone = parameter.getString("phone");
        String email = parameter.getString("email");
        String description = parameter.getString("description");

        tvname.setText(name);
        tvdate.setText("Fecha de Nacimiento: "+birth_date);
        tvphone.setText("Tel. "+phone);
        tvemail.setText("Email: "+email);
        tvdescrip.setText("Descripción: "+description);

        btnEdit = findViewById(R.id.button_edit_data);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }








}
