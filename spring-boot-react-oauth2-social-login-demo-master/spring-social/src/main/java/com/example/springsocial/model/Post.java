package com.example.springsocial.model;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="owner", referencedColumnName = "id")
    private User owner;

    @JsonIgnore
    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="photo", referencedColumnName = "id")
    private Photo photo;

    private String description;
    @OneToMany(mappedBy = "post", cascade = ALL)
    private List<PostLike> postLikes;
    @OneToMany(mappedBy = "post", cascade = ALL)
    private List<Comment> comments;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Photo getPhoto() { return photo; }

    public void setPhoto(Photo photo) { this.photo = photo; }

    public Date getDate() { return date; }

    public void setDate(Date date) {this.date = date; }

    public com.example.springsocial.model.User getOwner() {
        return owner;
    }

    public void setOwner(com.example.springsocial.model.User owner) { this.owner = owner; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public List<PostLike> getPostLikes() { return postLikes; }

    public void setPostLikes(List<PostLike> postLikes) { this.postLikes = postLikes; }

    public List<Comment> getComments() { return comments; }

    public void setComments(List<Comment> comments) { this.comments = comments; }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }
}
