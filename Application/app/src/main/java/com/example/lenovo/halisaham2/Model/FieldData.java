package com.example.lenovo.halisaham2.Model;

import com.example.lenovo.halisaham2.Controller.MySocket;

import org.json.JSONException;
import org.json.JSONObject;

public class FieldData {
    private String name;
    private String city;
    private String district;
    private String street;
    private int since;
    private int price;
    private String grassType;

    public String Name()
    {
        return name;
    }

    public String City()
    {
        return city;
    }

    public String District()
    {
        return district;
    }

    public String Street()
    {
        return street;
    }

    public int Since()
    {
        return since;
    }

    public int Price()
    {
        return price;
    }

    public String GrassType()
    {
        return grassType;
    }

    public FieldData(String name, String city, String district, String street,
                     int since, int price, String grassType)
    {
        this.name=name;
        this.city=city;
        this.district=district;
        this.street=street;
        this.since=since;
        this.price=price;
        this.grassType=grassType;
    }

    public void SendInformations()
    {
        JSONObject obj=new JSONObject();
        try {
            obj.put("Name",name);
            obj.put("City",city);
            obj.put("District",district);
            obj.put("Street",street);
            obj.put("Since",since);
            obj.put("Price",price);
            obj.put("GrassType",grassType);
            obj.put("Create",true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        MySocket mys=new MySocket();
        mys.SendSocket("FieldCreate",obj);
    }
}
