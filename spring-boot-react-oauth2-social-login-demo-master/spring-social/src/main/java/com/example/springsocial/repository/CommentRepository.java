package com.example.springsocial.repository;

import com.example.springsocial.model.Comment;
import com.example.springsocial.model.Post;
import com.example.springsocial.model.PostLike;
import com.example.springsocial.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    boolean existsByOwnerAndPost(User owner, Post post);

    Comment getByOwnerAndPostAndId(User owner, Post post,Long id);
}
