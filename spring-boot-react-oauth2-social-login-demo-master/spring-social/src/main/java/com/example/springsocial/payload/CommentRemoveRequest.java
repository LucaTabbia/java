package com.example.springsocial.payload;

public class CommentRemoveRequest {
    private Long idPost;

    private Long idComment;

    public Long getIdPost() { return idPost; }

    public Long getCommentId() { return idComment; }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
    }

    public void setIdComment(Long idComment) {
        this.idComment = idComment;
    }
}
