package com.example.lenovo.halisaham2.View;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lenovo.halisaham2.Controller.MySocket;
import com.example.lenovo.halisaham2.Model.UserData;
import com.example.lenovo.halisaham2.R;
import com.github.nkzawa.emitter.Emitter;

import org.json.JSONException;
import org.json.JSONObject;

import static java.lang.Integer.parseInt;

public class NewMember extends AppCompatActivity {

    private static final String TAG = "MyActivity";
    MySocket mys=new MySocket();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_member);
        ActionBar act = getSupportActionBar();
        act.hide();

        mys.mSocket.on("USERCREATE",socketCreate);
        mys.mSocket.connect();

        final EditText etAdSoyad = findViewById(R.id.etUserName);
        final EditText etUserName = findViewById(R.id.etUserName);
        final EditText etEmail = findViewById(R.id.etEmail);
        final EditText etPhone = findViewById(R.id.etPhone);
        final EditText etPassword = findViewById(R.id.etPassword);
        CardView cvUyeOl = findViewById(R.id.cvUyeOl);
        final CheckBox isOwner = findViewById(R.id.isOwner);


        cvUyeOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isEmpty(etAdSoyad)&&isEmpty(etEmail)&&isEmpty(etPassword)&&isEmpty(etPhone)&&isEmpty(etUserName)){
                    Toast.makeText(getApplicationContext(),"Tüm bilgilerinizi girmeniz gerekmektedir.", Toast.LENGTH_LONG).show();
                }
                else{
                    int i;
                    System.out.println("geldi");
                    try{
                        i = Integer.parseInt(etPhone.getText().toString());
                    }catch(NumberFormatException ex){ // handle your exception
                        i=5;
                    }

                    UserData ut = new UserData(etAdSoyad.getText().toString(),etPassword.getText().toString(),etUserName.getText().toString(),etEmail.getText().toString(),i,isOwner.isSelected());
                    ut.SendInformations();
                    System.out.println("geldi22222");
                }
            }
        });
    }

    public boolean isEmpty(EditText etText){
        if (etText.getText().toString().trim().length() > 0) {
            return false;
        }
        else {
            return true;
        }
    }
    private Emitter.Listener socketCreate = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            System.out.println("Create geldi");
            JSONObject data=(JSONObject)args[0];
            try {
                data.getBoolean("Create");
                {
                    Intent mainPage = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(mainPage);
                }
            } catch (JSONException e) {
                Toast.makeText(getApplicationContext(),"Kayıt Başarısız", Toast.LENGTH_LONG).show();
            }
        }
    };
}
