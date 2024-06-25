package com.example.wmdesigns.gridview_data;

public class Product {
    int imageID;
    String item_name;
    String item_price;

    public Product(int imageID, String item_name, String item_price) {
        this.imageID = imageID;
        this.item_name = item_name;
        this.item_price = item_price;
    }

    public int getImageID() {
        return imageID;
    }

    public String getItem_name() {
        return item_name;
    }

    public String getItem_price() {
        return item_price;
    }
}

