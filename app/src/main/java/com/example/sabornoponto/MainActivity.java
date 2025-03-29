package com.example.sabornoponto;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText edtConsumoTotal, edtCouvertArte, edtDividirConta;
    private TextView txtTaxa, txtContaTotal, txtValorPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtConsumoTotal = findViewById(R.id.edtConsumoTotal);
        edtCouvertArte = findViewById(R.id.edtCouvertArte);
        edtDividirConta = findViewById(R.id.edtDividirConta);
        txtTaxa = findViewById(R.id.txtTaxa);
        txtContaTotal = findViewById(R.id.txtContaTotal);
        txtValorPessoa = findViewById(R.id.txtValorPessoa);

    }

    public void calcular (View v){

        double consumo = 0.0, couvert = 0.0, dividir = 0.0;

        String consumototal = edtConsumoTotal.getText().toString();
        if (!consumototal.isEmpty())
            consumo = Double.parseDouble(consumototal);

        String couvertart = edtCouvertArte.getText().toString();
        if (!couvertart.isEmpty())
            couvert = Double.parseDouble(couvertart);

        String dividirconta = edtDividirConta.getText().toString();
        if (!couvertart.isEmpty())
            dividir = Double.parseDouble(dividirconta);

        double taxa = 0, contatotal = 0, valorpessoa = 0;

        taxa = consumo * 0.1;
        contatotal = consumo + couvert + taxa;
        valorpessoa = contatotal / dividir;

        txtTaxa.setText(String.format("%.2f", taxa));
        txtContaTotal.setText(String.format("%.2f", contatotal));
        txtValorPessoa.setText(String.format("%.2f", valorpessoa));


    }
}