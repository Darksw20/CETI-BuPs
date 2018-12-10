package com.dk.ricardo.eeas2.utilidades.Items;

public class AssItemData
{
    private String name;
    private String cum;

    private int imageUrl;


    public AssItemData(String name, String cum, int imageUrl){
        this.name = name;
        this.cum = cum;
        this.imageUrl = imageUrl;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCum() {
        return cum;
    }

    public void setCum(String cum) {
        this.cum = cum;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }
}
