package com.devcamp.yapp.db.Dto;

/**
 * Created by Beomjun on 2016-02-27.
 */
public class MainTableDto extends TableDto{
    String title;
    int image_resource;

    public void setTitle(String title){this.title = title;}
    public String getTitle() {
        return title;
    }

    public void setImage_resource(int image_resource){
        this.image_resource= image_resource;
    }
    public int getImage_resource(){return image_resource;}
}
