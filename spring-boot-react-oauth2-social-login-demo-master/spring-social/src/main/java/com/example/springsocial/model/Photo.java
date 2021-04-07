package com.example.springsocial.model;

import javax.persistence.*;

@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="owner", referencedColumnName = "id")
    private User owner;

    @Lob
    private byte[] picture;

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public com.example.springsocial.model.User getOwner() {
        return owner;
    }

    public void setOwner(com.example.springsocial.model.User owner) { this.owner = owner; }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }
}
