package com.example.payload;

import com.example.entity.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {

    private long id;

    private String email;

    private String content;

    private Post post;
}
