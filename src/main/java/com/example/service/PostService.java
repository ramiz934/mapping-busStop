package com.example.service;

import com.example.entity.Post;
import com.example.payload.PostDto;
import com.example.repositoty.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {


    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostDto addPost(PostDto postDto) {
        Post post = mapToEntity(postDto);
        Post save = postRepository.save(post);
        return mapToDto(save);
    }

    PostDto mapToDto(Post post){
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        return postDto;
    }
    Post mapToEntity(PostDto postDto){
        Post post = new Post();
        //post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        return post;
    }
}
