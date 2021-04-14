package com.example.springsocial.payload;

public class CommentChangeRequest {
    private Long idPost;
    private String text;
    private Long idComment;

    public Long getIdPost() { return idPost; }

    public Long getCommentId() { return idComment; }

    public String getText() { return text; }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setIdComment(Long idComment) {
        this.idComment = idComment;
    }
}
