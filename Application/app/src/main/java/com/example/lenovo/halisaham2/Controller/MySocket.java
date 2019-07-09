package com.example.lenovo.halisaham2.Controller;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import org.json.JSONObject;

import java.net.URISyntaxException;

public class MySocket {

    public Socket mSocket;
    {
        try {
            mSocket = IO.socket("http://192.168.0.32:8000");
        }catch (URISyntaxException ignored){

        }
    }
    public void SendSocket(String event , JSONObject data)
    {
        mSocket.connect();
        mSocket.emit(event,data);
        System.out.println("emitrrrrrtt");
    }
}
