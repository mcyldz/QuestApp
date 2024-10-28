package org.mcyldz.questapp.service;

import org.mcyldz.questapp.model.Post;
import org.mcyldz.questapp.model.User;
import org.mcyldz.questapp.repository.PostRepository;
import org.mcyldz.questapp.request.PostCreateRequest;
import org.mcyldz.questapp.request.PostUpdateRequest;
import org.mcyldz.questapp.response.LikeResponse;
import org.mcyldz.questapp.response.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserService userService;
    private LikeService likeService;

    public PostService(PostRepository postRepository, UserService userService){
        this.postRepository = postRepository;
        this.userService = userService;
    }

    @Autowired
    @Lazy
    public void setLikeService(LikeService likeService) {
        this.likeService = likeService;
    }

    public List<PostResponse> getAllPosts(Optional<Integer> userId) {

        List<Post> list;

        if (userId.isPresent()){
            list = postRepository.findByUserId(userId.get());
            return null;
        }
        else {
            list = postRepository.findAll();
            return list.stream().map(p -> {
                List<LikeResponse> likes = likeService.getAllLikesWithParam(Optional.ofNullable(null), Optional.of(p.getId()));
                return new PostResponse(p, likes);
            }).collect(Collectors.toList());
        }
    }

    public Post getOnePostById(Integer postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public Post createOnePost(PostCreateRequest newPostRequest) {

        User user = userService.getOneUserById(newPostRequest.getUserId());

        if(user == null){
            return null;
        }

        Post toSave = new Post();

        toSave.setTitle(newPostRequest.getTitle());
        toSave.setText(newPostRequest.getText());
        toSave.setUser(user);
        toSave.setCreateDate(new Date());

        return postRepository.save(toSave);
    }

    public Post updateOnePostById(Integer postId, PostUpdateRequest postUpdateRequest) {

        Optional<Post> post = postRepository.findById(postId);

        if (post.isPresent()){

            Post toUpdate = post.get();
            toUpdate.setTitle(postUpdateRequest.getTitle());
            toUpdate.setText(postUpdateRequest.getText());

            postRepository.save(toUpdate);

            return toUpdate;
        }
        return null;
    }

    public void deleteOnePostById(Integer postId) {
        postRepository.deleteById(postId);
    }

    public PostResponse getOnePostByIdWithLikes(Integer postId) {
        Post post = postRepository.findById(postId).orElse(null);
        List<LikeResponse> likes = likeService.getAllLikesWithParam(Optional.ofNullable(null), Optional.of(postId));
        return new PostResponse(post, likes);
    }

}
