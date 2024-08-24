package com.upb.myrestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class CalificarActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calificar);

        ratingBar = findViewById(R.id.ratingBar);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(v -> {
            float rating = ratingBar.getRating();
            // Aquí puedes manejar la calificación (enviar a un servidor, guardar localmente, etc.)
            Toast.makeText(CalificarActivity.this, "Calificación: " + rating, Toast.LENGTH_SHORT).show();
        });
    }
}