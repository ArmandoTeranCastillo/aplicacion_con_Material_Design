package com.example.aplicacinconmaterialdesign;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

   EditText etName;
   EditText etPhone;
   EditText etEmail;
   EditText etDescrip;
   EditText etDate;
   Button btNext;
    DatePickerDialog.OnDateSetListener setListener;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       etDate = findViewById(R.id.edit_text_birth_date);

       Calendar calendar = Calendar.getInstance();
       final int year = calendar.get(Calendar.YEAR);
       final int month = calendar.get(Calendar.MONTH);
       final int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

       etDate.setOnClickListener(new View.OnClickListener() {
           @RequiresApi(api = Build.VERSION_CODES.N)
           @Override
           public void onClick(View v) {
               DatePickerDialog datePickerDialog = new DatePickerDialog(
                       MainActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, setListener, year, month, dayOfMonth);
               datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
               datePickerDialog.show();
           }
       });

       setListener = new DatePickerDialog.OnDateSetListener() {
           @Override
           public void onDateSet(DatePicker view, int year, int month, int day) {
               month = month+1;
               String date = day+"/"+month+"/"+year;
               etDate.setText(date);
           }
       };

       btNext= findViewById(R.id.edit_text_button);
       etName= findViewById(R.id.edit_text_input_name);
       etDate= findViewById(R.id.edit_text_birth_date);
       etPhone= findViewById(R.id.edit_text_phone);
       etEmail= findViewById(R.id.edit_text_email);
       etDescrip= findViewById(R.id.edit_text_description);

        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RecibirDatos.class);


                 intent.putExtra("name", etName.getText().toString());
                 intent.putExtra("birthdate",etDate.getText().toString());
                intent.putExtra("phone",etPhone.getText().toString());
                intent.putExtra("email",etEmail.getText().toString());
                intent.putExtra("description",etDescrip.getText().toString());

                startActivity(intent);


            }
        });



    }
}