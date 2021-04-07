package com.example.springsocial.model;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Comment {
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="owner", referencedColumnName = "id")
    private User Owner;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="post", referencedColumnName = "id")
    private Post post;
    private String text;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public com.example.springsocial.model.User getOwner() {
        return Owner;
    }

    public void setOwner(com.example.springsocial.model.User owner) {
        Owner = owner;
    }

    public Post getPhoto() {
        return post;
    }

    public void setPhoto(Post post) {
        this.post = post;
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
