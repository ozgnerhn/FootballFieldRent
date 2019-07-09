package com.example.lenovo.halisaham2.Model;

import com.example.lenovo.halisaham2.Controller.MySocket;

import org.json.JSONException;
import org.json.JSONObject;

public class UserData {
    private String name;
    private String pass;
    private String userId;
    private String mail;
    private int phone;
    private boolean isAdmin ;

    public String Name()
    {
        return name;
    }

    public String Pass()
    {
        return pass;
    }

    public String UserId()
    {
        return userId;
    }

    public String Mail()
    {
        return mail;
    }

    public int Phone()
    {
        return phone;
    }

    public boolean IsAdmin()
    {
        return isAdmin;
    }

    public UserData(String name, String pass, String userId,
                    String mail, Integer phone, Boolean isAdmin)
    {
        this.name=name;
        this.pass=pass;
        this.userId=userId;
        this.mail=mail;
        this.phone=phone;
        this.isAdmin=isAdmin;
    }

    public void SendInformations()
    {

        JSONObject obj=new JSONObject();
        try {
            obj.put("Name",name);
            obj.put("Password",pass);
            obj.put("UserID",userId);
            obj.put("Mail",mail);
            obj.put("Phone",phone);
            obj.put("IsAdmin",isAdmin);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        MySocket mys=new MySocket();
        mys.SendSocket("UserCreate",obj);
        System.out.println("özkankaşar");
    }

    public void SendLogin()
    {
        JSONObject obj=new JSONObject();
        try {
            obj.put("Password",pass);
            obj.put("UserID",userId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        MySocket mys=new MySocket();
        System.out.println("asd");
        mys.SendSocket("Login",obj);
    }
}
