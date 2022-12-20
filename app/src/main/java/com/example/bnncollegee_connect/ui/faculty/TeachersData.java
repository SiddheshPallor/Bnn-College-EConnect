package com.example.bnncollegee_connect.ui.faculty;

public class TeachersData {
    private String name, email, post, image, uniKey;

    public TeachersData( ) {
    }

    public TeachersData(String name, String email, String post, String image, String uniKey) {
        this.name = name;
        this.email = email;
        this.post = post;
        this.image = image;
        this.uniKey = uniKey; // yes you/i can remove this no need
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUniKey() {
        return uniKey;
    }

    public void setUniKey(String uniKey) {
        this.uniKey = uniKey;
    }
}