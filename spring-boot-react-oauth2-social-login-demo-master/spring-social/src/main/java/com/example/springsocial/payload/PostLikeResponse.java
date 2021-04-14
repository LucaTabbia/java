package com.example.springsocial.payload;

import com.example.springsocial.model.PostLike;

public class PostLikeResponse extends PostLike {
    private Long idPost;
    public PostLikeResponse(PostLike postLike) {
        setId(postLike.getId());
        setOwner(postLike.getOwner());
        idPost= postLike.getPost().getId();
    }
}
