package com.example.wmdesigns.listview_data;

public class WMCollection {
    private int imageID;
    private String title;

    public WMCollection(int imageID, String title) {
        this.imageID = imageID;
        this.title = title;
    }

    public int getImageID() {
        return imageID;
    }

    public String getTitle() {
        return title;
    }
}
