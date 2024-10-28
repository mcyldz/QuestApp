package org.mcyldz.questapp.service;

import org.mcyldz.questapp.model.Like;
import org.mcyldz.questapp.model.Post;
import org.mcyldz.questapp.model.User;
import org.mcyldz.questapp.repository.LikeRepository;
import org.mcyldz.questapp.request.LikeCreateRequest;
import org.mcyldz.questapp.response.LikeResponse;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LikeService {

    private final LikeRepository likeRepository;
    private final UserService userService;
    private final PostService postService;

    public LikeService(LikeRepository likeRepository,@Lazy UserService userService,@Lazy PostService postService){
        this.likeRepository = likeRepository;
        this.userService = userService;
        this.postService = postService;
    }

    public List<LikeResponse> getAllLikesWithParam(Optional<Integer> userId, Optional<Integer> postId) {

        List<Like> list;

        if (userId.isPresent() && postId.isPresent()){

            User user = userService.getOneUserById(userId.get());
            Post post = postService.getOnePostById(postId.get());

            list = likeRepository.findByUserIdAndPostId(user.getId(), post.getId());
        }
        else if(userId.isPresent()){

            User user = userService.getOneUserById(userId.get());

            list = likeRepository.findByUserId(user.getId());
        }
        else if(postId.isPresent()){

            Post post = postService.getOnePostById(postId.get());

            list = likeRepository.findByPostId(post.getId());
        }
        else list = likeRepository.findAll();

        return list.stream().map(like -> new LikeResponse(like)).collect(Collectors.toList());
    }

    public Like createOneLike(LikeCreateRequest likeCreateRequest) {

        User user = userService.getOneUserById(likeCreateRequest.getUserId());
        Post post = postService.getOnePostById(likeCreateRequest.getPostId());

        if (user != null && post != null){

            Like toLikeCreate = new Like();
            toLikeCreate.setUser(user);
            toLikeCreate.setPost(post);
            return likeRepository.save(toLikeCreate);
        }
        else return null;
    }

    public void deleteOneLikeById(Integer likeId) {
        likeRepository.deleteById(likeId);
    }

}
