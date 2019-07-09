package com.example.lenovo.halisaham2.View;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lenovo.halisaham2.Controller.MySocket;
import com.example.lenovo.halisaham2.Model.UserData;
import com.example.lenovo.halisaham2.R;
import com.github.nkzawa.emitter.Emitter;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
//özkankaşar
    //erhan
    //erhanv2
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MySocket mys=new MySocket();
        mys.mSocket.on("LOGIN",socketLogin);
        mys.mSocket.connect();
        setContentView(R.layout.activity_main);
        ActionBar act = getSupportActionBar();
        act.hide();

        CardView cvGiris = findViewById(R.id.cdGiris);
        final EditText etUserName = findViewById(R.id.etUserName);
        final EditText etPassword = findViewById(R.id.etPass);
        cvGiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserData us = new UserData("",etPassword.getText().toString(),etUserName.getText().toString(),"",0,true);
                us.SendLogin();
            }
        });

        CardView cvUye = findViewById(R.id.cdUyeOl);

        cvUye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerpage = new Intent(getApplicationContext(),NewMember.class);
                startActivity(registerpage);
            }
        });

        ImageView settingsImg = findViewById(R.id.settingsImg);

        settingsImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent settingsPage = new Intent(getApplicationContext(),SettingsPage.class);
                startActivity(settingsPage);
            }
        });
    }
    private Emitter.Listener socketLogin;

    {
        socketLogin = new Emitter.Listener() {
            @Override
            public void call(final Object... args) {
                System.out.println("Login geldi");
                JSONObject data = (JSONObject) args[0];
                try {
                    System.out.println("asd");
                    data.getBoolean("IsLogin");
                    {
                        Intent page;
                        System.out.println("asd0 "+data);
                        if(data.getBoolean("IsAdmin"))
                        {
                            page = new Intent(getApplicationContext(),AdminPage. class);
                            System.out.println("asd1");
                        }
                        else
                        {
                            page = new Intent(getApplicationContext(),UserPage. class);
                        }
                        startActivity(page);
                    }
                }
                catch (JSONException e) {
                    Toast.makeText(getApplicationContext(), "Giriş Başarısız", Toast.LENGTH_LONG).show();
                }
            }
        };
    }
}
