package org.mcyldz.questapp.controller;

import org.mcyldz.questapp.model.Post;
import org.mcyldz.questapp.request.PostCreateRequest;
import org.mcyldz.questapp.request.PostUpdateRequest;
import org.mcyldz.questapp.response.PostResponse;
import org.mcyldz.questapp.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping
    public List<PostResponse> getAllPosts(@RequestParam Optional<Integer> userId){
        return postService.getAllPosts(userId);
    }

    @GetMapping("/{postId}")
    public PostResponse getOnePostById(@PathVariable Integer postId){
        return postService.getOnePostByIdWithLikes(postId);
    }

    @PostMapping
    public Post createOnePost(@RequestBody PostCreateRequest newPostRequest){
        return postService.createOnePost(newPostRequest);
    }

    @PutMapping("/{postId}")
    public Post updateOnePost(@PathVariable Integer postId, @RequestBody PostUpdateRequest postUpdateRequest){
        return postService.updateOnePostById(postId, postUpdateRequest);
    }

    @DeleteMapping("/{postId}")
    public void deleteOnePost(@PathVariable Integer postId){
        postService.deleteOnePostById(postId);
    }


}
