package com.example.usuario.faccinatalymerofarenheiltacentigrados;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
    Button convertidor = null;
    EditText cantidad = null;
    TextView resultado = null;
    Spinner spinc1 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        convertidor = (Button) findViewById(R.id.btnTem);
        cantidad = (EditText) findViewById(R.id.cant);
        resultado = (TextView) findViewById(R.id.Result);
        spinc1 = (Spinner) findViewById(R.id.spinner);
        String[] op = {"Selecciona una opcion" ,"ºC a ºF", "ºF  a ºC"};
        ArrayAdapter<String> adapter = new
                ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, op);
        spinc1.setAdapter(adapter);
        convertidor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cantidad.getText().toString().equals("")) {
                    Toast msg = Toast.makeText(getApplication(), "Escriba una cantidad", Toast.LENGTH_SHORT);
                    msg.show();
                } else {
                    Double c = Double.parseDouble(cantidad.getText().toString());
                    Double Result = null;
                    int select = spinc1.getSelectedItemPosition();
                    switch (select) {
                        case 0:
                            Result = 0.0;
                            Toast.makeText(getApplicationContext(), "Selecciona una opcion", Toast.LENGTH_SHORT);

                            break;
                        case 1:
                            Result = 1.8 * c + 32;
                            break;
                        case 2:
                            Result = (c - 32) / 1.8;
                            break;

                    }
                    resultado.setText(Result.toString());
                }

            }
        });
    }
}




