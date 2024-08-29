package com.example.calc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        // Obtener el TextView
        TextView txtResultado = findViewById(R.id.txt_resultado);

        // Obtener el resultado enviado desde MainActivity
        Intent intent = getIntent();
        String resultado = intent.getStringExtra("resultado");

        // Mostrar el resultado en el TextView
        txtResultado.setText("El resultado es: " + resultado);
    }
}
