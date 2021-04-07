package com.example.springsocial.payload;

import com.example.springsocial.model.Post;

public class PostResponse extends Post {
    private Long idPhoto;
    public PostResponse(Post post) {
        setComments(post.getComments());
        setDate(post.getDate());
        setDescription(post.getDescription());
        setId(post.getId());
        setOwner(post.getOwner());
        setPostLikes(post.getPostLikes());
        setPhoto(post.getPhoto());
        idPhoto= post.getPhoto().getId();
    }
}
