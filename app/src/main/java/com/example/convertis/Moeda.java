package com.example.convertis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Moeda extends AppCompatActivity  implements View.OnClickListener, AdapterView.OnItemSelectedListener {


    private Spinner spnMoeda1;
    private Spinner spnMoeda2;
    private Button btnConverte;
    private EditText edtMoedaatual;
    private EditText edtMoedanova;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moeda);


        spnMoeda1 = (Spinner) findViewById(R.id.spn1);
        spnMoeda2 = (Spinner) findViewById(R.id.spn2);
        btnConverte = (Button) findViewById(R.id.btn1);
        edtMoedaatual = (EditText) findViewById(R.id.edt1);
        edtMoedanova = (EditText) findViewById(R.id.edt2);

        spnMoeda1.setOnItemSelectedListener(this);
        spnMoeda2.setOnItemSelectedListener(this);
        btnConverte.setOnClickListener(this);

        carregarListaMoedas();

    }

    // CARREGAR lista de moedas do RESOURCE
    private void carregarListaMoedas() {
        ArrayAdapter<CharSequence> adp =
                ArrayAdapter.createFromResource(this,
                        R.array.listas_moedas, android.R.layout.simple_spinner_item);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnMoeda1.setAdapter(adp);
        spnMoeda2.setAdapter(adp);
    }


    @Override
    public void onClick(View view) {
        double moeda, r;
        moeda = Double.parseDouble(edtMoedaatual.getText().toString());
        if ("Real".equals(spnMoeda1.getSelectedItem()) && "Dollar americano".equals(spnMoeda2.getSelectedItem()) )
        {
            r = moeda * 5.00;
            edtMoedanova.setText(String.valueOf(r));
        } else if ("Dollar americano".equals(spnMoeda1.getSelectedItem()) && "Real".equals(spnMoeda2.getSelectedItem()) ) {
            r = moeda / 5.00;
            edtMoedanova.setText(String.valueOf(r));
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}