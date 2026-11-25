package com.learning.prod_ready_features.service;

import com.learning.prod_ready_features.dto.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostService {

    List<PostDto> getAllPosts();

    PostDto createNewPost(PostDto inputPost);

    PostDto getPostById(Long postId);
}
