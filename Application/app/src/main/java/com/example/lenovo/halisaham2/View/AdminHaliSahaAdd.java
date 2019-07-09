package com.example.lenovo.halisaham2.View;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.lenovo.halisaham2.R;

public class AdminHaliSahaAdd extends AppCompatActivity {

    private String[] iller={"İSTANBUL","DENİZLİ"};
    private String[] semtlerIst={"BAĞCILAR","MALTEPE","KADIKÖY","KASIMPAŞA","BAŞAKŞEHİR"};
    private String[] semtlerDenizli={"MERKEZEFENDİ","PAMUKKALE","BAĞBAŞI"};
    private Spinner spinnerIller;
    private Spinner spinnerSemtler;
    private ArrayAdapter<String> dataAdapterForIller;
    private ArrayAdapter<String> dataAdapterForSemtler;
    private String[] cimTipi={"Sentetik","Doğal","Hibrit"};
    private Spinner spinnerCimTipi;
    private ArrayAdapter<String> dataAdapterForCimTipi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_hali_saha_ekle);
        ActionBar act = getSupportActionBar();
        act.hide();

        spinnerIller = findViewById(R.id.ilSec);
        spinnerSemtler = findViewById(R.id.semtSec);
        spinnerCimTipi = findViewById(R.id.cimTipiSec);

        dataAdapterForIller = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, iller);
        dataAdapterForSemtler = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,semtlerIst);
        dataAdapterForCimTipi = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,cimTipi);

        dataAdapterForIller.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterForSemtler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterForCimTipi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerIller.setAdapter(dataAdapterForIller);
        spinnerSemtler.setAdapter(dataAdapterForSemtler);
        spinnerCimTipi.setAdapter(dataAdapterForCimTipi);

        spinnerIller.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                if(parent.getSelectedItem().toString().equals(iller[0]))
                    dataAdapterForSemtler = new ArrayAdapter<String>(AdminHaliSahaAdd.this, android.R.layout.simple_spinner_item,semtlerIst);
                else if(parent.getSelectedItem().toString().equals(iller[1]))
                    dataAdapterForSemtler = new ArrayAdapter<String>(AdminHaliSahaAdd.this, android.R.layout.simple_spinner_item,semtlerDenizli);

                dataAdapterForSemtler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerSemtler.setAdapter(dataAdapterForSemtler);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





    }
}
