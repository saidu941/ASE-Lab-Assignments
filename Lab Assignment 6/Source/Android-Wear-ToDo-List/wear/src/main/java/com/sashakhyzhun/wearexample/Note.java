package com.sashakhyzhun.wearexample;

/**
 * Created by Ramgopal on 2/5/2017.
 */
public class Note {

    private String title = "";
    private String id = "";

    Note(String title, String id) {
        this.title = title;
        this.id = id;
    }

    String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
