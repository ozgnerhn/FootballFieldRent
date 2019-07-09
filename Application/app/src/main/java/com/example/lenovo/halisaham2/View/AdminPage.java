package com.example.lenovo.halisaham2.View;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.lenovo.halisaham2.R;

public class AdminPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);

        ActionBar act = getSupportActionBar();
        act.hide();

        CardView cvAdd = findViewById(R.id.cvAdd);
        CardView cvUpdate = findViewById(R.id.cvUpdate);
        CardView cvShow = findViewById(R.id.cvShow);

        cvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addPage = new Intent(getApplicationContext(),AdminHaliSahaAdd.class);
                startActivity(addPage);
            }
        });

        cvUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent updatePage = new Intent(getApplicationContext(),AdminPageUpdate.class);
                startActivity(updatePage);
            }
        });

        cvShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showPage = new Intent(getApplicationContext(),NewMember.class);
                startActivity(showPage);
            }
        });


    }
}
