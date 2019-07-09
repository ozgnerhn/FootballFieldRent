package com.example.lenovo.halisaham2.View;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lenovo.halisaham2.R;

public class AdminPageUpdate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page_update);
        ActionBar act = getSupportActionBar();
        act.hide();
    }
}
