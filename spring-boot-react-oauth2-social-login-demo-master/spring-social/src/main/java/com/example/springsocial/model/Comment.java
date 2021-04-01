package com.example.springsocial.model;

import java.util.Date;

public class Comment {
    private User Owner;
    private Photo photo;
    private String text;
    private Date date;
    private Long id;

    public com.example.springsocial.model.User getOwner() {
        return Owner;
    }

    public void setOwner(com.example.springsocial.model.User owner) {
        Owner = owner;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
