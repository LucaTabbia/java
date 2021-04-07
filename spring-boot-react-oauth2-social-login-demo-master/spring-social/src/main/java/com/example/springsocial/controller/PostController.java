package com.example.springsocial.controller;

import com.example.springsocial.exception.ResourceNotFoundException;
import com.example.springsocial.model.Comment;
import com.example.springsocial.model.Photo;
import com.example.springsocial.model.Post;
import com.example.springsocial.model.User;
import com.example.springsocial.payload.PostAddRequest;
import com.example.springsocial.payload.PostResponse;
import com.example.springsocial.repository.PhotoRepository;
import com.example.springsocial.repository.PostRepository;
import com.example.springsocial.repository.UserRepository;
import com.example.springsocial.security.CurrentUser;
import com.example.springsocial.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PhotoRepository photoRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/post/all")
//    @PreAuthorize("hasRole('USER')")
    public List<PostResponse> getPosts() {
        List<PostResponse> postResponses = new ArrayList<>();
        List<Post> posts= postRepository.findAll();
        for(Post p: posts){
            PostResponse postResponse= new PostResponse(p);
            postResponses.add(postResponse);
        }
        return postResponses;
    }
    @PostMapping("/post/add")
    public PostResponse addPost(@CurrentUser UserPrincipal userPrincipal, @RequestBody PostAddRequest postAddRequest){
        User currentUser= userRepository.findById(userPrincipal.getId())
                .orElseThrow(()-> new ResourceNotFoundException("User", "id", userPrincipal.getId()));

        Post post= new Post();
        post.setOwner(currentUser);
        post.setComments(new ArrayList<Comment>());
        post.setDate(new Date());
        post.setPostLikes(new ArrayList<>());
        post.setDescription(postAddRequest.getDescription());
        Photo photo= photoRepository.findById(postAddRequest.getIdPhoto())






















                .orElseThrow(()-> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
        photo.setOwner(currentUser);
        post.setPhoto(photo);

        postRepository.save(post);
        PostResponse postResponse= new PostResponse(post);
        return postResponse;
    }
    @PostMapping("/post/photo/add")
    public Long addPhoto(@CurrentUser UserPrincipal userPrincipal, @RequestParam("file") MultipartFile file){
        User currentUser= userRepository.findById(userPrincipal.getId())
                .orElseThrow(()-> new ResourceNotFoundException("User", "id", userPrincipal.getId()));

        Photo photo= new Photo();
        photo.setOwner(currentUser);
        try{
            photo.setPicture(file.getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }

        return photoRepository.save(photo).getId();
    }

}
