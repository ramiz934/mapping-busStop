package com.example.service;

import com.example.entity.Comment;
import com.example.entity.Post;
import com.example.payload.CommentDto;
import com.example.payload.PostDto;
import com.example.repositoty.CommentRepository;
import com.example.repositoty.PostRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {

    private final PostRepository postRepository;
    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    CommentDto mapToDto(Comment comment){
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setEmail(comment.getEmail());
        commentDto.setContent(comment.getContent());
        commentDto.setPost(comment.getPost());
        return commentDto;
    }
    Comment mapToEntity(CommentDto commentDto){
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setEmail(commentDto.getEmail());
        comment.setContent(commentDto.getContent());
        comment.setPost(commentDto.getPost());
        return comment;
    }

    public CommentDto createComment(CommentDto commentDto,long postId) {
        Optional<Post> byId = postRepository.findById(postId);
        Post post = byId.get();
        commentDto.setPost(post);
        Comment comment = mapToEntity(commentDto);
        Comment savedEntity = commentRepository.save(comment);
        return mapToDto(savedEntity);
    }
}
