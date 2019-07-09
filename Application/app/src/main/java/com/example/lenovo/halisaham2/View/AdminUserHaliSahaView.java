package com.example.lenovo.halisaham2.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lenovo.halisaham2.Controller.Dataprovider;
import com.example.lenovo.halisaham2.Controller.RecyclerAdapter;
import com.example.lenovo.halisaham2.R;

import java.util.ArrayList;

public class AdminUserHaliSahaView extends AppCompatActivity {

    android.support.v7.widget.RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    String [] H_name,K_name;
    int[] Img_res={com.example.lenovo.halisaham2.R.drawable.noimage, R.drawable.noimage,R.drawable.noimage,R.drawable.noimage,
    R.drawable.noimage,R.drawable.noimage,R.drawable.noimage,R.drawable.noimage,R.drawable.noimage,
    R.drawable.noimage};

    ArrayList<Dataprovider> arrayList = new ArrayList<Dataprovider>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_user_hali_saha_view);
        recyclerView=(RecyclerView)findViewById(R.id.recycle_view);
        H_name=getResources().getStringArray(R.array.halisaha_names);
        K_name=getResources().getStringArray(R.array.konum_names);
        int i=0;
        for (String name: H_name)
        {
            Dataprovider dataprovider=new Dataprovider(Img_res[i],name,K_name[i]);
            arrayList.add(dataprovider);
            i++;
        }
        adapter = new RecyclerAdapter(arrayList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
