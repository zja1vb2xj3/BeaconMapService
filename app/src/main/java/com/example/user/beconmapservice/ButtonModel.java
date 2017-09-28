package com.example.user.beconmapservice;

import android.graphics.Bitmap;

/**
 * Created by user on 2017-09-28.
 */

public class ButtonModel {
    private String title;
    private String content;


    public ButtonModel(String title, String content){
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
