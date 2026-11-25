package com.learning.prod_ready_features.service;

import com.learning.prod_ready_features.dto.PostDto;
import com.learning.prod_ready_features.entites.PostEntity;
import com.learning.prod_ready_features.exception.ResourceNotFoundException;
import com.learning.prod_ready_features.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImplementation implements  PostService {

    private final PostRepository postRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<PostDto> getAllPosts() {
      return  postRepository.findAll()
                .stream()
                .map(postEntity -> modelMapper.map(postEntity,PostDto.class ))
                .collect(Collectors.toList());
    }

    @Override
    public PostDto createNewPost(PostDto inputPost) {
        PostEntity postEntity=modelMapper.map(inputPost,PostEntity.class);
        return modelMapper.map(postRepository.save(postEntity),PostDto.class);
    }

    @Override
    public PostDto getPostById(Long postId) {
        return modelMapper.map(
                postRepository
                        .findById(postId)
                        .orElseThrow(()->new ResourceNotFoundException("post not found with id: "+postId))
                ,PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto inputPost, Long postId) {
        postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("post not found"));
        PostEntity postEntity=modelMapper.map(inputPost,PostEntity.class);
        postEntity.setId(postId);
        PostEntity updatedPostEntity=postRepository.save(postEntity);
        return modelMapper.map(updatedPostEntity,PostDto.class);
    }
}
