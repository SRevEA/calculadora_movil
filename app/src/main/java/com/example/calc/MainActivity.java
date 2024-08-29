package com.example.calc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn_sumar;
    EditText edt_num1, edt_num2;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //iniciar los componentes
        btn_sumar = findViewById(R.id.btn_sumar);
        edt_num1 = findViewById(R.id.edt_num1);
        edt_num2 = findViewById(R.id.edt_num2);
        spinner = findViewById(R.id.spinner);

        //llenar el spinner con los operadores
        String[] operadores = {"+","-","*","/"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, operadores);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //configurar que pasa al presionar el boton

        btn_sumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text1 = edt_num1.getText().toString();
                String text2 = edt_num2.getText().toString();

                if (text1.equals("") || text2.equals("")) {
                    Toast.makeText(MainActivity.this, "Están vacíos", Toast.LENGTH_LONG).show();
                } else {
                    double num1 = Double.parseDouble(text1);
                    double num2 = Double.parseDouble(text2);
                    double resultado = 0;

                    // Obtener el operador seleccionado
                    String operador = spinner.getSelectedItem().toString();

                    // Realizar la operación según el operador seleccionado
                    switch (operador) {
                        case "+":
                            resultado = num1 + num2;
                            break;
                        case "-":
                            resultado = num1 - num2;
                            break;
                        case "*":
                            resultado = num1 * num2;
                            break;
                        case "/":
                            if (num2 != 0) {
                                resultado = num1 / num2;
                            } else {
                                Toast.makeText(MainActivity.this, "No se puede dividir por 0", Toast.LENGTH_LONG).show();
                                return;
                            }
                            break;
                    }
                    // Mostrar el resultado en una nueva vista
                    //crear un intent para ir a la otra vista(Intent: Se utiliza para enviar datos desde MainActivity a ResultadoActivity.)
                    Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);

                    //pasar el resultado( El método putExtra se usa para pasar el resultado.)
                    intent.putExtra("resultado", String.valueOf(resultado));
                    //pasar a la vista de resultado
                    startActivity(intent);
                }

            }
        });
    }
}
