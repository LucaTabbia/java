package com.example.springsocial.model;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
@Entity
public class PostLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="owner", referencedColumnName = "id")
    private User owner;

    @JsonIgnore
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="post", referencedColumnName = "id")
    private Post post;

    public com.example.springsocial.model.User getOwner() {
        return owner;
    }

    public void setOwner(com.example.springsocial.model.User owner) {
        this.owner = owner;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
