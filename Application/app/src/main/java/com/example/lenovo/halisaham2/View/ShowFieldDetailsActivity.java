package com.example.lenovo.halisaham2.View;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lenovo.halisaham2.Controller.MySocket;
import com.example.lenovo.halisaham2.R;
import com.github.nkzawa.emitter.Emitter;

import org.json.JSONException;
import org.json.JSONObject;

public class ShowFieldDetailsActivity extends AppCompatActivity {
    Button btn,btn2;
    MySocket mys=new MySocket();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_field_details);
        ActionBar act = getSupportActionBar();
        act.hide();
        //btn =(Button)findViewById(R.id.button4);/////////////////////// show all
        mys.mSocket.on("SHOWFIELDTIME",socketShowFieldTime);
        mys.mSocket.on("MAKEFULLFIELD",socketShowFieldTime);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JSONObject obj =new JSONObject();
                try {
                    obj.put("FieldName","Send Field Name !!!!!");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                mys.mSocket.connect();
                mys.SendSocket("ShowFieldTime",obj);
            }
        });
       // btn2 =(Button)findViewById(R.id.button6);/////////////////////// reserve
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JSONObject obj =new JSONObject();
                try {
                    obj.put("FieldName","Send Field Name !!!!!");
                    obj.put("Time","Send Time !!!!!");
                    obj.put("UserName","Send UserName!!!!!!");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                mys.mSocket.connect();
                mys.SendSocket("ShowFieldTime",obj);
            }
        });
    }

    private Emitter.Listener socketShowFieldTime = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            System.out.println("showFieldTime geldi");
            JSONObject data=(JSONObject)args[0];
            try {
                for (int i=0;i<8;i++)
                {
                    data.getBoolean(Integer.toString(i));
                    {

                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };

    private Emitter.Listener socketMakeFullField = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            System.out.println("makeFullField geldi");
            JSONObject data=(JSONObject)args[0];
            try {
                data.getBoolean("Reserve");
                {

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };
}
