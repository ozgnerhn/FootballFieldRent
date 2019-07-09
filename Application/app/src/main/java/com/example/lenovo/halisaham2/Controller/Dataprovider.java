package com.example.lenovo.halisaham2.Controller;

public class Dataprovider {

    private int img_res;
    private String h_name,k_name;

    public Dataprovider(int img_res,String h_name,String k_name)
    {
        this.setImg_res(img_res);
        this.setH_name(h_name);
        this.setK_name(k_name);
    }

    public int getImg_res() {
        return img_res;
    }

    public void setImg_res(int img_res) {
        this.img_res = img_res;
    }

    public String getH_name() {
        return h_name;
    }

    public void setH_name(String h_name) {
        this.h_name = h_name;
    }

    public String getK_name() {
        return k_name;
    }

    public void setK_name(String k_name) {
        this.k_name = k_name;
    }
}
