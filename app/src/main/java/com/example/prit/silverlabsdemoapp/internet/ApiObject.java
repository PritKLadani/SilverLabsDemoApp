package com.example.prit.silverlabsdemoapp.internet;

import com.google.gson.annotations.SerializedName;

public class ApiObject {

    @SerializedName("name")
    private String name;

    @SerializedName("height")
    private String height;

    @SerializedName("age")
    private String age;

    @SerializedName("popularity")
    private String popularity;

    @SerializedName("photo")
    private String photo;

    public ApiObject(String name, String height, String age, String popularity, String photo) {
        this.name = name;
        this.height = height;
        this.age = age;
        this.popularity = popularity;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
