package com.example.springsocial.payload;

public class PostAddRequest {
    private String description;
    private Long idPhoto;

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public Long getIdPhoto() { return idPhoto; }

    public void setIdPhoto(Long idPhoto) { this.idPhoto = idPhoto; }
}
