package com.example.springsocial.repository;

import com.example.springsocial.model.Post;
import com.example.springsocial.model.PostLike;
import com.example.springsocial.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostLikeRepository extends JpaRepository<PostLike, Long > {
    boolean existsByOwnerAndPost(User owner, Post post);
}