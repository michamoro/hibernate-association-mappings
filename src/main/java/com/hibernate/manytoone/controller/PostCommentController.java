package com.hibernate.manytoone.controller;

import com.hibernate.manytoone.model.Post;
import com.hibernate.manytoone.model.PostComment;
import com.hibernate.manytoone.repository.PostCommentRepository;
import com.hibernate.manytoone.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/post-comment")
@AllArgsConstructor
public class PostCommentController {

    private final PostCommentRepository postCommentRepository;
    private final PostRepository postRepository;

    @GetMapping
    public List<PostComment> getPostComments() {
        return postCommentRepository.findAll();
    }

    @PostMapping
    public PostComment savePostComment(@RequestBody PostComment postComment) {
        Post post = postRepository.findById(postComment.getPost().getId()).orElse(null);
        postComment.setPost(post);
        return postCommentRepository.save(postComment);
    }
}
